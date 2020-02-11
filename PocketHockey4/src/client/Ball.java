package client;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by Dhruboo on 6/4/2016.
 */
public class Ball extends Circle {


    Ball(double x, double y, double radius, Color color, Group root){
        super(x, y, radius, color);

        root.getChildren().add(this);

    }



}
