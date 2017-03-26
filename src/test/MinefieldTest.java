package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Minefield;

public class MinefieldTest {

	@Test
	public void shouldCountMines() {
		Minefield minefield = new Minefield("* . . .\n"
				+ ". . . .\n"
				+ ". * . .\n"
				+ ". . . .\n", 4, 4);
		assertEquals(2, minefield.getMines());
	}

	@Test
	public void shouldResolveMinefieldWithCenterMines() {
		Minefield minefield = new Minefield("* . . .\n"
				+ ". . . .\n"
				+ ". * . .\n"
				+ ". . . .\n", 4, 4);
		String expected = "* 1 0 0\n"
				+ "2 2 1 0\n"
				+ "1 * 1 0\n"
				+ "1 1 1 0";
		assertEquals(expected, minefield.getMinefield());
	}
}
