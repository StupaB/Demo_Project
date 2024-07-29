package ro.msg.javatraining.demo.project.model;


import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email
{
    // Getters and Setters
    private String to;
    private String subject;
    private String text;



}

