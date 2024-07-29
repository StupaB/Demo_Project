package ro.msg.javatraining.demo.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.msg.javatraining.demo.project.util.SSLUtil;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {
		SSLUtil.turnOffSslChecking();
		SpringApplication.run(DemoApplication.class, args);
	}
}
