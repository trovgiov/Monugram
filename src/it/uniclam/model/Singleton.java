package it.uniclam.model;

/**
 * Created by GiovanniTrovini on 01/05/17.
 */
public class Singleton {
    public static User getMyUser() {
        return myUser;
    }

    public static void setMyUser(User myUser) {
        Singleton.myUser = myUser;
    }

    private static User myUser;
    private static Monument mymonument;

    public static Monument getMymonument() {
        return mymonument;
    }

    public static void setMymonument(Monument mymonument) {
        Singleton.mymonument = mymonument;
    }
}
