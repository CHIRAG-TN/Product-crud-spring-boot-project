package com.example.demo.jwtSecurity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	
	
	public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder,JwtService jwtService) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = new JwtService();
	}


	@PostMapping("/register")
	public String register(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userRepository.save(user);
		return "Registered";
		
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {


	    User user = userRepository
	            .findByUsername(request.getUsername())
	            .orElseThrow();


	    if(passwordEncoder.matches(
	            request.getPassword(),
	            user.getPassword()
	    )) {

	        return jwtService.generateToken(user);

	    }


	    return "Invalid credentials";
	}
}
