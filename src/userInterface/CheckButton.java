package userInterface;

import java.awt.event.ActionEvent;

import sudokuTemplate.SudokuTemplate;

/**
 * Button for checking if the sudoku is solvable.
 * @author Johan W
 *
 */
public class CheckButton extends AbstractButton {

	/**
	 * 
	 * @param template: SudokuTemplate
	 * @param ui: UserInterface
	 */
	public CheckButton(SudokuTemplate template, UserInterface ui){
		super(template, ui, "Check");
	}

	/**
	 * Checks if the current sudoku is solvable and 
	 * displays the result in a dialogbox.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ui.readView(template);
		if(template.solve()) {
			ui.createDialogue("Possible");
		} else {
			ui.createDialogue("Impossible");
		}
	}
}
