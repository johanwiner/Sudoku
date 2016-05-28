package sudokuMain;

import sudokuTemplate.*;
import userInterface.UserInterface;

/**
 * Sudoku Solver for doing and solving sudokus
 * @author Johan W
 *
 */
public class SudokuTest {
	
	/**
	 * Starts the sudoku solver
	 * @param args: Empty
	 */
	public static void main(String[] args){
		SudokuReader sr = new SudokuReader("Files/sudokuExamples");
		SudokuTemplate template = new SudokuTemplate();
		UserInterface UI = new UserInterface(template,sr);
	}
}

