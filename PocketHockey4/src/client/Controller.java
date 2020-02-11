package client;

import con_util.Data;
import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {



    @FXML
    public void GoToGamePage(Event event){



        Main.window.setScene(Main.page_2);

        /*
        main_ball_movement = new AnimationTimer() {
            @Override
            public void handle(long now) {



                Main.ball.updateMainBall();


            }
        };

        main_ball_movement.start();*/


    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
