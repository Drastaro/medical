package com.medicaljournalsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.medicaljournalsystem.dao.medicaljournal.MedicalJournalDAO;
import com.medicaljournalsystem.pojo.MedicalJournal;

@Controller
@RequestMapping(value = "medicaljournals")
public class MedicalJournalController {

	@Autowired
	private MedicalJournalDAO medicalJournalDao;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView createJournal() {

		return new ModelAndView("medicaljournal/createForm", "journal", new MedicalJournal());

	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ModelAndView saveJournal(@ModelAttribute("journal") MedicalJournal journal, BindingResult result,
			ModelMap model) {
		medicalJournalDao.saveOrUpdate(journal);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listJournals() {

		List<MedicalJournal> listJournals = medicalJournalDao.list();
		ModelMap model = new ModelMap();
		model.put("journals", listJournals);

		return new ModelAndView("medicaljournal/list", "model", model);
	}
}
