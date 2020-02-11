package Server;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by Dhruboo on 6/7/2016.
 */
public class ServerBall extends Circle {
    ServerBall(double x, double y, double radius, Color color, Group root){
        super(x, y, radius, color);

        root.getChildren().add(this);

    }
}
