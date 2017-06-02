package it.uniclam.mail;

/**
 * Created by Enifix on 31/05/2017.
 */

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Properties;

public class SendUserMail extends ActionSupport implements ServletRequestAware{
    private String to;
    public static final String from = "monugramapp@gmail.com";

    public static String getM_password() {
        return m_password;
    }

    public static final String m_password = "unicas2017";
    public static final String smtpServ = "smtp.gmail.com";
    private String subject;
    private String message;
    private HttpServletRequest hsr;
    private HttpSession hs;
    private int i;

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    private int idUtente;


    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.hsr=hsr;
    }

    // Also include an inner class that is used for authentication purposes
    private class SMTPAuthenticator extends Authenticator{
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, m_password);
        }
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to.toLowerCase();
    }

    public String getFrom() {
        return from;
    }



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


    public String execute(){


        idUtente = getIdUtente();

        System.out.println("Dentro l'action");
        System.out.println("Id Utente: "+idUtente);

        hs=hsr.getSession();
        try{
            if(hs.getAttribute("sms")!=null){
                hs.removeAttribute("sms");
            }
        }catch(Exception e){
            System.out.println("IN EXECUTE() : FIRST TRY FAILED");
        }
        try{
            i=sendMail();
            if(i==0){
                hs.setAttribute("sms", "Your E-Mail has been sent successfully to :"+to);
                return "success";

            }else{
                hs.setAttribute("sms", "Failed to Send Email to :"+to+" : Authentication Failed ");
            }
        }catch(Exception e){
            System.out.println("IN EXECUTE : SECOND TRY FAILED");
            System.out.println(e);
            hs.setAttribute("sms", "Error:::"+e);
        }
        return "error";
    }

    public int sendMail(){
        try
        {
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
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            msg.setSubject(subject);
            msg.setText(message);
            // -- Set some other header information --
            msg.setHeader("MyMail", "Mr. XYZ" );
            msg.setSentDate(new Date());
            // -- Send the message --
            Transport.send(msg);
            System.out.println("Message sent to"+to+" OK." );
            return 0;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Exception "+ex);
            return -1;
        }
    }




}