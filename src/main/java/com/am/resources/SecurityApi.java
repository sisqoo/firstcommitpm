package com.am.resources;

import java.security.Principal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import com.am.entity.Tperson;
import com.am.entity.Treporter;
import com.am.entity.Trole;
import com.am.entity.Tuser;
import com.am.entity.Tusersignin;
import com.am.message.request.LoginForm;
import com.am.message.request.SignUpForm;
import com.am.repository.PersonRepository;
import com.am.repository.RoleRepository;
import com.am.repository.UserRepository;
import com.am.repository.UsersigninRepository;
import com.am.security.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/securityapi")
public class SecurityApi {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UsersigninRepository usersigninRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		Tuser userPrincipal = (Tuser) authentication.getPrincipal();
		String jwt = jwtProvider.generateJwtToken(authentication);
		Tusersignin tusersignin = new Tusersignin();
		tusersignin.setToken(jwt);
		tusersignin.setTuser(userPrincipal);
		tusersignin=usersigninRepository.save(tusersignin);
		//return ResponseEntity.ok(Collections.singletonMap("Token", jwt));
		return ResponseEntity.ok(tusersignin);
	}

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser2(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByLoginuser(signUpRequest.getUsername())) {
			return new ResponseEntity<String>("Fail -> Username is already taken!", HttpStatus.BAD_REQUEST);
		}

		if (personRepository.existsByEmailperson(signUpRequest.getEmail())) {
			return new ResponseEntity<String>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);
		}
		try {
			// Creating user's account
			Tperson person = new Tperson();
			person.setNameperson(signUpRequest.getName());
			person.setEmailperson(signUpRequest.getEmail());

			Tuser user = new Tuser();
			user.setEnableduser(1);
			user.setLoginuser(signUpRequest.getUsername());
			user.setPwduser(encoder.encode(signUpRequest.getPassword()));
			user.setTperson(person);
			Set<String> strRoles = signUpRequest.getRole();
			/*
			 * Set<Trole> roles = new HashSet<>();
			 * 
			 * strRoles.forEach(role -> { switch(role) { case "admin": Trole adminRole =
			 * roleRepository.findByNamerole("admin") .orElseThrow(() -> new
			 * RuntimeException("Fail! -> Cause: User Role not find."));
			 * roles.add(adminRole);
			 * 
			 * break; case "pm": Trole pmRole = roleRepository.findByNamerole("pm")
			 * .orElseThrow(() -> new
			 * RuntimeException("Fail! -> Cause: User Role not find.")); roles.add(pmRole);
			 * 
			 * break; default: Trole userRole = roleRepository.findByNamerole("user")
			 * .orElseThrow(() -> new
			 * RuntimeException("Fail! -> Cause: User Role not find."));
			 * roles.add(userRole); } });
			 */

			// user.setTuserroles(tuserroles);
			// Set<Tuser> users=new HashSet<Tuser>(0);
			// users.add(user);
			// person.setTusers(users);
			// personRepository.save(person);
			userRepository.save(user);
		} catch (Exception e) {
			return new ResponseEntity<String>("Fail -> Erreur d'enregitrement ", HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body("User registered successfully!");
	}

	@RequestMapping(value = "/logout/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@CrossOrigin
	public void delete(@PathVariable("id") long id) {
		SecurityContextHolder.clearContext();
		System.out.println("Logout...");
		usersigninRepository.deleteById(id);
	}
	
	@RequestMapping("/token")
	public Map<String, String> token(HttpSession session, HttpServletRequest request) {
		System.out.println("1-remoteHost=" + request.getRemoteHost());
		String remoteHost = request.getRemoteHost();
		int portNumber = request.getRemotePort();
		System.out.println("2-host-port=" + remoteHost + ":" + portNumber);
		System.out.println("3-securitySession=" + RequestContextHolder.currentRequestAttributes().getSessionId());
		return Collections.singletonMap("token", session.getId());

	}

	@RequestMapping("/checkSession")
	public Map<String, String> checkSession() {
		System.out.println("Session active!!");
		return Collections.singletonMap("OK", "OK");
	}

	@RequestMapping(value = "/user/logout", method = RequestMethod.POST)
	public Map<String, String> logout(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * SecurityContextHolder.clearContext(); System.out.println("Logout...");
		 */

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return Collections.singletonMap("OK", "Logout");
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Principal principal) {

		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();

			// String userInfo = WebUtils.toString(loginedUser);
			String userInfo = null;// WebUtils.toString(loginedUser);

			// model.addAttribute("userInfo", userInfo);

			String message = "Hi " + principal.getName() //
					+ "<br> You do not have permission to access this page!";
			// model.addAttribute("message", message);

		}

		return "403Page";
	}

}