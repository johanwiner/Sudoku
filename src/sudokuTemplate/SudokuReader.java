package sudokuTemplate;

import java.io.*;
import java.util.*;

/**
 * SudokuReader: Imports example sudokus from a txt. file in relative path "Files/sudokuExamples".
 * @author Johan W
 *
 */
public class SudokuReader {
	private Scanner s;
	private String filename;
	
	/** 
	 * Creates a scanner that reads from specified file.
	 * @param filename: Path to file to read from.
	 */
	public SudokuReader(String filename) {
		try {
			s = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.print("File not found.");
		}
		this.filename = filename;
	}
	
	/**
	 * Reads the next sudoku in the specified file.
	 * Starts over if "end" is encountered.
	 * @return next sudoku in file in a matrix 9x9.
	 */
	public int[][] readNextSudoku () {
		int[][] sudoku = new int[9][9];
		String line;
		Scanner ls;
		
		for (int i = 0; i < 9; i++) {
			//Read the first line in the file.
			line = s.nextLine();
			if (line.compareTo("end") != 0) {
				//New scanner for reading next line
				ls = new Scanner(line);
				for( int j = 0; j < 9; j++) {
					sudoku[i][j] = ls.nextInt();
				}
				//Close the scanner.
				ls.close();
			} else {
				//We have reached the end of the file. Start over from the top of the file.
				try {
					s = new Scanner(new File(filename));
				} catch (FileNotFoundException e) {
					System.out.print("File not found. Check the path defined in SudokuTest.java.");
				}
				return readNextSudoku();
			}
		}
		s.nextLine();
		return sudoku;
	}
}
