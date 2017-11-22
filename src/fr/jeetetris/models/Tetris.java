package fr.jeetetris.models;

import java.util.ArrayList;
import java.util.List;

public class Tetris {
	private List<Tetrimino> tetriminos;
	private int score;
	
	public List<Tetrimino> getTetriminos() {
		return tetriminos;
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
	public void setTetriminos(List<Tetrimino> tetriminos) {
		this.tetriminos = tetriminos;
	}
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
