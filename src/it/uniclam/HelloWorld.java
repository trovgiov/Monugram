package it.uniclam;

import com.opensymphony.xwork2.ActionSupport;



public class HelloWorld extends ActionSupport{

    private static final long serialVersionUID = 1L;

    private String message;

    private String userName;

    public HelloWorld() {
    }

    public String execute() {
        setMessage("Hello " + getUserName());
        System.out.println("Ritorno"+getUserName());
        return "SUCCESS";


    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
