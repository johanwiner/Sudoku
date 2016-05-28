package userInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import sudokuTemplate.SudokuReader;
import sudokuTemplate.SudokuTemplate;

/**
 * The userinterface through which the user solves the sudoku.
 * It contains a number of buttons to solve, check and import in a sudoku.
 * @author Johan W
 *
 */
public class UserInterface extends JFrame{
	
	/**
	 * Attributes
	 */
	private JFormattedTextField[][] dataFields;
	
	/**
	 * Setup the user interface for the application.
	 * @param template: SudokuTemplate for the sudoku.
	 * @param sr: SudokuReader for importing sudokus from file.
	 */
	public UserInterface(SudokuTemplate template, SudokuReader sr){
		super("Sudoku");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel buttonPanel = new JPanel();
	    JPanel backPanel = new JPanel();
	    
	    backPanel.setLayout(new GridLayout(9,9));
	    
	    add(buttonPanel, BorderLayout.SOUTH);
	    add(backPanel, BorderLayout.CENTER);
	    
	    buttonPanel.add(new NextButton(template, this, sr)); 
	    buttonPanel.add(new SolveButton(template, this));
	    buttonPanel.add(new CheckButton(template, this));
	    dataFields = new JFormattedTextField[9][9];
	    for(int i = 0; i < 9; i++){
	    	for(int j = 0; j < 9; j++){
	    		try {
	    		dataFields[i][j] = new JFormattedTextField(new MaskFormatter("#"));
	    		} catch (ParseException e) {
	    			System.out.println("Mask error");
	    		}
	    		dataFields[i][j].setPreferredSize(new Dimension(15,15));
	    		backPanel.add(dataFields[i][j]);
	    	}
	    }
	    setVisible(true);
	    pack();
	}

	/**
	 * Reads the current sudoku of the view and 
	 * stores it in template.
	 * @param template: SudokuTemplate in which the sudoku 
	 * taken from the view is stored
	 */
	public void readView(SudokuTemplate template) {
		int[][] readSudoku = new int[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(dataFields[i][j].getText().contentEquals(" ")) {
					readSudoku[i][j] = 0;
				} else {
					readSudoku[i][j] = Integer.parseInt(dataFields[i][j].getText());
				}
			}
		}
		template.setSudoku(readSudoku);
	}

	/**
	 * Updates the view with a new sudoku.
	 * @param sudoku: sudoku to be displayed 9x9 matrix.
	 */
	public void updateView(int[][] sudoku) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(sudoku[i][j] == 0) {
					dataFields[i][j].setText("");
					dataFields[i][j].setEditable(true);
				} else {
					dataFields[i][j].setText(String.valueOf(sudoku[i][j]));
					dataFields[i][j].setEditable(false);
				}
			}
		}
	}
	
	/**
	 * Displays a dialog with desired message.
	 * @param message: String message to be displayed
	 */
	public void createDialogue(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
