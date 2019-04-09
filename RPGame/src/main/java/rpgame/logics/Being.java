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
    private int Hitpoints;
    private String name;
    private StringProperty status;
    
    public Being(String name) {
        Hitpoints = 100;
        this.name = name;
        status = new SimpleStringProperty();
    }

    public int getHitpoints() {
        return this.Hitpoints;
    }

    public void takeDamage(int amount) {
        this.Hitpoints -= amount;
        if (this.Hitpoints < 0) {
            this.Hitpoints = 0;
        }
    }
    public StringProperty getStatus() {
        return status;
    }
    public void setStatus() {
        String stats = name + " health: " + Hitpoints;
        status.set(stats);
    }
}
