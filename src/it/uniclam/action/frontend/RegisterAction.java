package it.uniclam.action.frontend;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.db.RegisterDAO;

/**
 * Created by GiovanniTrovini on 20/04/17.
 */

public class RegisterAction extends ActionSupport {
    private String nome;
    private String cognome;
    private String email;
    private String password1;
    private String password2;
    private int point;

    public RegisterAction() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    //setters and getters
    public String execute() {
        int i = RegisterDAO.save(this);
        if (i == 1) {
            return "success";
        } else if (i == 2) {
            return "insert_error";
        }
        return "error";
    }
@Override
    public void validate() {
        if(email.isEmpty()){
            addFieldError("email", "Email Field cannot be left blank!!!");
        }
        else if(password1.isEmpty())
            addFieldError("password1", "Password Field cannot be left blank!!!");

        else if(!password1.equals(password2))
        addFieldError("password2", "Password mismatch!!!");
    }


}