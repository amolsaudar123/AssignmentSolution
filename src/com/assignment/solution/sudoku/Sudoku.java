package com.assignment.solution.sudoku;

import com.assignment.solution.exception.InvalidDigitException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amol Saudar
 */
public class Sudoku {
    private final static Logger LOGGER = Logger.getLogger(Sudoku.class.getName());

    // sudoku[][] will hold the 9X9 partially solved sudoku
    // 0 => empty place is denoted by digit 0
    static int[][] sudoku ={
            {9, 8, 1, 3, 6, 5, 2, 7, 4},
            {7, 0, 5, 4, 8, 2, 3, 1, 9},
            {2, 4, 3, 1, 7, 9, 8, 5, 0},

            {1, 9, 2, 6, 3, 4, 7, 8, 5},
            {4, 3, 7, 5, 2, 8, 9, 6, 1},
            {8, 5, 6, 9, 1, 7, 4, 0, 2},

            {3, 2, 4, 0, 5, 6, 1, 9, 8},
            {5, 1, 8, 2, 0, 3, 6, 4, 7},
            {6, 7, 9, 8, 4, 1, 5, 2, 3}
    };

    public static void main(String[] args) throws InvalidDigitException {
        EligibilityFinder initialObj =new EligibilityFinder();

        LOGGER.log(Level.INFO, "CHECKING THE ELIGIBILITY OF THE DIGIT");

        System.out.println(initialObj.checkValidity(sudoku, 0, 0, 60));

        LOGGER.log(Level.INFO, "CHECKING THE ELIGIBILITY OF THE DIGIT IS COMPLETED");
        LOGGER.log(Level.INFO, "***************************");
    }


}
