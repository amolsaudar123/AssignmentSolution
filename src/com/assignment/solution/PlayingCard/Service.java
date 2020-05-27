package com.assignment.solution.PlayingCard;

/**
 *
 * @author Amol Saduar
 */
public abstract class Service {
   abstract boolean isUniqueSuite(String[] cardArray, String suite);
    abstract int getNumericRank(String str4);
    abstract int getNextValue(String rank);
}
