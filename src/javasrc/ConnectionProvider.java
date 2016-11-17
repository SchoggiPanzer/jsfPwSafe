package javasrc;

import java.sql.Connection;
import java.sql.DriverManager;
import static javasrc.Provider.*;

/**
 * Created by Daniel Hirt ond Michel Tüscher
 */
public class ConnectionProvider {

    private static Connection con=null;

    static {
        try {
            Class.forName(DRIVER).newInstance();
            con = DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);
            System.out.println("Connected to db");
        } catch (Exception e){
            System.err.println("Got an exception");
            System.err.println(e.getMessage());
        }
    }

    public static Connection getCon(){
        return con;
    }

}
