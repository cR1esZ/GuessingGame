package com.epam.traine;

import java.util.Scanner;

/**
 * Created by User on 17.03.2016.
 */
public class Controller {


    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // The Work method
    public void processUser() {
        view.printMessage(view.HELLO_PLAYER);
        Scanner scanner = new Scanner(System.in);

        int playerGuess = model.getLowerBound() - 1;

        while (playerGuess != model.getRandomNumber()) {

            playerGuess = inputIntValueWithScanner(scanner);
            compareGuessAndRandomNumber(playerGuess);
            model.addOneAttempt();
        }

    }

    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessageAndRange(view.RANGE_INFO, model.getLowerBound(), model.getUpperBound());
        while (!sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT_INT_DATA);
            view.printMessageAndRange(view.RANGE_INFO, model.getLowerBound(), model.getUpperBound());
            sc.next();
        }
        int playerGuess = sc.nextInt();

        if (!isNumberOfRange(playerGuess)) {
            view.printMessageAndRange(view.WRONG_INPUT_DATA_IN_RANGE, model.getLowerBound(), model.getUpperBound());
            return inputIntValueWithScanner(sc);
        }

        return playerGuess;
    }


    public boolean isNumberOfRange(int playerGuess) {
        return playerGuess >= model.getLowerBound() && playerGuess <= model.getUpperBound();
    }

    public void compareGuessAndRandomNumber(int playerGuess) {

        if (playerGuess < model.getRandomNumber()) {
            view.printMessage(view.GUESS_NUMBER_LOW);
            model.setLowerBound(playerGuess);

        } else if (playerGuess > model.getRandomNumber()) {
            view.printMessage(view.GUESS_NUMBER_HIGH);
            model.setUpperBound(playerGuess);

        } else {
            view.printMessageAndInt(view.RIGHT_GUESS,model.getNumberOfAttempts());
        }
    }




}
