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



    // The Work method
    public void processUser() {
        view.printMessage(view.HELLO_PLAYER);

        Scanner scanner = new Scanner(System.in);

        actionUser(model,scanner);

        menuForChoiceGame(scanner);

    }

    public void actionUser(Model model, Scanner scanner){

        int playerGuessNumber = model.getLowerBound() - 1;

        while (playerGuessNumber != model.getRandomNumber()) {
            playerGuessNumber = inputIntValueWithScanner(scanner);
            compareGuessAndRandomNumber(playerGuessNumber);
            model.addOneAttempt();
        }

    }

    public void menuForChoiceGame(Scanner scanner){

        view.printMessage(view.MENU_TEXT_ONE);
        view.printMessage(view.MENU_TEXT_TWO);

        while (!scanner.hasNextInt()){
            view.printMessage(view.WRONG_INPUT_INT_DATA);
            scanner.next();
        }
        int result = scanner.nextInt();

        if (result != 1 && result !=2){
            view.printMessage(view.WRONG_CHOICE_MENU);
            menuForChoiceGame(scanner);
        }
        switch (result){
            case 1: actionUser(createGameWithRange(scanner),scanner);
                break;
            case 2: actionUser(createGameWithoutParameters(),scanner);
                break;
            default:
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

        if (!isGuessNumberOfRange(playerGuess)) {
            view.printMessageAndRange(view.WRONG_INPUT_DATA_IN_RANGE, model.getLowerBound(), model.getUpperBound());
            return inputIntValueWithScanner(sc);
        }

        return playerGuess;
    }


    public boolean isGuessNumberOfRange(int playerGuess) {
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

    public Model createGameWithRange(Scanner scanner){
        view.printMessage(view.GAME_WITH_RANGE);
        while(!scanner.hasNextInt()){
            view.printMessage(view.WRONG_INPUT_INT_DATA);
            scanner.next();
        }
        int min = scanner.nextInt();
        int max = scanner.nextInt();

        if (min > max){
            view.printMessage(view.COMPARE_MIN_AND_MAX);
            return createGameWithRange(scanner);
        }
        model.setRandomNumber(model.rand(min,max));
        model.setLowerBound(min);
        model.setUpperBound(max);
        model.setNumberOfAttempts(0);
        return model;
    }

    public Model createGameWithoutParameters(){
        model.setRandomNumber(model.rand());
        model.setLowerBound(model.getRandMin());
        model.setUpperBound(model.getRandMax());
        model.setNumberOfAttempts(0);
        return model;
    }

}
