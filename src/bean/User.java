package bean;

/**
 * Created by Daniel Hirt ond Michel Tüscher
 *
 * User bean. Contains Username and Password
 */

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


}
