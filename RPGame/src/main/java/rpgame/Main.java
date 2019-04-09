package rpgame;

import java.util.Random;
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
        Random dice = new Random();
        
        Being player = new Being("Player");
        Being enemy = new Being("Goblin");
        
        StoryView start = new StoryView("RPGame");
        StoryView choice = new StoryView("You come across an angry goblin which challenges you to a fight :d");
        StoryView end = new StoryView("Boss defeated :^)");
        StoryView badEnd = new StoryView("You died xd");
        CombatView fight = new CombatView(player, enemy);
    
        end.setOption2("Back to start");
        start.setOption1("Play game");
        choice.setOption1("Fight the goblin");
        choice.setOption2("Attempt to run away");
        badEnd.setOption1("Back to start");
        
        Scene first = new Scene(start.getFrame());
        Scene second = new Scene(end.getFrame());
        Scene third = new Scene(fight.getFrame());
        Scene fourth = new Scene(choice.getFrame());
        Scene fifth = new Scene(badEnd.getFrame());
        
        Button back2 = badEnd.getOption1();
        back2.setOnAction((event) -> {
            primaryStage.setScene(first);
        });
        Button run = choice.getOption2();
        run.setOnAction((event) -> {
            primaryStage.setScene(fifth);
        });
        Button challenge = choice.getOption1();
        challenge.setOnAction((event) -> {
            primaryStage.setScene(third);
        });
        Button advance = start.getOption1();
        advance.setOnAction((event) ->{
            primaryStage.setScene(fourth);
        });
        
        Button back = end.getOption2();
        back.setOnAction((event) -> {
            primaryStage.setScene(first);
        });
        
        Button strike = fight.getAttack();
        strike.setOnAction((event) -> {
            int roll = dice.nextInt(6);
            if (roll > 2) {
                enemy.takeDamage(50);
            }
            if (roll == 0) {
                player.takeDamage(25);
            }
            if (enemy.getHitpoints() == 0) {
                primaryStage.setScene(second);
            }
            player.setStatus();
            enemy.setStatus();
        });
        
        primaryStage.setScene(first);
        primaryStage.show();
    }
    
}
