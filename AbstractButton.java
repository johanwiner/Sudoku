package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import sudokuTemplate.SudokuTemplate;

/**
 * Abstract button used for the sudoku GUI
 * @author Johan W
 *
 */
public abstract class AbstractButton extends JButton implements ActionListener {
	
	protected SudokuTemplate template;
	protected UserInterface ui;
	
	public AbstractButton(SudokuTemplate template, UserInterface ui, String name) {
		super(name);
		this.template = template;
		this.ui = ui;
		addActionListener(this);
	}

	@Override
	public abstract void actionPerformed(ActionEvent arg0);

}



