package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transcripts")
public class Transcript {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transcriptId;
	private String degreeTitle;
	
	@OneToOne
	@JoinColumn(name = "student_fk", nullable = false, unique = true)
	private Student student;
	
	
	public Transcript(String degreeTitle) {
		super();
		this.degreeTitle = degreeTitle;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public long getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(long transcriptId) {
		this.transcriptId = transcriptId;
	}

	public String getDegreeTitle() {
		return degreeTitle;
	}

	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}
	
	
}
