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
		resolve();
	}

	private void resolve() {
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

		for(int x = -1; x<=1; x++){
		    if ( line+x < lines && line+x >= 0){
		        for(int y = -1; y<=1; y++){
		            if(column+y < columns && column+y >= 0 && isMine(line+x, column+y)){
		            	count++;
		            }
		        }
		    }
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

}
