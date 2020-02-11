package client;


import con_util.ConnectionUtilities;
import con_util.Data;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    public static Stage window;
    public static Scene page_1, page_2 ;

    public static BallForGamer client_gamer, server_gamer;
    public static MainBall ball;

    public static Data data;

    public static Group root_1 = new Group();
    public static Group root_2 = new Group();

    public static ConnectionUtilities connection;

    public static int client_goal = 0, server_goal = 0;



    @Override
    public void start(Stage primaryStage)throws Exception{

        window = primaryStage;


        Parent Root_1 = FXMLLoader.load(getClass().getResource("../client/sample.fxml"));

        Parent Root_2 = FXMLLoader.load(getClass().getResource("../client/game_page.fxml"));

        //Group root_1 = new Group();
        //Group root_2 = new Group();


        root_1.getChildren().add(Root_1);
        root_2.getChildren().add(Root_2);

        server_gamer = new BallForGamer(170, 515, Color.DARKCYAN, root_2);
        client_gamer = new BallForGamer(170, 80, Color.LIME, root_2);
        ball = new MainBall(172, 300, Color.WHITE, root_2);

        new Thread(new Reader(connection)).start();
        new Thread(new WriteToServer(connection)).start();



        primaryStage.setTitle("Pocket Hockey");

        page_1 = new Scene(root_1, 600, 400);

        page_2 = new Scene(root_2, 350, 600);

        primaryStage.setScene(page_1);

        primaryStage.show();



    }


    public static void main(String[] args) {



        connection = new ConnectionUtilities("LocalHost", 44444);

        data = new Data();



        launch(args);



    }
}
