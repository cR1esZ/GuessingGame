package com.epam.traine;

/**
 * @author andreyholovan
 * @version 1.0
 */

public class Model {

    private int randomNumber;
    private int lowerBound;
    private int upperBound;
    private int numberOfAttempts;

    /**
     * This method return random int value in a range of (0...Integer.MAX_VALUE)
     *
     * @return random value
     */
    public int rand() {
        return rand(IGrobalConstants.RAND_MIN, IGrobalConstants.RAND_MAX);
    }

    /**
     * This method return random int value in a range of (min...max)
     *
     * @param min min lower bound
     * @param max max upper bound
     * @return random value
     */
    public int rand(int min, int max) {
        return (min + 1) + (int) (Math.random() * ((max - min) - 1));
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }


    /**
     * This method add one attempt
     */
    public void addOneAttempt() {
        ++this.numberOfAttempts;
    }


    /**
     * Utility method to test comparing the number of player and computer
     *
     * @param playerGuess value from player input
     */
    public int compareGuessAndRandomNumber(int playerGuess) {

        if (playerGuess < randomNumber) {
            lowerBound = playerGuess;
            return -1;
        } else if (playerGuess > randomNumber) {
            upperBound = playerGuess;
            return 1;
        } else {
            return 0;
        }
    }

    public boolean compareLowerBoundAndUpperBound(int min,int max){
        return min > max || min == max || min + 1 == max;
    }



    /**
     * Utility method to check for entry into the range
     *
     * @param playerGuess value from player input
     */
    public boolean isGuessNumberOfRange(int playerGuess) {
        return playerGuess > lowerBound && playerGuess < upperBound;
    }

    @Override
    public String toString() {
        return "Model{" +
                "randomNumber=" + randomNumber +
                ", lowerBound=" + lowerBound +
                ", upperBound=" + upperBound +
                ", numberOfAttempts=" + numberOfAttempts +
                '}';
    }

}
