package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Daniel Hirt ond Michel Tüscher
 *
 * Data Access Object for Login
 */
public class LoginDao {

    /**
     * validate if the user is in the database
     * @param u datas from the user
     * @return user datas when in database else null
     */
    public static User validate(User u){
        try {
            Connection con = ConnectionProvider.getCon();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password= ?");

            ps.setString(1, u.getUname());
            ps.setString(2, u.getPw());

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                User user = new User();
                user.setId(id);
                user.setUname(username);
                return user;
            }
        } catch (Exception e){
            System.err.println("Got an exception");
            System.err.println(e.getMessage());
        }

        return null;
    }
}
