package rpgame.main;

import java.util.ArrayList;
import rpgame.views.CombatView;
import rpgame.views.StoryView;
import rpgame.logics.Being;
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
import rpgame.logics.Dice;
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
        Dice dice = new Dice();
        
        ArrayList<Being> beings = new ArrayList<>();
        Being player = new Being("Player");
        Being goblin = new Being("Goblin");
        beings.add(player);
        beings.add(goblin);
        
        StoryView start = new StoryView("RPGame");
        StoryView choice = new StoryView("You come across an angry goblin which challenges you to a fight :d");
        StoryView end = new StoryView("Boss defeated :^)");
        StoryView badEnd = new StoryView("You died xd");
        CombatView fight = new CombatView(player, goblin);
    
        end.setOption2("Back to start");
        start.setOption1("Play game");
        choice.setOption1("Fight the goblin");
        choice.setOption2("Attempt to run away");
        badEnd.setOption1("Back to start");
        
        Scene first = new Scene(start.getFrame(), 1000, 300);
        Scene second = new Scene(end.getFrame(), 1000, 300);
        Scene third = new Scene(fight.getFrame(), 1000, 300);
        Scene fourth = new Scene(choice.getFrame(), 1000, 300);
        Scene fifth = new Scene(badEnd.getFrame(), 1000, 300);
        
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
            player.setStatus();
            goblin.setStatus();
            fight.reset();
            primaryStage.setScene(third);
        });
        Button advance = start.getOption1();
        advance.setOnAction((event) ->{
            for (Being being : beings) {
                being.setHitpoints(100);
            }
            primaryStage.setScene(fourth);
        });
        
        Button back = end.getOption2();
        back.setOnAction((event) -> {
            primaryStage.setScene(first);
        });
        
        Button onwards = new Button("Continue");
        onwards.setOnAction((event) -> {
            primaryStage.setScene(second);
        });
        
        Button strike = fight.getAttack();
        strike.setOnAction((event) -> {
            dice.roll();
            if (dice.criticalMiss()) {
                player.takeDamage(25);
                fight.setMiddle("The goblin hit you for 25 hp!");
                if (player.getHitpoints() == 0) {
                    primaryStage.setScene(fifth);
                }
            } else if (!dice.hit()) {
                fight.setMiddle("You missed!");
            } else {
                goblin.takeDamage(50);
                fight.setMiddle("You hit the goblin for 50 hp!");
            }
            
            if (goblin.getHitpoints() == 0) {
                fight.setMiddle("You've slain the goblin!");
                fight.setContinue(onwards);
            }
            player.setStatus();
            goblin.setStatus();
        });
        
        primaryStage.setScene(first);
        primaryStage.show();
    }
    
}
