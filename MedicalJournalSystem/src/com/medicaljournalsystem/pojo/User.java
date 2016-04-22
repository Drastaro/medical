package com.medicaljournalsystem.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String email;

	@Column
	private String password;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "users_medical_journals", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "medical_journal_id") })
	private Set<MedicalJournal> subscribedMedicalJournals;

	public User() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<MedicalJournal> getSubscribedMedicalJournals() {
		return subscribedMedicalJournals;
	}

	public void setSubscribedMedicalJournals(Set<MedicalJournal> subscribedMedicalJournals) {
		this.subscribedMedicalJournals = subscribedMedicalJournals;
	}

}
