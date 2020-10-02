package com.taftayani.registration.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taftayani.registration.model.User;
import com.taftayani.registration.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repository;

	@GetMapping("/users")
	User inject() {
		User user = new User();
		user.setDob(new Date());
		user.setEmail("user@mail.com");
		user.setFirstName("first");
		return repository.save(user);
	}
	
	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	User save(@RequestBody User requser) {
		User user = new User();
		user.setDob(requser.getDob());
		user.setEmail(requser.getEmail());
		user.setFirstName(requser.getFirstName());
		user.setLastName(requser.getLastName());
		return repository.save(user);
	}
	@GetMapping("/user/{id}")
	User getById(@PathVariable int id) {
		System.out.println(id);
		return repository.findById(id).orElse(null);
	}
	@PostMapping("/saveuser2")
    public ResponseEntity<?> getSearchResultViaAjax(@RequestBody User user, Errors errors) {

        User result = new User();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            
            return ResponseEntity.badRequest().body(result);

        }        
        
        result = repository.save(user);
        return ResponseEntity.ok(result);

    }

}
