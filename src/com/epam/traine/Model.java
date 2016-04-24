package com.epam.traine;

/**
 * @author andreyholovan
 * @version 1.0
 */

public class Model {

    private static final int RAND_MAX = Integer.MAX_VALUE;
    private static final int RAND_MIN = 0;
    private static final int ATTEMPTS_ZERO = 0;

    private int randomNumber;
    private int lowerBound;
    private int upperBound;
    private int numberOfAttempts;

    /**
     * @see Model#Model()
     */
    public Model() {
        this.randomNumber = rand(0, 100);
        this.lowerBound = 0;
        this.upperBound = 100;
        this.numberOfAttempts = 0;
    }

    /**
     * This method return random int value in a range of (0...Integer.MAX_VALUE)
     * @return random value
     */
    public int rand() {
        return rand(RAND_MIN,RAND_MAX);
    }

    /**
     * This method return random int value in a range of (min...max)
     * @param min min lower bound
     * @param max max upper bound
     * @return random value
     */
    public int rand(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
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

    public static int getRandMax() {
        return RAND_MAX;
    }


    public static int getRandMin() {
        return RAND_MIN;
    }

    public static int getAttemptsZero() {
        return ATTEMPTS_ZERO;
    }


    /**
     * This method add one attempt
     */
    public void addOneAttempt() {
        ++this.numberOfAttempts;
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
