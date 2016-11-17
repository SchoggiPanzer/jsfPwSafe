package javasrc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Daniel Hirt ond Michel Tüscher
 */
public class LoginDAO {

    public static boolean validate(String user, String password){
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DbConnection.getConnection();
            ps = con.prepareStatement("Select username, password from users where username = ? and password = ?");
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //result found, means valid inputs
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DbConnection.close(con);
        }
        return false;
    }
}
