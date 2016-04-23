package com.medicaljournalsystem.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medicaljournalsystem.dao.MedicalJournalDAO;
import com.medicaljournalsystem.dao.UserDAO;
import com.medicaljournalsystem.pojo.MedicalJournal;
import com.medicaljournalsystem.pojo.Users;

@Controller
@RequestMapping(value = "rest")
public class MedicalJournalRestController {

	@Autowired
	private MedicalJournalDAO medicalJournalDao;
	@Autowired
	private UserDAO userDao;

	@ResponseBody
	@RequestMapping(value = "/journals", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<MedicalJournal> listJournals(Principal principal) {

		Users currentUser = userDao.getByEmail(principal.getName());
		if (currentUser == null) {
			return null;
		}

		Set<MedicalJournal> listJournals = currentUser.getSubscribedMedicalJournals();
		return listJournals;
	}

	@RequestMapping(value = "/journals/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public FileSystemResource getFile(@PathVariable("id") int journalId) {
		// get the journal from DB
		MedicalJournal journal = medicalJournalDao.get(journalId);
		// see if the user is subscribed to the journal
		// TODO
		// if all good then return the file content
		return new FileSystemResource(journal.getFilePath());
	}

}
