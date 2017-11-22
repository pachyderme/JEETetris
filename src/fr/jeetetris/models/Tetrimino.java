package fr.jeetetris.models;

public class Tetrimino {
	public enum TetriminoForm {
		  L,
		  I,
		  SQUARE;
		}
	
	private TetriminoForm form;
	private String color ;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	
	public Tetrimino(TetriminoForm form, String color, String name) {
		super();
		this.form = form;
		this.color = color;
		this.name = name;
	}
}
