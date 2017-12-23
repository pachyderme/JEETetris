package fr.jeetetris.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("1")
public class Student extends User {
	
	private Set<StudentTest> studentTests = new HashSet<StudentTest>(0);

	@OneToMany(mappedBy = "id.student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	public Set<StudentTest> getStudentTests() {
		return studentTests;
	}

	public void setStudentTests(Set<StudentTest> studentTests) {
		this.studentTests = studentTests;
	}

	public Student() {
		super();
	}

	public Student(Set<StudentTest> studentTests) {
		super();

		this.studentTests = studentTests;
	}
}
