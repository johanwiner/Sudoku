package userInterface;

import java.awt.event.ActionEvent;

import sudokuTemplate.SudokuTemplate;

/**
 * Button used for solving the sudoku.
 * @author Johan W
 *
 */
public class SolveButton extends AbstractButton {
	
	/**
	 * Constructor
	 * @param template: SudokuTemplate
	 * @param ui: UserInterface
	 */
	public SolveButton(SudokuTemplate template, UserInterface ui){
		super(template, ui, "Solve");
	}

	/**
	 * Solves the current displayed sudoku and 
	 * displays a dialog with the result.
	 * Displays the solved sudoku if able.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ui.readView(template);
		if(template.solve()) {
			ui.updateView(template.getSudoku());
			ui.createDialogue("Sudoku was solved!");
		} else {
			ui.createDialogue("Could not solve sudoku...");
		}
	}
}
