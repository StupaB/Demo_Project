package ro.msg.javatraining.demo.project.dto;

import lombok.Getter;

@Getter
public class EmailDetailsDto {
    // Getters and Setters
    private String to;
    private String subject;
    private String text;

    public void setTo(String to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }
}
