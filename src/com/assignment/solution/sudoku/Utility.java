package com.assignment.solution.sudoku;

public interface Utility {
    boolean isDigitSafeInRow(int[][] sudoku, int row, int digit);
    boolean isDigitSafeInColumn(int[][] sudoku, int column, int digit);
    boolean isDigitSafeInSubGrid(int[][] sudoku, int row, int column, int digit);


}
