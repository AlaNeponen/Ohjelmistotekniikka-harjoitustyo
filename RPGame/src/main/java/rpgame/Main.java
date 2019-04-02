/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author nate
 */
public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        //HUOM! Oikea sovelluslogiikka ei tule olemaan tälläistä yhteen 
        // luokaan tungettua spagettia :D
        
        primaryStage.setTitle("RPGame");
        Button start = new Button("New Game");
        Button good = new Button("Do the good thing");
        Button bad = new Button("Do the bad thing");
        Label exposition = new Label("Choose what to do :^)");
        Button back = new Button("Return to main menu");
        Label badEnding = new Label("Bad ending :(");
        Label goodEnding = new Label("Good ending :3");
        
        
        GridPane grid = new GridPane();
        grid.getChildren().add(start);
        Scene startScreen = new Scene(grid);
        
        BorderPane storyPane = new BorderPane();
        
        HBox buttons = new HBox();
        buttons.setSpacing(20);
        buttons.getChildren().add(good);
        buttons.getChildren().add(bad);
        storyPane.setBottom(buttons);
        storyPane.setTop(exposition);
        
        BorderPane goodEndPane = new BorderPane();
        goodEndPane.setTop(goodEnding);
        goodEndPane.setBottom(back);
        
        Scene goodEnd = new Scene(goodEndPane);
        
        BorderPane badEndPane = new BorderPane();
        badEndPane.setTop(badEnding);
        badEndPane.setBottom(back);
        
        Scene badEnd = new Scene(badEndPane);
        
        Scene storyScene = new Scene(storyPane);
        
        start.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(storyScene);
        });
        good.setOnAction((ActionEvent event) -> {
           primaryStage.setScene(goodEnd);
        });
        bad.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(badEnd);
        });
        back.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(startScreen);
        });
        
        primaryStage.setScene(startScreen);
        primaryStage.show();
        
    }
    
}
