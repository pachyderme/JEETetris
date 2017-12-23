package fr.jeetetris.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	@OneToMany(mappedBy="question", cascade = CascadeType.REMOVE)
	private List<Response> responses;
	
	private int points;
	
	@ManyToOne
	private Quiz quiz;
	
	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
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
	
	public List<Response> getResponses() {
		return responses;
	}
	
	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public Question() {
		super();
	}
	
	public Question(int id, String title, List<Response> responses, int points) {
		super();
		this.id = id;
		this.title = title;
		this.responses = responses;
		this.points = points;
	}
}
