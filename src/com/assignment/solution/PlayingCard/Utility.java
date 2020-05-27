package com.assignment.solution.PlayingCard;

import java.util.HashSet;

public class Utility extends Service {

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
    public boolean checkSequence(String cards) {
        int nextVal = 0;
        boolean isSeq = false;
        String[] cardArray = cards.split(",");

        isSeq = isUniqueSuite(cardArray, String.valueOf(cardArray[0].charAt(0)));  //check if every card is of same type (Same Suite)

        if (isSeq) {
            nextVal = getNextValue(String.valueOf(cardArray[0].charAt(2))); // get next sequential val for A, J, Q, K

            for (int i = 1; i < cardArray.length; i++) {

                int currentVal = getNumericRank(String.valueOf(cardArray[i].charAt(2))); // get the current value for the ranks

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
    int getNumericRank(String rank) {
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
                currentVal = Integer.parseInt(rank);
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
        boolean uniqueSeq = false;
        for (int i = 1; i < cardArray.length; i++) {
            String suiteOfNextCard = String.valueOf((cardArray[i].charAt(0)));
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
