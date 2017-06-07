package it.uniclam.model;

/**
 * Gestisce il modello Singleton
 * Ha lo scopo di garantire che di una determinata classe venga creata una e una sola istanza,
 * e di fornire un punto di accesso globale a tale istanza.
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
     private static PhotoView myphoto;

    public static PhotoView getMyphoto() {
        return myphoto;
    }

    public static void setMyphoto(PhotoView myphoto) {
        Singleton.myphoto = myphoto;
    }



    public static Monument getMymonument() {
        return mymonument;
    }

    public static void setMymonument(Monument mymonument) {
        Singleton.mymonument = mymonument;
    }
}
