package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Minefield;
import main.MinefieldBuilder;

public class MinefieldTest {

	@Test
	public void shouldCountMines() {
		Minefield minefield = new MinefieldBuilder()
			.withLine("* . . .")
			.withLine(". . . .")
			.withLine(". * . .")
			.withLine(". . . .")
			.withNumberOfColumns(4)
			.withNumberOfLines(4)
			.resolve();
		
		assertEquals(2, minefield.getMines());
	}

	@Test
	public void shouldResolveMinefieldWithCenterMines() {
		Minefield minefield = new MinefieldBuilder()
				.withLine("* . . .")
				.withLine(". . . .")
				.withLine(". * . .")
				.withLine(". . . .")
				.withNumberOfColumns(4)
				.withNumberOfLines(4)
				.resolve();
		String expected = "* 1 0 0\n"
				+ "2 2 1 0\n"
				+ "1 * 1 0\n"
				+ "1 1 1 0";
		assertEquals(expected, minefield.getResolvedMinefield());
	}
}
