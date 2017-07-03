package main;

public class MinefieldBuilder {
	
	private int lines;
	private int columns;
	private String minefieldToConstroy;
	
	public MinefieldBuilder() {
		minefieldToConstroy = "";
	}

	public MinefieldBuilder withLine(String line) {
		minefieldToConstroy = minefieldToConstroy.concat(line).concat("\n");
		return this;
	}
	
	public MinefieldBuilder withNumberOfLines(int lines) {
		this.lines = lines;
		return this;
	}
	
	public MinefieldBuilder withNumberOfColumns(int columns) {
		this.columns = columns;
		return this;
	}
	
	public Minefield resolve() {
		Minefield minefield = new Minefield(minefieldToConstroy, lines, columns);
		return ResolveMinefield.resolve(minefield);
	}

}
