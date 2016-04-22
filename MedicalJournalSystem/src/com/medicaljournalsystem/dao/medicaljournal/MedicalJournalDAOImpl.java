package com.medicaljournalsystem.dao.medicaljournal;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medicaljournalsystem.pojo.MedicalJournal;

@Repository
public class MedicalJournalDAOImpl implements MedicalJournalDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public MedicalJournalDAOImpl() {

	}

	public MedicalJournalDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<MedicalJournal> list() {
		// @SuppressWarnings("unchecked")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(MedicalJournal.class);
		List results = cr.list();

		return results;
	}

	@Override
	@Transactional
	public MedicalJournal get(int id) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(MedicalJournal.class);
		cr.add(Restrictions.eq("id", id)).uniqueResult();
		List results = cr.list();
		MedicalJournal journal = (MedicalJournal) results.get(0);

		return journal;

	}

	@Override
	@Transactional
	public void saveOrUpdate(MedicalJournal journal) {
		sessionFactory.getCurrentSession().saveOrUpdate(journal);
	}

	@Override
	@Transactional
	public void delete(int id) {
		MedicalJournal journalToDelete = new MedicalJournal();
		journalToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(journalToDelete);
	}

}
