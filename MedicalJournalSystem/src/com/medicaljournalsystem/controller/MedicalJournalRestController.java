package com.medicaljournalsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medicaljournalsystem.dao.MedicalJournalDAO;
import com.medicaljournalsystem.dao.UserDAO;
import com.medicaljournalsystem.pojo.MedicalJournal;

@Controller
@RequestMapping(value = "rest")
public class MedicalJournalRestController {

	@Autowired
	private MedicalJournalDAO medicalJournalDao;
	@Autowired
	private UserDAO userDao;

	@ResponseBody
	@RequestMapping(value = "/journals", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MedicalJournal> listJournals() {

		List<MedicalJournal> listJournals = medicalJournalDao.list();
		return listJournals;
	}

}
