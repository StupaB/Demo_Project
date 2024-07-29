package ro.msg.javatraining.demo.project.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.javatraining.demo.project.model.Email;
import ro.msg.javatraining.demo.project.model.User;
import ro.msg.javatraining.demo.project.service.EmailService;

@RestController
@RequestMapping("/app")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    @Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
    public String sendEmail(@RequestBody Email emailDetails) {
        try {
            // Assuming you have a way to get a User object from emailDetails or context
            User user = new User(); // This should be fetched from your user management logic
            user.setEmail(emailDetails.getTo()); // Set email fetched from emailDetails
            emailService.sendSimpleMessage(user, emailDetails.getSubject(), emailDetails.getText());
            return "Email sent successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error in sending email: " + e.getMessage();
        }
    }
}
