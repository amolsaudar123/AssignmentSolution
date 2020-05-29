package com.assignment.solution.PlayingCard;

import com.assignment.solution.exception.InvalidCardException;

/**
 *
 * @author Amol Saduar
 */
public abstract class Service {
   abstract boolean isUniqueSuite(String[] cardArray, String suite);
    abstract int getNumericRank(String str4) throws InvalidCardException;
    abstract int getNextValue(String rank);
}
