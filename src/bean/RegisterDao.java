package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Daniel Hirt ond Michel Tüscher
 *
 * Data Access Object for the Registration
 */
public class RegisterDao {

    /**
     * Insert the registered user in the db
     * @param u user datas
     * @return status of the insertion
     */
    public static int register(User u){
        int status = 0;
        String uname, pw, fname, lname, email;

        uname = u.getUname();
        pw = u.getPw();
        fname = u.getFname();
        lname = u.getLname();
        email = u.getEmail();

        try {
            Connection con = ConnectionProvider.getCon();

            PreparedStatement ps = con.prepareStatement("INSERT INTO users (username, password, fname, lname, email) " +
                    "VALUE ('"+uname+"','"+pw+"','"+fname+"','"+lname+"','"+email+"') ");

            status = ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Got an exception");
            System.err.println(e.getMessage());
        }

        return status;
    }
}
