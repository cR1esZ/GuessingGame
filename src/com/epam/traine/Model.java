package com.epam.traine;

/**
 * @author andreyholovan
 * @version 1.0
 */

public class Model {

    private static final int RAND_MAX = Integer.MAX_VALUE;

    private int randomNumber;
    private int lowerBound;
    private int upperBound;
    private int numberOfAttempts;

    /**
     * @see Model#Model()
     */
    public Model(){

        this.randomNumber = rand(0,100);
        this.lowerBound = 0;
        this.upperBound = 100;
        this.numberOfAttempts = 0;
    }


    private  int rand(){
        return (int)(Math.random() * RAND_MAX);
    }

    private int rand(int min,int max){
        return min + (int)(Math.random() * ((max - min) + 1));
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


    public void addOneAttempt(){
        this.numberOfAttempts++;
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
