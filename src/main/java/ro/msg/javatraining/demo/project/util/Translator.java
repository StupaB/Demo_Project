package ro.msg.javatraining.demo.project.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Translator {
    public static void main(String[] args) {
        Locale locale_it_IT = new Locale("it", "IT");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("res.bundle",locale_it_IT);
        System.out.println(resourceBundle.getString("welcome"));
    }
}
