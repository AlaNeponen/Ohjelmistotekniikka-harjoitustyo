/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgame.views;

import rpgame.logics.Being;
import rpgame.logics.Dice;

/**
 *
 * @author nate
 */
public class CombatButtonHandler {
    private Dice dice;
    private int damageToEnemy;
    private int damageToSelf;
    public CombatButtonHandler(Dice dice) {
        this.dice = dice;
    }
    
    public void setDamageToSelf(int amount) {
        damageToSelf = amount;
    }
    
    public void setDamageToEnemy(int amount) {
        damageToEnemy = amount;
    }
    
    public void handle(CombatView view, Being player, Being enemy) {
        dice.roll();
        if (dice.criticalMiss()) {
            player.takeDamage(damageToSelf);
            view.setMiddle("You rolled a " + dice.getResult() + "?! " + "The " + enemy.getName() + " hit you for " + damageToSelf + " hp!");
        } else if (!dice.hit()) {
            view.setMiddle("You rolled a " + dice.getResult() + ". " + "You missed!");
        } else {
            enemy.takeDamage(damageToEnemy);
            view.setMiddle("You rolled a " + dice.getResult() + ". " + "You hit the " + enemy.getName() + " for " + damageToEnemy + " hp!");
        } 
        
    }
}
