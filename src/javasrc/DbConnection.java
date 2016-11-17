package javasrc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Daniel Hirt ond Michel Tüscher
 */
public class DbConnection {

    public static Connection getConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/passwordStorage", "dbUser", "password");
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {}
    }
}
