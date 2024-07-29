package ro.msg.javatraining.demo.project.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.javatraining.demo.project.dto.EmailDetailsDto;
import ro.msg.javatraining.demo.project.model.Email;
import ro.msg.javatraining.demo.project.model.User;
import ro.msg.javatraining.demo.project.service.AirportService;
import ro.msg.javatraining.demo.project.service.EmailService;

@RestController
@RequestMapping("/app")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private AirportService airportService;

    @PostMapping("/send-email")
    @Secured(value = {"ROLE_USER", "ROLE_ADMIN"})

    public String sendEmail(@RequestBody EmailDetailsDto emailDetails) {
        try {
            emailService.sendAirplaneDetailsMessage(emailDetails.getTo(), emailDetails.getSubject(), emailDetails.getText());
            return "Email sent successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error in sending email: " + e.getMessage();
        }
    }
}
