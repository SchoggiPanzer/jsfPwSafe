package bean;

/**
 * Created by Daniel Hirt ond Michel Tüscher
 *
 * Contains all Datas for the connection to the database
 */
public interface Provider {
    String DRIVER = "com.mysql.jdbc.Driver";
    String CONNECTION_URL = "jdbc:mysql://127.0.0.1:3306/passwordStorage";
    String USERNAME = "dbUser";
    String PASSWORD = "password";
}
