package client;


import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Dhruboo on 6/4/2016.
 */


public class controller_game_page implements Initializable {

    public Label client_goal_show = new Label();
    public Label server_goal_show = new Label();
    public Label end_msg = new Label();


    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }



    public void onClick2(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        System.out.println(x + "  " + y);
    }

    public void BallPosition(MouseEvent event){
        double x = event.getX();
        double y = event.getY();

        if(y >= 265) y = 265;
        if(y <= 37) {
            y = 37;
        }

        if(x >= 305) x = 305;
        if(x <= 42) x = 42;



        Main.client_gamer.update(x, y);

        String s = Integer.toString(Main.server_goal);
        String t = Integer.toString(Main.client_goal);

        client_goal_show.setText(t);
        server_goal_show.setText(s);

        if(Main.server_goal == 3) {
            end_msg.setText("YOU LOSE");
        }

        if(Main.client_goal == 3){
            end_msg.setText("YOU WIN");
        }



        //System.out.println(x + "  " + y);



    }


}
