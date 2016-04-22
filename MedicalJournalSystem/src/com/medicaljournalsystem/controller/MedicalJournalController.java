package com.medicaljournalsystem.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
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

import com.medicaljournalsystem.dao.medicaljournal.MedicalJournalDAO;
import com.medicaljournalsystem.pojo.MedicalJournal;

@Controller
@RequestMapping(value = "medicaljournals")
public class MedicalJournalController {

	@Autowired
	private MedicalJournalDAO medicalJournalDao;

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
	public ModelAndView searchJournals(@RequestParam(value = "q", required = false) String query) {

		List<MedicalJournal> listJournals = medicalJournalDao.find(query);
		ModelMap model = new ModelMap();
		model.put("query", query);
		model.put("journals", listJournals);

		return new ModelAndView("medicaljournal/search", "model", model);
	}

	@RequestMapping(value = "/subscribe", method = RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	public String searchJournals(@RequestParam(value = "sub", required = true) boolean sub,
			@RequestParam(value = "id", required = true) Integer journalId) {

		return "subscribed";
	}
}
