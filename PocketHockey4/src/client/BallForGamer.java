package client;

import client.Ball;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import static javafx.scene.paint.Color.BLACK;

/**
 * Created by Dhruboo on 6/4/2016.
 */

public class BallForGamer{

    public Ball ball_big, ball_small;

    public double centre_x, centre_y, SmallBallRad, BigBallRad;

    public BallForGamer(double x, double y, Color color, Group root){

        ball_big = new Ball(x, y, 25, color, root);
        ball_small = new Ball(x, y, 15, BLACK, root);

        centre_x = x;
        centre_y = y;

        SmallBallRad = 15;
        BigBallRad = 25;
    }

    public void update(double x, double y){

        ball_big.setCenterX(x);
        ball_big.setCenterY(y);

        ball_small.setCenterX(x);
        ball_small.setCenterY(y);

        centre_x = x;
        centre_y = y;


    }


}
