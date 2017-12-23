package fr.jeetetris.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Test {

	private int id;
	
	private String label;
	
	private Formation formation;
	
	private List<Quiz> quizzes;
	
	private Set<StudentTest> studentTests = new HashSet<StudentTest>(0);
	
	@OneToMany(mappedBy = "id.test", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	public Set<StudentTest> getStudentTests() {
		return studentTests;
	}

	public void setStudentTests(Set<StudentTest> studentTests) {
		this.studentTests = studentTests;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@ManyToOne
	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	@ManyToMany(mappedBy="tests") 
	public List<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Test() {
		super();
	}
}
