package fr.jeetetris.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tetrimino {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String color;
	private String name;
	
	@ManyToOne
	private Tetris tetris;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public Tetrimino(String color, String name) {
		super();
		this.color = color;
		this.name = name;
	}
	
	public Tetrimino() {
		super();
	}
}
