package com.epam.traine;

/**
 * Created by User on 17.03.2016.
 */
public class View {
    // Text's constants
    public static final String HELLO_PLAYER = "Hey man, your task guess number from range(0-100). The force will be with you";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String WRONG_INPUT_DATA_IN_RANGE = "Please, try again. Your range = ";
    public static final String GUESS_NUMBER_LOW = "Sorry! Your guess was low! Guess again :)";
    public static final String GUESS_NUMBER_HIGH = "Sorry! Your guess was high! Guess again :)";
    public static final String RIGHT_GUESS = "Man, you are crazy, your guess right!  The number of attempts = ";
    public static final String RANGE_INFO = "Input value from this range. Range = ";


    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndRange(String message, int lower, int upper){
        System.out.println(message + "(" +lower + "-" + upper + ")");
    }
    public void printMessageAndInt(String message, int value){
        System.out.println(message + value);
    }

}
