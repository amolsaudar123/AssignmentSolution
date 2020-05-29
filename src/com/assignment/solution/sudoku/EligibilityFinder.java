package com.assignment.solution.sudoku;

import com.assignment.solution.exception.InvalidDigitException;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * @author Amol Saudar
 */
public class EligibilityFinder implements Utility {
    private final static Logger LOGGER = Logger.getLogger(EligibilityFinder.class.getName());

    /**
     * Following function will check if digit is present in the row or not
     *
     * @param sudoku
     * @param row
     * @param digit
     * @return true or false
     */
    @Override
    public boolean isDigitSafeInRow(int[][] sudoku, int row, int digit) {
        LOGGER.log(Level.INFO, "RULE 1: DIGIT MUST BE UNIQUE IN ROW");
        return !Arrays.toString(sudoku[row]).contains(Integer.toString(digit));
    }

    /**
     * Following function will check if digit is present in the column  or not
     *
     * @param sudoku
     * @param column
     * @param digit
     * @return true or false
     */
    @Override
    public boolean isDigitSafeInColumn(int[][] sudoku, int column, int digit) {
        LOGGER.log(Level.INFO, "RULE 2: DIGIT MUST BE UNIQUE IN COLUMN");
        return !Arrays.toString(IntStream.range(0, sudoku.length).map(i -> sudoku[i][column]).toArray()).contains(Integer.toString(digit));
    }

    /**
     * Following function will check if digit is present in the 3x3 sub grid or not
     *
     * @param sudoku
     * @param row
     * @param column
     * @param digit
     * @return
     */
    @Override
    public boolean isDigitSafeInSubGrid(int[][] sudoku, int row, int column, int digit) {
        LOGGER.log(Level.INFO, "RULE 3: DIGIT MUST BE UNIQUE IN 3X3 GRID");

        int subGridRowStart = row - row % 3; // row start index for the 3x3 sub grid
        int subGridColStart = column - column % 3; // column start index for the 3x3 sub grid

        boolean subGridEligibility = false;

        //checking if digit is present or not in 3x3 sub grid
        for (int rowIndex = subGridRowStart; rowIndex < subGridRowStart + 3; rowIndex++) {
            for (int columnIndex = subGridColStart; columnIndex < subGridColStart + 3; columnIndex++) {
                if (sudoku[rowIndex][columnIndex] == digit) {
                    subGridEligibility = false;
                } else {
                    subGridEligibility = true;
                }
            }
        }
        return subGridEligibility;
    }

    /**
     * Following function will check if digit is present in the row, column or in 3x3 sub grid
     *
     * @param sudoku
     * @param row
     * @param column
     * @param digit
     * @return
     */

    public boolean checkValidity(int[][] sudoku, int row, int column, int digit) throws InvalidDigitException {
        boolean eligibility = false;
        LOGGER.log(Level.INFO, "***************************");
        LOGGER.log(Level.INFO, "EVALUATING THE SUDOKU RULES");

        boolean isDigitValid = Utility.isDigitValid(digit); //checks if digit is in between 1-9
        boolean isRowValid = Utility.isRowOrColumnValid(row, sudoku.length); //checks if row value is in between 1-9
        boolean isColumnValid = Utility.isRowOrColumnValid(column, sudoku[0].length); //checks if column value is in between 1-9
        boolean isPlaceSafe = Utility.isPlaceSafeForInsertion(sudoku, row, column); //checks if [row][column] cell is already filled or not

        if (isDigitValid && isRowValid && isColumnValid && isPlaceSafe) {
            eligibility = isDigitSafeInRow(sudoku, row, digit) && isDigitSafeInColumn(sudoku, column, digit) && isDigitSafeInSubGrid(sudoku, row, column, digit);
        } else {
            throw new InvalidDigitException("OOPs... Something went wrong...");
        }
        return eligibility;
    }
}
