package com.matleivs.apps.webservices.ui.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matleivs.apps.webservices.ui.model.response.User;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	@GetMapping
	public String getUsers(@RequestParam(value = "page") int pageVal,
			@RequestParam(value = "limit", defaultValue = "2") int limitVal,
			@RequestParam(value = "sort", required = false) String sortVal) {
		if (sortVal == null)
			sortVal = "desc";
		return "get Users was called with page " + pageVal + " and limit " + limitVal + " and sort " + sortVal;
	}

	@GetMapping(path = "/{userId}", produces = { 
			MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE })
	public User getUser(@PathVariable String userId) {

		User restUser = new User();
		restUser.setFirstName("Hakuna");
		restUser.setLastName("Matata");
		restUser.setEmail("hakuna@matata.com");

		return restUser;
	}

	@PostMapping
	public String createUser() {
		return "creatUser was called";
	}

	@PutMapping
	public String updateUser() {
		return "UpdateUser was called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "delete User was called";
	}

}
