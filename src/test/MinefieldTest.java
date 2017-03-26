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
		minefield.resolve();
		assertEquals(2, minefield.getMines());
	}

}
