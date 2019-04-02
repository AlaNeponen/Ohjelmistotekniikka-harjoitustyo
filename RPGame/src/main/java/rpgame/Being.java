/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgame;

/**
 *
 * @author nate
 */
public class Being {
    private int Hitpoints;
    
    public Being() {
        Hitpoints = 100;
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
}
