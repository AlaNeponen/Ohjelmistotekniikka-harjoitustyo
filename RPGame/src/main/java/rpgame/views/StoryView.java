/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgame.views;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This class provides a framework for a scene in which the player is presented with some story, and a choice
 */
public class StoryView {
    private Label label;
    private BorderPane frame;
    private Button option1;
    private Button option2;
 
    /** 
     * Creates a new StoryView with the given text as the bit of "story" presented to the player
     * @param text a text describing the situation to the player
     */
    public StoryView(String text) {
        this.frame = new BorderPane();
        frame.prefHeight(300);
        frame.prefWidth(1000);
        frame.setPadding(new Insets(20, 20, 20, 20));
        this.label = new Label(text);
        frame.setTop(label);
        
    }
    /**
     * Sets up a button representing one of the options the player can now choose
     * @param text a text describing this option
     */
    public void setOption1(String text) {
        option1 = new Button(text);
        frame.setLeft(option1);
    }
    /**
     * Sets up a button representing one of the options the player can now choose
     * @param text a text describing this option
     */
    public void setOption2(String text) {
        option2 = new Button(text);
        frame.setRight(option2);
    }

    public Label getLabel() {
        return label;
    }

    public Button getOption1() {
        return option1;
    }

    public Button getOption2() {
        return option2;
    }
    
    public BorderPane getFrame() {
        return frame;
    }
    
}
