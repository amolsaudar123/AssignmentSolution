package com.assignment.solution.sudoku;

import com.assignment.solution.exception.InvalidDigitException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Amol Saudar
 */
public interface Utility {
    Logger LOGGER = Logger.getLogger(Utility.class.getName());

    boolean isDigitSafeInRow(int[][] sudoku, int row, int digit);

    boolean isDigitSafeInColumn(int[][] sudoku, int column, int digit);

    boolean isDigitSafeInSubGrid(int[][] sudoku, int row, int column, int digit);

    /**
     * following function will checks if the sudoku[row][column] cell is empty or not
     *
     * @param sudoku
     * @param row
     * @param column
     * @return true or false
     */
    static boolean isPlaceSafeForInsertion(int[][] sudoku, int row, int column) throws InvalidDigitException {
        LOGGER.log(Level.INFO, "Checking [row][column] cell..");
        boolean isValid;
        if (sudoku[row][column] == 0) {
            isValid = true;
        } else {
            isValid = false;
            throw new InvalidDigitException(" " + "[" + row + "][" + column + "] already contains digit " + sudoku[row][column]);

        }
        return isValid;
    }

    /**
     * following function wil checks if provided row or column valid or not
     *
     * @param rowOrColumn
     * @param length
     * @return
     * @throws InvalidDigitException
     */
    static boolean isRowOrColumnValid(int rowOrColumn, int length) throws InvalidDigitException {
        LOGGER.log(Level.INFO, "Checking validety of the row and column");
        boolean isValid;
        if (rowOrColumn <= length) {
            isValid = true;
        } else {
            isValid = false;
            throw new InvalidDigitException("Row Or Column must be in between 1-9. Provided: " + rowOrColumn);
        }
        return isValid;
    }

    /**
     * Following function will checks of provided "digit" is valid or not
     *
     * @param digit
     * @return
     * @throws InvalidDigitException
     */
    static boolean isDigitValid(int digit) throws InvalidDigitException {
        LOGGER.log(Level.INFO, "Checking digit validaty..");
        boolean isValid;
        if (digit >= 1 && digit <= 9) {
            isValid = true;
        } else {
            isValid = false;
            throw new InvalidDigitException("Digit must be in between 1-9");
        }
        return isValid;
    }
}
