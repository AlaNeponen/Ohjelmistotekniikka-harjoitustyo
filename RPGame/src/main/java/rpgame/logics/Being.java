/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgame.logics;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author nate
 */
public class Being {
    private int hitpoints;
    private String name;
    private StringProperty status;
    
    public Being(String name) {
        hitpoints = 100;
        this.name = name;
        status = new SimpleStringProperty();
    }

    public int getHitpoints() {
        return this.hitpoints;
    }

    public void takeDamage(int amount) {
        this.hitpoints -= amount;
        if (this.hitpoints < 0) {
            this.hitpoints = 0;
        }
    }
    public StringProperty getStatus() {
        return status;
    }
    public void setStatus() {
        String stats = name + " Health: " + hitpoints;
        status.set(stats);
    }
    public void setHitpoints(int amount) {
        if (amount > 100) {
            hitpoints = 100;
        } else if (amount < 0) {
            hitpoints = 0;
        } else {
            hitpoints = amount;
        }
        
    }
}
