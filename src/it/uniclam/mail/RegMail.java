package it.uniclam.mail;

/**
 * Created by Enifix on 28/04/2017.
 */
import com.opensymphony.xwork2.ActionSupport;
import it.uniclam.action.frontend.RegisterAction;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Properties;

public class RegMail extends ActionSupport implements ServletRequestAware
{
    RegisterAction r;
    public String to = r.getEmail();
    public static final String from = "monugramapp@gmail.com";
    public static final String m_password = "unicas2017";
    public static final String smtpServ = "smtp.gmail.com";
    public static final String subject = "Welcome to Monugram";
    public String message = "Hi, \n Thank you for your registration to MonugramAPP. \nYour credentials are: \nUsername: ";
    public String user_pass;
    private HttpServletRequest hsr;
    private HttpSession hs;
    private int i;


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

    /*public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to.toLowerCase();
    }*/

    public int sender(){
        try
        {
            Properties props = System.getProperties();
            // -- Attaching to default Session, or we could start a new one --
            props.put("mail.transport.protocol", "smtp" );
            props.put("mail.smtp.starttls.enable","true" );
            props.put("mail.smtp.host",smtpServ);
            props.put("mail.smtp.auth", "true" );
            Authenticator auth = new RegMail.SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
            // -- Create a new message --
            Message msg = new MimeMessage(session);
            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            // -- FIND CREDENTIALS --
            user_pass = SendMail.findPassword(to);
            System.out.println("Password "+user_pass);

            System.out.println("Username: "+to);

            message = message + to + "\nPassword: " + user_pass;
            // -------------------------------------

            msg.setSubject(subject);
            msg.setText(message);
            // -- Set some other header information --
            msg.setHeader("MyMail", "Mr. XYZ" );
            msg.setSentDate(new Date());

            // -- Send the message --
            Transport.send(msg);
            System.out.println("Message sent to "+to+" OK." );
            return 0;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Exception "+ex);
            return -1;
        }
    }

 @Override
    public String execute(){
        hs=hsr.getSession();
        try{
            if(hs.getAttribute("sms")!=null){
                hs.removeAttribute("sms");
            }
        }catch(Exception e){
            System.out.println("IN EXECUTE() : FIRST TRY FAILED");
        }
        try{
            i=sender();
            if(i==0){
                hs.setAttribute("sms", "Your E-Mail has been sent successfully to :"+to);
            }else{
                hs.setAttribute("sms", "Failed to Send Email to :"+to+" : Authentication Failed ");
            }
            return "success";
        }catch(Exception e){
            System.out.println("IN EXECUTE : SECOND TRY FAILED");
            System.out.println(e);
            hs.setAttribute("sms", "Error:::"+e);
            return "error";
        }
    }
}
