/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgame.views;

import rpgame.domain.Being;
import rpgame.domain.Dice;

/**
 * This class handles the logic behind the ingame "combat"
 * The method "handle()" is called whenever the attack button is pressed in a CombatView
 */
public class CombatButtonHandler {
    private Dice dice;
    public CombatButtonHandler(Dice dice) {
        this.dice = dice;
    }
    
    /**
     * Method simulates a turn of combat:
     * Method "rolls a dice" once, and then sets the correct text as the middle element in the given CombatView
     * Also if needed, modifies the status of the Beings involved
     * For example, if the result of the dice roll is 0, the method will call another method to lower the player Beings hitpoints by a certain, predetermined amount (damageToSelf)
     * @param view the CombatView object in which the combat takes place
     * @param player the player Being
     * @param enemy the Being the player is fighting
     */
    public void handle(CombatView view, Being player, Being enemy) {
        dice.roll();
        if (dice.criticalMiss()) {
            player.takeDamage(player.getDamageTaken());
            view.setMiddle("You rolled a " + dice.getResult() + "?! " + "The " + enemy.getName() + " hit you for " + player.getDamageTaken() + " hp!");
        } else if (!dice.hit()) {
            view.setMiddle("You rolled a " + dice.getResult() + ". " + "You missed!");
        } else {
            enemy.takeDamage(enemy.getDamageTaken());
            view.setMiddle("You rolled a " + dice.getResult() + ". " + "You hit the " + enemy.getName() + " for " + enemy.getDamageTaken() + " hp!");
        } 
        
    }
}
