package Server;

/**
 * Created by Dhruboo on 6/7/2016.
 */


import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Dhruboo on 6/4/2016.
 */


public class Server_controller_game_page implements Initializable {

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

        if(y <= 324) y = 324;
        if(y >= 560) y = 560 ;

        if(x >= 305) x = 305;
        if(x <= 42) x = 42;


        Main.server_gamer.update(x, y);

        String s = Integer.toString(Main.server_goal);
        String t = Integer.toString(Main.client_goal);

        client_goal_show.setText(t);
        server_goal_show.setText(s);

        if(Main.server_goal == 3) {
            end_msg.setText("YOU WIN");
            Server_first_page_controller.main_ball_movement.stop();

        }

        if(Main.client_goal == 3){
            end_msg.setText("YOU LOSE");
            Server_first_page_controller.main_ball_movement.stop();
        }


        //System.out.println(x + "  " + y);



    }


}
