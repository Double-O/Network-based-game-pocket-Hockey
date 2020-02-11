package Server;


import con_util.ConnectionUtilities;
import con_util.Data;

/**
 * Created by Dhruboo on 6/8/2016.
 */

public class ReaderFromClient implements Runnable {

    public ConnectionUtilities connection;
    public Data data;

    public ReaderFromClient(ConnectionUtilities con){
        connection = con;
        data = new Data();
    }

    @Override
    public void run() {

        while (true){

            Object o = connection.read();
            Data ob = (Data) o;



            if(ob instanceof Data){

                data = ob;
            }

            else System.out.println("wrong data");



            Main.client_gamer.update(ob.clientball_x, ob.clientball_y);

            //System.out.println(Main.client_gamer.centre_x + "    " + Main.client_gamer.centre_y);

            //System.out.println(ob.clientball_x);
        }
    }
}
