/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgame.domain;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class models a character in the game
 * Each Being has a name and a certain amount of hitpoints
 */
public class Being {
    private int hitpoints;
    private String name;
    private StringProperty status;
    private int damageTaken;
    
    /** 
     * Creates a new Being with the given name
     * All Beings start with 100 hitpoints
     * @param name the name of the Being
     */
    public Being(String name) {
        hitpoints = 100;
        this.name = name;
        status = new SimpleStringProperty();
    }

    public int getHitpoints() {
        return this.hitpoints;
    }
    
    /**
     * Lowers a Beings hitpoints by the indicated amount
     * Note that hitpoints can never be negative, and in that case the remaining amount defaults to zero
     * @param amount amount of damage that the Being takes
     */
    public void takeDamage(int amount) {
        this.hitpoints -= amount;
        if (this.hitpoints < 0) {
            this.hitpoints = 0;
        }
    }
    public StringProperty getStatus() {
        return status;
    }
    /** 
     * Sets the Beings status to display its current name and hitpoints
     */
    public void setStatus() {
        String stats = name + " Health: " + hitpoints;
        status.set(stats);
    }
    /**
     * Sets the given amount as the Beings hitpoints
     * Note that a Beings hitpoints can never exceed 100, and in that case it defaults to 100
     * Note that a Beings hitpoints can ever be negative either, and in that case it defaults to 0
     * @param amount amount of hitpoints the Being has
     */
    public void setHitpoints(int amount) {
        if (amount > 100) {
            hitpoints = 100;
        } else if (amount < 0) {
            hitpoints = 0;
        } else {
            hitpoints = amount;
        }
        
    }
    public String getName() {
        return name;
    }
    public void setDamageTaken(int amount) {
        damageTaken = amount;
    }
    public int getDamageTaken() {
        return damageTaken;
    }
}
