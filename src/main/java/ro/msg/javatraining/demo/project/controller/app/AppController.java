package ro.msg.javatraining.demo.project.controller.app;


import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.javatraining.demo.project.service.UserDetailsImpl;

@RestController
@RequestMapping("/app")
public class AppController {

	
	@GetMapping("/user")
	@Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
	public String userAccess() {
		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDetails.getUsername() + " user here";
	}

	@GetMapping("/admin")
	@Secured(value = {"ROLE_ADMIN"})
	public String adminAccess() {
		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDetails.getUsername() + " admin here";
	}
}