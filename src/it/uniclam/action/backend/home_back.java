package it.uniclam.action.backend;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.model.Session;
import it.uniclam.model.Singleton;
import it.uniclam.model.User;

/**
 * Created by GiovanniTrovini on 21/05/17.
 */
public class home_back extends ActionSupport {



    public String execute (){



        Session s = Singleton.getMysession();
        System.out.println("Session id " +s.getId());

        User u = Singleton.getMyUser();
        System.out.println("Username " +u.getUsername());



        return "success";


    }
}
