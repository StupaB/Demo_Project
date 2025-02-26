package ro.msg.javatraining.demo.project.controller.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.javatraining.demo.project.model.User;
import ro.msg.javatraining.demo.project.service.UserDetailsImpl;
import ro.msg.javatraining.demo.project.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/app")
public class AppController {



	@Autowired
	UserDetailsServiceImpl userDetailsService;


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

	@GetMapping("/user-details")
	@Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
	public User getUserDetails() {
		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDetailsService.findUserByUsername(userDetails.getUsername());
	}

}