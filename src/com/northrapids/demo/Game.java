package com.northrapids.demo;

import java.util.Scanner;

public class Game {

    int sumPlayerOne;
    int sumPlayerTwo;
    int rounds;
    int numberOfDice;
    boolean isPlaying = true;

    public void startGame() {

        Scanner scanner = new Scanner(System.in);

        Dice myDice = new Dice(1, 6);

        Player playerOne = new Player("", 0);
        Player playerTwo = new Player("", 0);

        System.out.println("-----------------------------");
        System.out.println("| D  I  C  E     G  A  M  E |");
        System.out.println("-----------------------------");

        do {

            System.out.println("Player one, Enter your name:");
            playerOne.name = scanner.next();

            System.out.println("Player two, Enter your name:");
            playerTwo.name = scanner.next();

            System.out.println("Enter the number of rounds you want to play:");
            rounds = scanner.nextInt();

            System.out.println("Enter the number of dice you want to play with: ");
            numberOfDice = scanner.nextInt();

            for (int i = 0; i < rounds; i++) {
                sumPlayerOne = 0;
                sumPlayerTwo = 0;
                System.out.println("\n******* Round #" + (i + 1) + " *******");

                for (int j = 0; j < numberOfDice; j++) {
                    int score = Player.rollDie(myDice.minSide, myDice.maxSide);
                    System.out.println(playerOne.name + " rolled: " + score);
                    sumPlayerOne += score;
                    playerOne.totalScore += score;
                }

                for (int k = 0; k < numberOfDice; k++) {
                    int score = Player.rollDie(myDice.minSide, myDice.maxSide);
                    System.out.println(playerTwo.name + " rolled: " + score);
                    sumPlayerTwo += score;
                    playerTwo.totalScore += score;
                }

                System.out.println("------------------------");
                System.out.println("Round #" + (i + 1) + " score:");
                System.out.println(playerOne.name + ": " + sumPlayerOne);
                System.out.println(playerTwo.name + ": " + sumPlayerTwo);

            }
            System.out.println("\n" + "****** Total score! ******");
            System.out.println(playerOne.name + ": " + playerOne.totalScore);
            System.out.println(playerTwo.name + ": " + playerTwo.totalScore);
            System.out.println("------------------------");

            if (playerOne.totalScore > playerTwo.totalScore) {
                System.out.println(playerOne.name + " Wins!");
            } else if (playerOne.totalScore == playerTwo.totalScore) {
                System.out.println("It was a tie!");
            } else {
                System.out.println(playerTwo.name + " Wins!");
            }

            System.out.println("*************************");
            System.out.println("\nPlay again? 1: NO, 2: YES");
            int play = scanner.nextInt();

            if (play == 1) {
                isPlaying = false;
            }

        } while (isPlaying);

    }

}
