package Server;

import javafx.scene.Group;
import javafx.scene.paint.Color;

/**
 * Created by Dhruboo on 6/7/2016.
 */
public class ServerMainBall {

    public ServerBall small;
    public double MainBallCentreX, MainBallCentreY;

    public double vx, vy, MainBallRad;

    public  ServerMainBall(double x, double y, Color clr, Group root){
        small = new ServerBall(x, y, 13, clr, root);
        vx = 0;
        vy = 0;
        MainBallRad = 13;

        MainBallCentreX = x;
        MainBallCentreY = y;
    }

    public void updateMainBall(){

        collisionwithball();
        //updateCentreMainBall();

        collisionwithwall();
        updateCentreMainBall();

        GoalChecking();

        //System.out.println(MainBallCentreX + "  " + MainBallCentreY);
    }

    public void collisionwithwall(){
        if(MainBallCentreX - MainBallRad <= 15 ){
            if(vx < 0) vx = -vx;
        }

        if(MainBallCentreX + MainBallRad >= 330){
            if(vx > 0) vx = -vx;
        }
        if(MainBallCentreY - MainBallRad <= 12 ){
            if(vy < 0) vy = -vy;
        }

        if(MainBallCentreY + MainBallRad >= 585){
            if(vy > 0) vy = -vy;
        }
    }

    public void collisionwithball(){
        double ball1x = Main.server_gamer.centre_x;
        double ball1y = Main.server_gamer.centre_y;

        double ball2x = Main.client_gamer.centre_x;
        double ball2y = Main.client_gamer.centre_y;

        double dist_1 = (ball1x - MainBallCentreX) * (ball1x - MainBallCentreX) + (ball1y - MainBallCentreY) * (ball1y - MainBallCentreY);
        dist_1 = Math.sqrt(dist_1);

        double dist_2 = (ball2x - MainBallCentreX) * (ball2x - MainBallCentreX) + (ball2y - MainBallCentreY) * (ball2y - MainBallCentreY);
        dist_2 = Math.sqrt(dist_2);

        //System.out.println(MainBallCentreX + "   " + MainBallCentreY);
        //System.out.println(vx + "    " + vy);

        //collision with ball_1

        if(dist_1 <= Main.server_gamer.BigBallRad + MainBallRad){

            double newVx = MainBallCentreX - Main.server_gamer.centre_x;
            double newVy = MainBallCentreY - Main.server_gamer.centre_y;

            vx = newVx;
            vy = newVy;

        }

        //collision with ball_2
        else if(dist_2 <= Main.client_gamer.BigBallRad + MainBallRad){

            double newVx = MainBallCentreX - Main.client_gamer.centre_x;
            double newVy = MainBallCentreY - Main.client_gamer.centre_y;

            vx = newVx;
            vy = newVy;

        }

    }

    public void updateCentreMainBall(){
        MainBallCentreX += vx / 2.5;
        MainBallCentreY += vy / 2.5;

        small.setCenterX(MainBallCentreX);
        small.setCenterY(MainBallCentreY);
    }

    public void  updateCentreMainBall(double x, double y){
        MainBallCentreX = x;
        MainBallCentreY = y;

        small.setCenterX(MainBallCentreX);
        small.setCenterY(MainBallCentreY);
    }

    void GoalChecking(){

        if((MainBallCentreX >= 123 && MainBallCentreX <= 217) && (MainBallCentreY + MainBallRad>= 580)){
            Main.client_goal++;



            Main.ball.updateCentreMainBall(172, 300);
            Main.client_gamer.update(170, 80);
            Main.server_gamer.update(170, 515);
            vy = 0;
            vx = 0;
        }

        if((MainBallCentreX >= 123 && MainBallCentreX <= 217) && (MainBallCentreY - MainBallRad <= 20 )){
            Main.server_goal++;
            System.out.println(Main.server_goal);



            Main.ball.updateCentreMainBall(172, 300);
            Main.client_gamer.update(170, 80);
            Main.server_gamer.update(170, 515);
            vy = 0;
            vx = 0;
        }

    }
}
