package fr.jeetetris.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tetris {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="tetris")
	private List<Tetrimino> tetriminos;
	
	private int score;
	
	public List<Tetrimino> getTetriminos() {
		return tetriminos;
	}
	
	public void setTetriminos(List<Tetrimino> tetriminos) {
		this.tetriminos = tetriminos;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public Tetris(List<Tetrimino> tetriminos, int score) {
		super();
		this.tetriminos = tetriminos;
		this.score = score;
	}
	public Tetris() {
		tetriminos = new ArrayList<Tetrimino>();
		this.score = 0;
	}
}
