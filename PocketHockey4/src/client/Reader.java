package client;

import con_util.ConnectionUtilities;
import con_util.Data;

/**
 * Created by Dhruboo on 6/8/2016.
 */
public class Reader implements Runnable {

    public ConnectionUtilities connection;

    public Reader(ConnectionUtilities con){
        connection = con;
    }


    @Override
    public void run() {
        while (true){

            Object o = connection.read();

            Data ob = (Data) o;

            Main.ball.updateMainBall(ob.main_ball_x, ob.main_ball_y);


            Main.server_gamer.update(ob.server_ball_x, ob.server_ball_y);


            System.out.println(ob.server_goal + "   " + ob.client_goal);


            Main.server_goal = ob.server_goal;
            Main.client_goal = ob.client_goal;




            if( ob instanceof  Data) {
                Main.data = ob;
                //System.out.println(ob.main_ball_x + "  " + ob.main_ball_y);
            }
            else System.out.println("wrong data");


            //System.out.println(ob.main_ball_x + "    " + ob.main_ball_y);
        }
    }
}
