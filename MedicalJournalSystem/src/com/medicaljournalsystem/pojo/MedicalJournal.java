package com.medicaljournalsystem.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "medical_journal")
public class MedicalJournal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date releaseDate;
	@Column
	private String filePath;
	@Column
	private String fileName;

	@ManyToMany(mappedBy = "subscribedMedicalJournals", fetch = FetchType.EAGER)
	private Set<Users> users = new HashSet<Users>();

	@Transient
	private MultipartFile pdfFile;

	@Transient
	private boolean subscribedByCurrentUser = false;

	public MedicalJournal() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@JsonIgnore
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@JsonIgnore
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@JsonIgnore
	public MultipartFile getPdfFile() {
		return pdfFile;
	}

	public void setPdfFile(MultipartFile pdfFile) {
		this.pdfFile = pdfFile;
	}

	@JsonIgnore
	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	@JsonIgnore
	public boolean isSubscribedByCurrentUser() {
		return subscribedByCurrentUser;
	}

	public void setSubscribedByCurrentUser(boolean subscribedByCurrentUser) {
		this.subscribedByCurrentUser = subscribedByCurrentUser;
	}

}
