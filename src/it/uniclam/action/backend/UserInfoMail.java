package it.uniclam.action.backend;

import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.mail.SendUserMail;
import it.uniclam.model.PhotoView;
import it.uniclam.model.Singleton;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Properties;

public class UserInfoMail extends ActionSupport implements ServletRequestAware {


    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;


    public String execute() throws MessagingException {

        PhotoView p = Singleton.getMyphoto();

         String subject = getSubject();
        String messaggio = getMessage();
         String email = p.getEmail();




        invia(subject, messaggio, email);

        return "success";
    }


    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {

    }


    public static void invia(String oggetto, String messaggio, String email) throws MessagingException {

        final String smtpServ = "smtp.gmail.com";

        String from ="appmonugram@gmail.com";


         Properties props = System.getProperties();
        // -- Attaching to default Session, or we could start a new one --
        props.put("mail.transport.protocol", "smtp" );
        props.put("mail.smtp.starttls.enable","true" );
        props.put("mail.smtp.host",smtpServ);
        props.put("mail.smtp.auth", "true" );
        Authenticator auth = new SendUserMail.SMTPAuthenticator();
        Session session = Session.getInstance(props, auth);
        // -- Create a new message --
        Message msg = new MimeMessage(session);
        // -- Set the FROM and TO fields --
        msg.setFrom(new InternetAddress(from));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
        msg.setSubject(oggetto);
        msg.setText(messaggio);
        // -- Set some other header information --
        msg.setHeader("MyMail", "Mr. XYZ" );
        msg.setSentDate(new Date());
        // -- Send the message --
        Transport.send(msg);
        System.out.println("Message sent to"+email+" OK." );


    }

}