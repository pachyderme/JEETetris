package fr.tp.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Quiz {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="quiz", cascade = CascadeType.REMOVE)
	private List<Question> questions;
	
	@ManyToMany
	private List<Test> tests;
	
	@ManyToOne
	private Subject subject;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public List<Test> getTests() {
		return tests;
	}
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public Quiz() {
		super();
	}
	
	public Quiz(int id, List<Question> questions, List<Test> tests, Subject subject) {
		super();
		this.id = id;
		this.questions = questions;
		this.tests = tests;
		this.subject = subject;
	}
	
	
}
