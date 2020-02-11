package Server;

import con_util.ConnectionUtilities;
import con_util.Data;

/**
 * Created by Dhruboo on 6/8/2016.
 */
public class WriteToclient implements Runnable {

    public ConnectionUtilities connection;


    public WriteToclient(ConnectionUtilities con){
        connection = con;

    }

    @Override
    public void run() {



        while (true){
            Main.data.main_ball_x = Main.ball.MainBallCentreX;
            Main.data.main_ball_y = Main.ball.MainBallCentreY;

            Main.data.server_ball_x = Main.server_gamer.centre_x;
            Main.data.server_ball_y = Main.server_gamer.centre_y;

            //System.out.println(Main.data.main_ball_x + "   " + Main.data.main_ball_y);



            Data ob = new Data(Main.server_gamer.centre_x, Main.server_gamer.centre_y, Main.client_gamer.centre_x, Main.client_gamer.centre_y, Main.ball.MainBallCentreX, Main.ball.MainBallCentreY, Main.server_goal, Main.client_goal);



            connection.write(ob);


        }
    }
}
