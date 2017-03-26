package main;

public class Minefield {

	private String[][] minefield;
	private int lines;
	private int columns;
	private int mines;

	public Minefield(String minefieldToConstroy, int lines, int columns) {
		this.lines = lines;
		this.columns = columns;
		formatMinefield(minefieldToConstroy);
	}

	private void formatMinefield(String minefieldToConstroy) {
		this.minefield = new String[lines][columns];
		String[] lines = minefieldToConstroy.split("\n");
		for (int i = 0; i < lines.length; i++) {
			String[] squares = lines[i].split(" ");
			for (int j = 0; j < squares.length; j++) {
				minefield[i][j] = squares[j];
			}
		}
	}

	public void resolve() {
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < columns; j++) {
				if(isMine(minefield[i][j])) {
					this.mines++;
				}
			}
		}
	}

	private boolean isMine(String square) {
		return square.equals("*");
	}

	public int getMines() {
		return mines;
	}
}
