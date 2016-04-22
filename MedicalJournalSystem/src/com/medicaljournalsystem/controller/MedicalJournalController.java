package com.medicaljournalsystem.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.medicaljournalsystem.dao.UserDAO;
import com.medicaljournalsystem.dao.medicaljournal.MedicalJournalDAO;
import com.medicaljournalsystem.pojo.MedicalJournal;
import com.medicaljournalsystem.pojo.Users;

@Controller
@RequestMapping(value = "medicaljournals")
public class MedicalJournalController {

	@Autowired
	private MedicalJournalDAO medicalJournalDao;
	@Autowired
	private UserDAO userDao;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView createJournal(Model model) {
		model.addAttribute("journal", new MedicalJournal());
		return new ModelAndView("medicaljournal/createForm", "model", model);
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editMedicalJournal(@PathVariable("id") int id, Model model) {
		model.addAttribute("journal", medicalJournalDao.get(id));
		return new ModelAndView("medicaljournal/createForm", "model", model);
	}

	// For both add and update
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ModelAndView saveJournal(@ModelAttribute("journal") MedicalJournal journal, BindingResult result,
			ModelMap model, HttpServletRequest request) throws IOException {

		MultipartFile pdfFile = journal.getPdfFile();

		if (pdfFile != null) {
			ServletContext ctx = request.getServletContext();
			String pdfFolder = ctx.getRealPath("/pdf");

			String fileName = pdfFile.getOriginalFilename();
			if (!"".equalsIgnoreCase(fileName)) {
				String filePath = pdfFolder + File.separator + UUID.randomUUID().toString();
				pdfFile.transferTo(new File(filePath));
				journal.setFilePath(filePath);
				journal.setFileName(fileName);
			}
		}

		medicalJournalDao.saveOrUpdate(journal);
		return new ModelAndView("redirect:/medicaljournals/");

	}

	@RequestMapping("/delete/{id}")
	public String removeMedicalJournal(@PathVariable("id") int id) {

		medicalJournalDao.delete(id);
		return "redirect:/medicaljournals/";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listJournals() {

		List<MedicalJournal> listJournals = medicalJournalDao.list();
		ModelMap model = new ModelMap();
		model.put("journals", listJournals);

		return new ModelAndView("medicaljournal/list", "model", model);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchJournals(@RequestParam(value = "q", required = false) String query, Principal principal) {

		Users currentUser = userDao.getByEmail(principal.getName());

		List<MedicalJournal> listJournals = medicalJournalDao.find(query);
		// for all medicalJournals in list set if subscribed by current user
		for (MedicalJournal medicalJournal : listJournals) {
			if (medicalJournal.getUsers().stream().filter(s -> s.getId() == currentUser.getId()).findFirst()
					.isPresent()) {
				medicalJournal.setSubscribedByCurrentUser(true);
			}
		}
		ModelMap model = new ModelMap();
		model.put("query", query);
		model.put("journals", listJournals);

		return new ModelAndView("medicaljournal/search", "model", model);
	}

	@RequestMapping(value = "/subscribe", method = RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	public String subscribeToJournal(@RequestParam(value = "sub", required = true) boolean subscribe,
			@RequestParam(value = "id", required = true) Integer journalId, Principal principal) {

		Users currentUser = userDao.getByEmail(principal.getName());

		if (subscribe) {
			MedicalJournal journal = medicalJournalDao.get(journalId);
			if (journal != null) {
				currentUser.getSubscribedMedicalJournals().add(journal);
				userDao.saveOrUpdate(currentUser);
				return "true";
			} else {
				return "false";
			}
		} else {
			Optional<MedicalJournal> medJ = currentUser.getSubscribedMedicalJournals().stream()
					.filter(j -> j.getId() == journalId).findFirst();
			if (medJ.isPresent()) {
				currentUser.getSubscribedMedicalJournals().remove(medJ.get());
				userDao.saveOrUpdate(currentUser);
				return "true";
			} else {
				return "false";
			}
		}
	}
}
