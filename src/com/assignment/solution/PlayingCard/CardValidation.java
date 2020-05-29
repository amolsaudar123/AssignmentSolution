package com.assignment.solution.PlayingCard;

import com.assignment.solution.exception.InvalidCardException;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CardValidation {
    private final static Logger LOGGER = Logger.getLogger(PlayingCardsSequence.class.getName());
    Utility utility;

    // SUIT holds the valid set of playing card suits
    final HashSet<String> SUITS = new HashSet<String>() {{
        add("S");
        add("H");
        add("D");
        add("C");
    }};

    /**
     * following function will checks if card is having valid suit or not
     *
     * @param cards
     * @return
     * @throws InvalidCardException
     */
    boolean suitValidation(String[] cards) throws InvalidCardException {
        LOGGER.log(Level.INFO, "Checking if card is of valid suit");
        boolean isValid = false;
        for (int i = 0; i < cards.length; i++) {

            //suits and ranks are are separated by "#": by the rules

            String cardSuit = cardSeparation(cards[i])[0];  // separating the suit from rank    // left of the "#" is suit
            if (SUITS.contains(cardSuit)) {
                isValid = true;
            } else {
                isValid = false;
                throw new InvalidCardException("Provided card is not valid{Invalid Suit}: " + cards[i]);
            }
        }
        return isValid;
    }

    /**
     * Following function will checks if cards are having valid rank or not
     *
     * @param cards
     * @return
     */
    boolean rankValidation(String[] cards) throws InvalidCardException {
        LOGGER.log(Level.INFO, "Checking if card is of valid rank");

        utility = new Utility();
        boolean isValid = false;
        for (int i = 0; i < cards.length; i++) {
        //suits and ranks are are separated by "#": by the rules

            String rank = cardSeparation(cards[i])[1]; // right to the "#" is rank
            int numericRank = utility.getNumericRank(rank); // getting numeric rank / current rank value

            if (numericRank > 0 && numericRank <= 13) {
                isValid = true;
            } else if (numericRank==0){
                isValid = false;

            }else {
                throw new InvalidCardException("Card rank is not valid {Invalid rank}:" + cards[i]);
            }
        }
        return isValid;
    }

    /**
     * following function will separates the suit from rank
     *
     * @param card
     * @return
     */
    public String[] cardSeparation(String card) {
        LOGGER.log(Level.INFO, "Separating the cards by '#' to get rank and suit ");

        //suits and ranks are are separated by "#": by the rules
        return card.split("#");
    }

    /**
     * following function will checks the card validity related to the ranks and suits
     *
     * @param cards
     * @return
     * @throws InvalidCardException
     */
    boolean cardValidation(String[] cards) throws InvalidCardException {
        LOGGER.log(Level.INFO,"Validating card against valid suit and rank");
        boolean isSuitsAreValid = suitValidation(cards); // checks if card contains valid suit
        boolean isRankValid = rankValidation(cards); // checks if card contains valid ranks

        return isSuitsAreValid && isRankValid;
    }
}
