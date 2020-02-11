package Server;

import con_util.ConnectionUtilities;
import con_util.Data;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Dhruboo on 6/7/2016.
 */
public class Main extends Application {

    public static Stage window;
    public static Scene page_1, page_2 ;

    public static ServerBallForGamer client_gamer, server_gamer;
    public static ServerMainBall ball;

    public static Data data;

    public static Group root_1 = new Group();
    public static Group root_2 = new Group();

    public static ConnectionUtilities connection;

    public static int client_goal = 0, server_goal = 0;


    @Override
    public void start(Stage primaryStage)throws Exception{

        window = primaryStage;



        Parent Root_1 = FXMLLoader.load(getClass().getResource("Server_first_page.fxml"));

        Parent Root_2 = FXMLLoader.load(getClass().getResource("Server_game_page.fxml"));

        //Parent Root_3 = FXMLLoader.load(getClass().getResource("WaitForClient.fxml"));

        //Group root_1 = new Group();
        //Group root_2 = new Group();
        //Group root_3 = new Group();

        root_1.getChildren().add(Root_1);
        root_2.getChildren().add(Root_2);
        //root_3.getChildren().add(Root_3);

        server_gamer = new ServerBallForGamer(170, 515, Color.DARKCYAN, root_2);
        ball = new ServerMainBall(172, 300, Color.WHITE, root_2);

        client_gamer = new ServerBallForGamer(170, 80, Color.LIME, root_2);


        new Thread(new ReaderFromClient(connection)).start();
        new Thread(new WriteToclient(connection)).start();

        primaryStage.setTitle("Pocket Hockeyserver");

        page_1 = new Scene(root_1, 600, 400);

        page_2 = new Scene(root_2, 350, 600);

        //page_3 = new Scene(root_3, 528, 200);

        primaryStage.setScene(page_1);

        primaryStage.show();




    }


    public static void main(String[] args) {
        ServerSocket servsocket = null;

        try {
            servsocket = new ServerSocket(44444);

            System.out.println("not connected");

            Socket clientSocket= servsocket.accept();



            connection = new ConnectionUtilities(clientSocket);




        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("error");
        }

        data = new Data();

        launch(args);

    }
}
