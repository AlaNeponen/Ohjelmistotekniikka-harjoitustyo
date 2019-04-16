package rpgame.main;

import java.util.ArrayList;
import rpgame.views.CombatView;
import rpgame.views.StoryView;
import rpgame.logics.Being;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import rpgame.logics.Dice;
import rpgame.views.CombatButtonHandler;
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
        CombatButtonHandler handler = new CombatButtonHandler(dice);
        
        ArrayList<Being> beings = new ArrayList<>();
        Being player = new Being("Player");
        Being goblin = new Being("Goblin");
        Being king = new Being("Goblin King");
        beings.add(player);
        beings.add(goblin);
        beings.add(king);
        
        StoryView start = new StoryView("RPGame");
        StoryView choice = new StoryView("You come across an angry goblin which challenges you to a fight :d");
        StoryView end = new StoryView("Boss defeated :^)");
        StoryView badEnd = new StoryView("You died xd");
        CombatView fight = new CombatView(player, goblin);
        StoryView goblinKing = new StoryView("The murder of his subject has caught the attention of the Goblin King, and you are forcibly brought before him to answer for your crimes.");
        CombatView bossFight = new CombatView(player, king);
        
        end.setOption2("Back to start");
        start.setOption1("Play game");
        choice.setOption1("Fight the goblin");
        choice.setOption2("Attempt to run away");
        badEnd.setOption1("Back to start");
        goblinKing.setOption1("Remain cool and charm the King with your suave phrasing");
        goblinKing.setOption2("Attempt to slay the King and flee from your crimes");
        
        Scene first = new Scene(start.getFrame(), 1000, 300);
        Scene second = new Scene(end.getFrame(), 1000, 300);
        Scene third = new Scene(fight.getFrame(), 1000, 300);
        Scene fourth = new Scene(choice.getFrame(), 1000, 300);
        Scene fifth = new Scene(badEnd.getFrame(), 1000, 300);
        Scene sixth = new Scene(goblinKing.getFrame(), 1000, 300);
        Scene seventh = new Scene(bossFight.getFrame(), 1000, 300);
        
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
            handler.setDamageToEnemy(50);
            handler.setDamageToSelf(25);
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
            primaryStage.setScene(sixth);
        });
        
        Button strike = fight.getAttack();
        strike.setOnAction((event) -> {
            handler.handle(fight, player, goblin);
            
            if (player.getHitpoints() == 0) {
                    primaryStage.setScene(fifth);
            }
            
            if (goblin.getHitpoints() == 0) {
                fight.setMiddle("You've slain the goblin!");
                fight.setContinue(onwards);
            }
            player.setStatus();
            goblin.setStatus();
        });
        
        Button charmer = goblinKing.getOption1();
        charmer.setOnAction((event) -> {
            primaryStage.setScene(fifth);
        });
        
        Button madLad = goblinKing.getOption2();
        madLad.setOnAction((event) ->{
            bossFight.reset();
            player.setStatus();
            king.setStatus();
            handler.setDamageToEnemy(25);
            handler.setDamageToSelf(50);
            primaryStage.setScene(seventh);
        });
        
        Button onwards2 = new Button("Continue");
        onwards2.setOnAction((event) -> {
            primaryStage.setScene(second);
        });
        
        Button strike2 = bossFight.getAttack();
        strike2.setOnAction((event) -> {
            handler.handle(bossFight, player, king);
            
            if (player.getHitpoints() == 0) {
                primaryStage.setScene(fifth);
            }
            
            if (king.getHitpoints() == 0) {
                bossFight.setMiddle("You've slain the Goblin King!");
                bossFight.setContinue(onwards2);
            }
            player.setStatus();
            king.setStatus();
        });
        
        primaryStage.setScene(first);
        primaryStage.show();
    }
    
}
