package com.medicaljournalsystem.dao.medicaljournal;

import java.util.List;

import com.medicaljournalsystem.pojo.MedicalJournal;

public interface MedicalJournalDAO {

	public List<MedicalJournal> list();

	public MedicalJournal get(int id);

	public void saveOrUpdate(MedicalJournal journal);

	public void delete(int id);

	public List<MedicalJournal> find(String query);

}
