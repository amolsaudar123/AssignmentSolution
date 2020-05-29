package com.assignment.solution.PlayingCard;

import com.assignment.solution.exception.InvalidCardException;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utility extends Service {
    private final static Logger LOGGER = Logger.getLogger(PlayingCardsSequence.class.getName());
    CardValidation cardValidation;

    static HashSet<String> k_a = new HashSet<>();
    static final HashSet<String> finalKndA = new HashSet<String>() {
        {
            add("K");
            add("A");
        }
    };

    /**
     * following function will check the sequence of the card
     *
     * @param cards
     * @return true or false
     */
    public boolean checkSequence(String cards) throws InvalidCardException {
        LOGGER.log(Level.INFO, "Executing card sequence rules.");
        int nextVal = 0;
        boolean isSeq = false;
        cardValidation = new CardValidation();

        String[] cardArray = cards.split(",");

        boolean isValidCards = cardValidation.cardValidation(cardArray); // checks the card validity related to the ranks and suits
        String suit = cardValidation.cardSeparation(cardArray[0])[0];
        isSeq = isUniqueSuite(cardArray, suit);  //check if every card is of same type (Same Suite)

        if (isValidCards && isSeq) {
            String rank = cardValidation.cardSeparation(cardArray[0])[1];
            nextVal = getNextValue(rank); // get next sequential val

            for (int i = 1; i < cardArray.length; i++) {

                int currentVal = getNumericRank(cardValidation.cardSeparation(cardArray[i])[1]); // get the current value for the ranks

                // check if current value is matching with the sequence
                if (currentVal == nextVal) {
                    if (currentVal == 13)
                        nextVal = 1;
                    else nextVal = currentVal + 1;
                } else {
                    isSeq = false;
                }
            }
        } else {
            isSeq = false;
        }
        return isSeq;
    }

    /**
     * following function will get the current value for the ranks
     *
     * @param rank
     * @return currentVal
     */
    @Override
    int getNumericRank(String rank) throws InvalidCardException {
        LOGGER.log(Level.INFO, "Setting up currentValue based on rank");

        int currentVal = 0;
        if (rank.equals("A")) {
            if (k_a.contains("K")) {
                k_a.add("A");
            }
            currentVal = 1;
        } else if (rank.equals("Q")) {
            currentVal = 12;
        } else if (rank.equals("J")) {
            currentVal = 11;
        } else if (rank.equals("K")) {
            k_a.add("K");
            currentVal = 13;
        } else if (rank.equals("1")) {
            currentVal = 10;
        } else {
            if (k_a.containsAll(finalKndA)) {
                currentVal = 0;
            } else {
                try {
                    currentVal = Integer.parseInt(rank);
                }catch (Exception  e){
                    throw new InvalidCardException("Card Rank is not valid: "+rank);
                }
            }
        }
        return currentVal;
    }

    /**
     * following function will get next sequential val for A, J, Q, K
     *
     * @param rank
     * @return
     */
    @Override
    int getNextValue(String rank) {
        LOGGER.log(Level.INFO, "Setting up nextValue based on rank");
        int nextVal;
        switch (rank) {
            case "A":
                nextVal = 2;
                break;
            case "J":
                nextVal = 12;
                break;
            case "Q":
                nextVal = 13;
                break;
            case "K":
                nextVal = 1;
                break;
            default:
                int value = rank.equals("1") ? 10 : Integer.parseInt(rank);
                nextVal = value + 1;
        }
        return nextVal;

    }

    /**
     * following function will check if every card is of same type (Same Suite)
     *
     * @param cardArray
     * @param suite
     * @return true or false
     */
    @Override
    boolean isUniqueSuite(String[] cardArray, String suite) {
        LOGGER.log(Level.INFO, "Checking if all cards of same suit");

        cardValidation = new CardValidation();
        boolean uniqueSeq = false;
        for (int i = 1; i < cardArray.length; i++) {

            String suiteOfNextCard = cardValidation.cardSeparation(cardArray[i])[0]; // getting suit of card
            if (!suite.equals(suiteOfNextCard)) {
                uniqueSeq = false;
                break;
            } else {
                uniqueSeq = true;
            }
        }
        return uniqueSeq;
    }
}
