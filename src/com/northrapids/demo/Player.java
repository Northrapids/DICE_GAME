package com.northrapids.demo;

import java.util.Random;

public class Player {

    String name;
    int totalScore;

    public Player(String name, int totalScore) {
        this.name = name;
        this.totalScore = totalScore;
    }

    public static int rollDie(int minSide, int maxSide) {
        int faceNumber;

        Random random = new Random();
        faceNumber = random.nextInt(minSide, (maxSide + 1));

        return faceNumber;
    }

}
