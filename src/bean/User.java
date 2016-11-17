package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Daniel Hirt ond Michel Tüscher
 *
 * User bean. Contains Username and Password
 */
@ManagedBean(name = "user")
public class User {
    private String uname, pw, email, lname, fname;
    private int id;

    /**
     * sets the id of the user
     * @param id userid
     */
    public void setId(int id){ this.id = id; }

    /**
     * gets the id of the user
     * @return userid
     */
    public int getId(){
        return id;
    }

    /**
     * gets the username of the user
     * @return username
     */
    public String getUname(){
        return uname;
    }

    /**
     * sets the username of the user
     * @param uname username
     */
    public void setUname(String uname){
        this.uname = uname;
    }

    /**
     * gets the password of the user
     * @return password
     */
    public String getPw(){
        return pw;
    }

    /**
     * sets the password of the user
     * @param pw password
     */
    public void setPw(String pw){
        this.pw = pw;
    }

    /**
     * gets the email of the user
     * @return email
     */
    public String getEmail(){
        return email;
    }

    /**
     * sets the email of the user
     * @param uemail email
     */
    public void setEmail(String uemail){
        this.email = uemail;
    }

    /**
     * gets the lastname of the user
     * @return lastname
     */
    public String getLname() { return lname; }

    /**
     * sets the lastname of the user
     * @param lname lastname
     */
    public void setLname(String lname){ this.lname = lname; }

    /**
     * gets the firstname of the user
     * @return firstname
     */
    public String getFname() { return fname; }

    /**
     * sets the firstname of the user
     * @param fname firstname
     */
    public void setFname(String fname){ this.fname = fname; }

    public String register() {
        int status = 0;
        try {
            Connection con = ConnectionProvider.getCon();

            PreparedStatement ps = con.prepareStatement("INSERT INTO users (username, password, fname, lname, email) " +
                    "VALUE ('"+uname+"','"+pw+"','"+fname+"','"+lname+"','"+email+"') ");

            status = ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Got an exception");
            System.err.println(e.getMessage());
        }

        if (status>0) return "success";
        else return "unsuccess";
    }

    public String validate(){
        try {
            Connection con = ConnectionProvider.getCon();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password= ?");

            ps.setString(1, uname);
            ps.setString(2, pw);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){

                return "success";
            }
        } catch (Exception e){
            System.err.println("Got an exception");
            System.err.println(e.getMessage());
        }

        return "error";
    }


}
