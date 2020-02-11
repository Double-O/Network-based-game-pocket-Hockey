package con_util;

/**
 * Created by Dhruboo on 6/6/2016.
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtilities {
    public Socket sc;
    public ObjectInputStream ois;
    public ObjectOutputStream oos;

    public ConnectionUtilities(String host, int port){

        //System.out.println("CLient connection completed");
        try {
            sc=new Socket(host,port);
            oos=new ObjectOutputStream(sc.getOutputStream());
            ois=new ObjectInputStream(sc.getInputStream());
        }
        catch(Exception e)
        {
            System.out.println("client connection jhamela");
        }

    }

    public ConnectionUtilities(Socket socket){

        //System.out.println(" Server Connection Completed");
        try {
            sc=socket;
            oos=new ObjectOutputStream(sc.getOutputStream());
            ois=new ObjectInputStream(sc.getInputStream());
        }
        catch(Exception e)
        {
            System.out.println("server connection jhamela");
        }
    }

    public void write(Object o){

        try {
            oos.writeObject(o);
        } catch (IOException e) {
            System.out.println("writing error");
        }

    }

    public Object read(){
        try {
            Object o=ois.readObject();
            return o;
        } catch(Exception e){
            System.out.println("reading error");
        }
        return  null;
    }

}
