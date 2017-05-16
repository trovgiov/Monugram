package it.uniclam.action.backend;

/**
 * Created by GiovanniTrovini on 21/04/17.
 */


import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.LoginDAO_back;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public  class Login_back extends ActionSupport implements SessionAware {
    private String username, password;


    //private String photo;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    SessionMap sessionmap;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String execute() {

        boolean check = LoginDAO_back.validate(username, password);

        HttpServletRequest req = ServletActionContext.getRequest();
        setUsername(req.getParameter("username"));
        setPassword(req.getParameter("password"));


        if (LoginDAO_back.validate(username, password)) {


            // chiusura rs2 e stmt2

            // chiusura rs e stmt


            return "success";
        } else {
            return "log_error";
        }
    }


    @Override
    public void setSession(Map<String, Object> map) {

    }
}