package main;

public class Minefield {

	private String[][] originalMinefield;
	private String resolvedMinefield;
	private int lines;
	private int columns;
	private int mines;

	public Minefield(String minefieldToConstroy, int lines, int columns) {
		this.originalMinefield = MinefieldFormatter.formatToArray(minefieldToConstroy, lines, columns);
		this.lines = lines;
		this.columns = columns;
	}

	public String[][] getMinefield() {
		return originalMinefield;
	}

	public int getLines() {
		return lines;
	}

	public int getColumns() {
		return columns;
	}
	
	public int getMines() {
		return mines;
	}
	
	public void setMines(int mines) {
		this.mines = mines;
	}
	
	public String getResolvedMinefield() {
		return resolvedMinefield;
	}

	public void setResolvedMinefield(String[][] resolvedMinefield) {
		this.resolvedMinefield = MinefieldFormatter.formatToString(resolvedMinefield);
	}
 }
