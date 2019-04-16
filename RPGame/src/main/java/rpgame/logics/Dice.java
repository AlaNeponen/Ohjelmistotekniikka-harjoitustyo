/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgame.logics;

import java.util.Random;

/**
 *
 * @author nate
 */
public class Dice {
    private Random random;
    private int currentResult;
    
    public Dice() {
        random = new Random();
        currentResult = 0;
    }
    public void roll() {
        currentResult = random.nextInt(6);
    }
    public boolean criticalMiss() {
        return currentResult == 0;
    }
    public boolean hit() {
        return currentResult > 3;
    }

    public void setCurrentResult(int currentResult) {
        this.currentResult = currentResult;
    }
    public int getResult() {
        return this.currentResult;
    }
}
