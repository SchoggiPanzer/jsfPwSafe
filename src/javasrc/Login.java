package javasrc;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by Daniel Hirt ond Michel Tüscher
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private String pw, msg, user;

    public String getPwd() {
        return pw;
    }

    public void setPwd(String pw) {
        this.pw = pw;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String validate() {
        boolean valid = LoginDAO.validate(user, pw);
        if(valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "overview";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Incorrect Username and Password", "Please enter correct Username and Password"));
            return "index";
        }
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "index";
    }
}
