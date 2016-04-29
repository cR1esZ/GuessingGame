package com.epam.traine;


import java.util.Scanner;

/**
 * @author andreyholovan
 * @version 1.0
 */

public class Controller {


    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Work methods
     */
    public void processUser() {
        view.printMessage(view.HELLO_PLAYER);

        Scanner scanner = new Scanner(System.in);

        defaultGame();

        startGameLogic(scanner);

        menuForChoiceGame(scanner);

    }



    /**
     * This method start the game
     *
//     * @param model   which of the game
     * @param scanner input stream
     */
    public void startGameLogic(Scanner scanner) {

        int playerGuessNumber = model.getLowerBound() - 1;

        while (playerGuessNumber != model.getRandomNumber()) {
            playerGuessNumber = inputIntValueWithScanner(scanner);
            model.addOneAttempt();
            printCompareResult(playerGuessNumber);
        }
    }

    /**
     * This method call menu for choice the game
     *
     * @param scanner input stream
     */
    public void menuForChoiceGame(Scanner scanner) {

        view.printMessage(View.MENU_TEXT_ONE);
        view.printMessage(View.MENU_TEXT_TWO);

        while (!scanner.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA);
            scanner.next();
        }
        int result = scanner.nextInt();

        if (result != IGrobalConstants.MENU_ITEM_ONE && result != IGrobalConstants.MENU_ITEM_TWO) {
            view.printMessage(View.WRONG_CHOICE_MENU);
            menuForChoiceGame(scanner);
        }
        switch (result) {
            case 1:
                createGameWithRange(scanner);
                startGameLogic(scanner);
                break;
            case 2:
                createGameWithoutParameters();
                startGameLogic(scanner);
                break;
        }
    }

    public int inputIntValueWithScanner(Scanner scanner) {
        view.printMessageAndRange(View.RANGE_INFO, model.getLowerBound(), model.getUpperBound());
        while (!scanner.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA);
            view.printMessageAndRange(View.RANGE_INFO, model.getLowerBound(), model.getUpperBound());
            scanner.next();
        }
        int playerGuess = scanner.nextInt();

        if (!model.isGuessNumberOfRange(playerGuess)) {
            view.printMessageAndRange(View.WRONG_INPUT_DATA_IN_RANGE, model.getLowerBound(), model.getUpperBound());
            return inputIntValueWithScanner(scanner);
        }

        return playerGuess;
    }


    /**
     * Utility method to test comparing the number of player and computer
     *
     * @param playerGuess value from player input
     */
    public void printCompareResult(int playerGuess) {

        switch (model.compareGuessAndRandomNumber(playerGuess)) {
            case IGrobalConstants.LESS:
                view.printMessage(View.GUESS_NUMBER_LOW);
                break;
            case IGrobalConstants.GREATER:
                view.printMessage(View.GUESS_NUMBER_HIGH);
                break;
            case IGrobalConstants.EQUAL:
                view.printMessageAndInt(View.RIGHT_GUESS, model.getNumberOfAttempts());
                break;
        }
    }


    public void defaultGame(){
        model.setRandomNumber(model.rand(IGrobalConstants.DEFAULT_RAND_MIN,IGrobalConstants.DEFAULT_RAND_MAX));
        model.setLowerBound(IGrobalConstants.DEFAULT_RAND_MIN);
        model.setUpperBound(IGrobalConstants.DEFAULT_RAND_MAX);
        model.setNumberOfAttempts(IGrobalConstants.ATTEMPTS_ZERO);
    }

    public void createGameWithRange(Scanner scanner) {
        view.printMessage(View.GAME_WITH_RANGE);
        while (!scanner.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA);
            scanner.next();
        }
        int min = scanner.nextInt();
        int max = scanner.nextInt();

        if (model.compareLowerBoundAndUpperBound(min, max)) {
            view.printMessage(View.COMPARE_MIN_AND_MAX);
            createGameWithRange(scanner);
        } else {
        model.setRandomNumber(model.rand(min, max));
        model.setLowerBound(min);
        model.setUpperBound(max);
        model.setNumberOfAttempts(IGrobalConstants.ATTEMPTS_ZERO);
        }
    }

    public void createGameWithoutParameters() {
        model.setRandomNumber(model.rand());
        model.setLowerBound(IGrobalConstants.RAND_MIN);
        model.setUpperBound(IGrobalConstants.RAND_MAX);
        model.setNumberOfAttempts(IGrobalConstants.ATTEMPTS_ZERO);

    }
}



