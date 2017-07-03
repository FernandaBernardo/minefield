package main;

public class MinefieldFormatter {
	public static String[][] formatToArray(String minefield, int lines, int columns) {
		String[][] formattedMinefield = new String[lines][columns];
		String[] linesString = minefield.split("\n");
		for (int i = 0; i < lines; i++) {
			String[] squares = linesString[i].split(" ");
			for (int j = 0; j < columns; j++) {
				formattedMinefield[i][j] = squares[j];
			}
		}
		return formattedMinefield;
	}
	
	public static String formatToString(String[][] minefield) {
		String formattedMinefield = "";
		
		for(String[] line : minefield) {
			for(String field : line) {
				formattedMinefield = formattedMinefield.concat(field).concat(" ");
			}
			formattedMinefield = formattedMinefield.trim().concat("\n");
		}
		
		return formattedMinefield.trim();
	}
}
