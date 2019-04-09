/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgame.Views;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author nate
 */
public class StoryView {
    private Label label;
    private BorderPane frame;
    private Button option1;
    private Button option2;
    
    public StoryView(String text) {
        this.frame = new BorderPane();
        this.label = new Label(text);
        frame.setTop(label);
    }
    public void setOption1(String text) {
        option1 = new Button(text);
        frame.setLeft(option1);
    }
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
