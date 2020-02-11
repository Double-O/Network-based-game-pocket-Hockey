package Server;


import con_util.Data;
import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Dhruboo on 6/7/2016.
 */
public class Server_first_page_controller implements Initializable{

    public static AnimationTimer main_ball_movement;

    @FXML
    public void GoToGamePage(Event event){



        Main.window.setScene(Main.page_2);


        main_ball_movement = new AnimationTimer() {
            @Override
            public void handle(long now) {

                Main.ball.updateMainBall();
                String s = Integer.toString(Main.server_goal);
                String t = Integer.toString(Main.client_goal);

            }
        };

        main_ball_movement.start();

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
