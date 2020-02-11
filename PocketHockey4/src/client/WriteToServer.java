package client;

import con_util.ConnectionUtilities;
import con_util.Data;

/**
 * Created by Dhruboo on 6/8/2016.
 */
public class WriteToServer implements Runnable{
    public ConnectionUtilities connection;


    public  WriteToServer(ConnectionUtilities con){
        connection = con;

    }


    @Override
    public void run() {
        //System.out.println("welcome to writetoserver");

        while (true){

            Main.data.clientball_x = Main.client_gamer.centre_x;
            Main.data.clientball_y = Main.client_gamer.centre_y;



            Data ob = new Data(Main.server_gamer.centre_x, Main.server_gamer.centre_y, Main.client_gamer.centre_x, Main.client_gamer.centre_y, Main.ball.MainBallCentreX, Main.ball.MainBallCentreY, Main.server_goal, Main.client_goal);




            connection.write(ob);

            //System.out.println(Main.client_gamer.centre_x + "   " + Main.client_gamer.centre_y);



        }
    }
}
