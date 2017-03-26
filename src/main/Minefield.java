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
		String[] linesString = minefieldToConstroy.split("\n");
		for (int i = 0; i < lines; i++) {
			String[] squares = linesString[i].split(" ");
			for (int j = 0; j < columns; j++) {
				minefield[i][j] = squares[j];
			}
		}
	}

	private String minefieldToString() {
		String newMinefield = "";
		for(int i = 0; i < lines; i++) {
			for(int j = 0; j < columns; j++) {
				newMinefield = newMinefield.concat(minefield[i][j] + " ");
			}
			newMinefield = newMinefield.trim();
			newMinefield = newMinefield.concat("\n");
		}
		newMinefield = newMinefield.trim();
		return newMinefield;
	}

	public void resolve() {
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < columns; j++) {
				if(isMine(i, j)) {
					this.mines++;
				} else {
					fillTips(i, j);
				}
			}
		}
	}

	private void fillTips(int line, int column) {
		int count = 0;

		if(line - 1 >= 0) {
			if(isMine(line - 1, column)) count++;
			if(column - 1 >= 0 && isMine(line - 1, column - 1)) count++;
			if(column + 1 < columns && isMine(line - 1, column + 1)) count++;
		}

		if(column - 1 >= 0 && isMine(line, column - 1)) count++;
		if(column + 1 < columns && isMine(line, column + 1)) count++;

		if(line + 1 < lines) {
			if(isMine(line + 1, column)) count++;
			if(column - 1 >= 0 && isMine(line + 1, column - 1)) count++;
			if(column + 1 < columns && isMine(line + 1, column + 1)) count++;
		}

		minefield[line][column] = String.valueOf(count);
	}

	private boolean isMine(int line, int column) {
		return minefield[line][column].equals("*");
	}

	public int getMines() {
		return mines;
	}

	public String getMinefield() {
		return minefieldToString();
	}

}
