package com.assignment.solution.PlayingCard;

import com.assignment.solution.exception.InvalidCardException;
import com.assignment.solution.sudoku.Sudoku;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Amol Saudar
 */
public class PlayingCardsSequence {
    private final static Logger LOGGER = Logger.getLogger(PlayingCardsSequence.class.getName());

    public static void main(String[] args) throws InvalidCardException {
        Utility  utility = new Utility();
        LOGGER.log(Level.INFO, "Evaluating Card Sequence:");
        System.out.println(utility.checkSequence("S#J,S#Q,S#K"));
    }


}
