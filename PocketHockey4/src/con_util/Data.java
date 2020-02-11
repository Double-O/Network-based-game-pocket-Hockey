package con_util;

import Server.ServerBall;

import java.io.Serializable;
import java.security.PublicKey;

/**
 * Created by Dhruboo on 6/6/2016.
 */
public class Data implements Serializable{
    public double server_ball_x, server_ball_y, clientball_x, clientball_y;
    public int client_goal, server_goal;

    public double main_ball_x, main_ball_y;

    public  Data(){

        server_ball_x = 170;
        server_ball_y = 515;

        clientball_x = 170;
        clientball_x = 80;

        main_ball_x = 170;
        main_ball_y = 300;

        client_goal = 0;
        server_goal = 0;

    }

    public Data(double serv_ball_x, double serv_ball_y, double client_ball_x, double client_ball_y, double main_x, double main_y, int serv_goal, int clnt_goal){
        this.server_ball_x = serv_ball_x;
        this.server_ball_y = serv_ball_y;

        this.clientball_x = client_ball_x;
        this.clientball_y = client_ball_y;

        this.main_ball_x = main_x;
        this.main_ball_y = main_y;

        this.server_goal = serv_goal;
        this.client_goal = clnt_goal;
    }



}
