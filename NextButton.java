package userInterface;

import java.awt.event.ActionEvent;

import sudokuTemplate.SudokuReader;
import sudokuTemplate.SudokuTemplate;

/**
 * Button used in sudoku GUI for generating a new sudoku.
 * @author Johan W
 *
 */
public class NextButton extends AbstractButton {
	
	/**
	 * Attributes
	 */
	private SudokuReader sr;
	
	/**
	 * Constructor
	 * @param template: SudokuTemplate
	 * @param ui: UserInterface
	 * @param sr: SudokuReader
	 */
	public NextButton(SudokuTemplate template, UserInterface ui, SudokuReader sr){
		super(template, ui, "Next Sudoku");
		this.sr = sr;
	}

	/**
	 * Reads the next sudoku in file and displays it.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		template.setSudoku(sr.readNextSudoku());
		ui.updateView(template.getSudoku());
	}
}
