/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgame.logics;

import java.util.Random;

/**
 * This class simulates a dice (pretty self explanatory :D)
 */
public class Dice {
    private Random random;
    private int currentResult;
    
    
    public Dice() {
        random = new Random();
        currentResult = 0;
    }
    /** 
     * Method sets a new value (0-6) as the current result
     */
    public void roll() {
        currentResult = random.nextInt(6);
    }
    
    /**
     * 
     * @return true if current result is 0. Else returns false 
     */
    public boolean criticalMiss() {
        return currentResult == 0;
    }
    /**
     * 
     * @return true if current result is greater than 3 
     */
    public boolean hit() {
        return currentResult > 3;
    }
    
    /**
     * Allows you to manually set a current result for the dice (used mainly for testing)
     * @param currentResult a number given by the user (pref. between 0-6)
     */
    public void setCurrentResult(int currentResult) {
        this.currentResult = currentResult;
    }
    /**
     * 
     * @return the current result as an integer
     */
    public int getResult() {
        return this.currentResult;
    }
}
