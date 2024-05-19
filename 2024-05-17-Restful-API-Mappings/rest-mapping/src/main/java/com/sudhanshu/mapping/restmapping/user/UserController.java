package com.sudhanshu.mapping.restmapping.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudhanshu.mapping.restmapping.user.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserController {
	private UserDaoService service;

	public UserController(UserDaoService service) {
		super();
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> allUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		User user = service.getUserById(id);
		if(user==null) {
			throw new UserNotFoundException("Id: "+ id+" Not Found");
		}
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		service.saveUser(user);
		// return ResponseEntity.created(null).build(); // no content returned with 201 status
		// or
		return ResponseEntity.status(HttpStatus.CREATED).body(user); // returning added user content
	}

	@GetMapping("/users-http")
	public ResponseEntity<List<User>> allUserWithRequestStatus() {
		// return ResponseEntity.ok(service.getAllUsers()); // ideally it should return - 200 OK
		return ResponseEntity.created(null).build(); // just for example it is returned 201 - CREATED status
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deletebyId(id);
	}
	
	// REST API - Versioning 
	
	// 1 - URI versioning 
	@GetMapping("/users/v1")
	public List<User> allUsersv1() {
		return service.getAllUsers();
	}
	
	@GetMapping("/users/v2")
	public List<User> allUsersv2() {
		service.getAllUsers().remove(0);
		return service.getAllUsers();
	}
	
	// 2 Request parameter versioning 
	@GetMapping(path = "/users", params = "version=1")
	public List<User> allUsersRPv1() {
		return service.getAllUsers();
	}
	
	@GetMapping(path = "/users", params = "version=2")
	public List<User> allUsersRPv2() {
		service.getAllUsers().remove(0);
		return service.getAllUsers();
	}
	
	// 3 Custom Header versioning 
	@GetMapping(path = "/users", headers = "X-API-VERSION=1")
	public List<User> allUsersHv1() {
		return service.getAllUsers();
	}
	
	@GetMapping(path = "/users", headers = "X-API-VERSION=2")
	public List<User> allUsersHv2() {
		service.getAllUsers().remove(0);
		return service.getAllUsers();
	}
	
	// 4 Media Type versioning 
	@GetMapping(path = "/users", produces = "application/vnd.company.app-v1+json")
	public List<User> allUsersMv1() {
		return service.getAllUsers();
	}
	
	@GetMapping(path = "/users", headers = "application/vnd.company.app-v2+json")
	public List<User> allUsersMv2() {
		service.getAllUsers().remove(0);
		return service.getAllUsers();
	}
}
