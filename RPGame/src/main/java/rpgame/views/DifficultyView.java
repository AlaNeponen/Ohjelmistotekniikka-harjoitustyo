/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgame.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * a View in which the player chooses the difficulty of this playthrough.
 */
public class DifficultyView {
    private BorderPane frame;
    private VBox buttons;
    private Label text;
    private Button start;
    private Button ez;
    private Button normal;
    private Button hard;
    private Scene scene;
    
    /** 
     * This method creates the framework for the scene in which the player chooses the difficulity for this playthrough.
     */
    public DifficultyView() {
        text = new Label("Choose your difficulty:");
        buttons = new VBox(15);
        start = new Button("Begin game!");
        ez = new Button("easy");
        normal = new Button("normal");
        hard = new Button("hard");
        frame = new BorderPane();
        frame.prefHeight(300);
        frame.prefWidth(1000);
        frame.setPadding(new Insets(20, 20, 20, 20));
        buttons.setPadding(new Insets(20, 20, 20, 20));
        buttons.getChildren().add(ez);
        buttons.getChildren().add(normal);
        buttons.getChildren().add(hard);
        frame.setTop(text);
        frame.setCenter(buttons);
        frame.setBottom(start);
    }

    public BorderPane getFrame() {
        return frame;
    }

    public Button getStart() {
        return start;
    }

    public Button getEz() {
        return ez;
    }

    public Button getNormal() {
        return normal;
    }

    public Button getHard() {
        return hard;
    }
    
}
