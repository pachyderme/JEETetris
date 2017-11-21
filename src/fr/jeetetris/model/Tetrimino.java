package fr.jeetetris.model;

public class Tetrimino {
	public enum TetriminoForm {
		  L,
		  I,
		  SQUARE;
		}
	
	private TetriminoForm form;
	private String color ;
	
	public TetriminoForm getForm() {
		return form;
	}
	public void setForm(TetriminoForm form) {
		this.form = form;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public Tetrimino(TetriminoForm form, String color) {
		super();
		this.form = form;
		this.color = color;
	}
}
