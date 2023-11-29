
import java.util.Properties;
/* 
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
*/
import java.util.ArrayList;

public class Notifications {
    private String subject;
    private String body;
    private String Sender;
    private String text;
    private String systemNotification;
    private ArrayList<String> recipients;
    private String schedule; //should be Schedule class

    public void generateEmailNotification() {
        //recipient = getUserEmailfromlogindatabasesomehow
        //body = " You're registration for " + bus.getBusID + " for route " + bus.getBusRoute + " at " + bus.getArrivalTime + "on " + bus.getArrivalDate + "has been confirmed. Thanks for working with pelian drive :)" ;
        /*
         public static void main(String[] args) {
        // Sender's email address
        String senderEmail = "your_email@example.com";
        // Sender's password (make sure to use an app-specific password if using Gmail)
        String senderPassword = "your_password";
        // Recipient's email address
        String recipientEmail = "recipient_email@example.com";

        // Set up mail properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.yourprovider.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a session with the specified properties and authenticator
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set the sender address
            message.setFrom(new InternetAddress(senderEmail));

            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            // Set the subject
            message.setSubject("Test Email");

            // Set the content
            message.setText("This is a test email sent using JavaMail API.");

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
         */
    
    }

    public void sendEmailNotification() {}

    public void generateTextNotification() {}

    public void sendTextNotification() {}
    
    public void identifyRecipients() {}

    public void generateSystemNotifications() {}

    public void displaySystemNotifications() {}



}
