/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgame.views;

import javafx.geometry.Insets;
import rpgame.logics.Being;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author nate
 */
public class CombatView {
    private BorderPane frame;
    private Button attack;
    private Label yourStats;
    private Label enemyStats;
    
    public CombatView(Being player, Being enemy) {
        frame = new BorderPane();
        frame.setPadding(new Insets(20, 20, 20, 20));
        frame.prefHeight(300);
        frame.prefWidth(1000);
        yourStats = new Label();
        yourStats.textProperty().bind(player.getStatus());
        player.setStatus();
        enemyStats = new Label();
        enemyStats.textProperty().bind(enemy.getStatus());
        enemy.setStatus();
        attack = new Button("Strike!");
        frame.setBottom(attack);
        frame.setLeft(yourStats);
        frame.setRight(enemyStats);
    }
    public BorderPane getFrame() {
        return frame;
    }
    public Button getAttack() {
        return attack;
    }
    
    public void setMiddle(String text) {
        frame.setCenter(new Label(text));
    }
    public void setContinue(Button button) {
        frame.setBottom(button);
    }
    public void reset() {
        frame.setBottom(attack);
        frame.setCenter(null);
    }
}
