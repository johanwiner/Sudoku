package sudokuTemplate;

/**
 * Class that solves the sudoku 
 * @author Johan W
 *
 */
public class SudokuTemplate {

	int[][] sudoku;
	
	/**
	 * Creates a new empty sudoku.
	 */
	public SudokuTemplate(){
		sudoku = new int[9][9];
	}
	
	/**
	 * Stores the specified sudoku.
	 * @param sudoku the sudoku to be stored
	 */
	public SudokuTemplate(int[][] sudoku){
		this.sudoku = sudoku;
	}
	
	/**
	 * Solves the current sudoku.
	 * Initiates the recursive method to solve the sudoku.
	 * @return true if sudoku was solvable
	 */
	public boolean solve(){
		return solve(0,0);
	}
	
	/**
	 * Returns the current sudoku.
	 * @return the current sudoku.
	 */
	public int[][] getSudoku(){
		return sudoku;
	}
	
	/**
	 * Recursive method for solving the sudoku 
	 * @param i: Position x-axis
	 * @param j: Position y-axis
	 * @return
	 */
	private boolean solve(int i, int j){
		if(j == 9){
			j = 0;
			i++;
		}
		if(i == 9){
			return true;
		} else if(sudoku[i][j] != 0 && !check(i, j, sudoku[i][j])){
				return false;
		} else if(sudoku[i][j] != 0){
				return solve(i, j+1);
		} else {
			for(int n = 1; n <= 9; n++){
				if(check(i, j, n)){
					sudoku[i][j] = n;
					if(!solve(i, j+1)){
						sudoku[i][j] = 0;
					}else {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Method that checks if sudoku rules are obeyed
	 * @param i: Position x-axis
	 * @param j: Position x-axis
	 * @param n: Integer
	 * @return: true / false
	 */
	private boolean check(int i, int j, int n){
		return checkRow(i, j, n) && checkColumn(i, j ,n) && checkSquare(i, j, n);
	}
	
	/**
	 * Method that checks if sudoku row-rule is obeyed
	 * @param i: Position x-axis
	 * @param j: Position x-axis
	 * @param n: Integer
	 * @return: true / false
	 */
	private boolean checkRow(int i, int j, int n){
		for(int k = 0; k < 9; k++){
			if(k == j){
			}else if(sudoku[i][k] == n){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Method that checks if sudoku column-rule is obeyed
	 * @param i: Position x-axis
	 * @param j: Position x-axis
	 * @param n: Integer
	 * @return: true / false
	 */
	private boolean checkColumn(int i, int j, int n){
		for(int k = 0; k < 9; k++){
			if(k == i){
			}else if(sudoku[k][j] == n){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Method that checks if sudoku square-rule is obeyed
	 * @param i: Position x-axis
	 * @param j: Position x-axis
	 * @param n: Integer
	 * @return: true / false
	 */
	private boolean checkSquare(int i, int j, int n){
		int xbox = j/3;
		int ybox = i/3;
		for (int k = xbox * 3; k < xbox*3 +3; k++){
			for(int l = ybox*3; l < ybox*3 + 3; l++){
				if(k == j && l == i){
				} else if(sudoku[l][k] == n){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Sets the current sudoku to the specified sudoku.
	 * @param sudoku the sudoku to be stored as the current one.
	 */
	public void setSudoku(int[][] sudoku) {
		this.sudoku = sudoku;
	}
}

	
