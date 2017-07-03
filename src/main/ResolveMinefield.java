package main;

public class ResolveMinefield {
	public static Minefield resolve(Minefield minefield) {
		return resolveMines(minefield);
	}
	
	private static Minefield resolveMines(Minefield minefield) {
		String[][] resolvedMinefield = minefield.getMinefield(); 
		int mines = 0;
		for (int i = 0; i < minefield.getLines(); i++) {
			for (int j = 0; j < minefield.getColumns(); j++) {
				if(isMine(minefield, i, j)) {
					mines++;
				} else {
					resolvedMinefield[i][j] = fillTips(minefield, i, j);
				}
			}
		}
		minefield.setMines(mines);
		minefield.setResolvedMinefield(resolvedMinefield);
		
		return minefield;
	}
	
	private static String fillTips(Minefield minefield, int line, int column) {
		int count = 0;

		for(int x = -1; x <= 1; x++){
		    if ( line+x < minefield.getLines() && line+x >= 0){
		        for(int y = -1; y<=1; y++){
		            if(column+y < minefield.getColumns() && column+y >= 0 && isMine(minefield, line+x, column+y)){
		            	count++;
		            }
		        }
		    }
		}
		return String.valueOf(count);
	}
	
	private static boolean isMine(Minefield minefield, int line, int column) {
		return minefield.getMinefield()[line][column].equals("*");
	}
}
