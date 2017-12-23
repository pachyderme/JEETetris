package fr.jeetetris.controller;

import java.util.ArrayList;
import java.util.List;

import fr.jeetetris.models.Student;

public class StudentTestForm {
	private Student student;
	private List<String> testsIds;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public List<String> getTestsIds() {
		return testsIds;
	}

	public void setTestsIds(List<String> testsIds) {
		this.testsIds = testsIds;
	}

	public StudentTestForm() {
		this.student = new Student();
		this.testsIds = new ArrayList<String>();
	}

	public StudentTestForm(Student student, List<String> testsIds) {
		this.student = student;
		this.testsIds = testsIds;
	}
}
