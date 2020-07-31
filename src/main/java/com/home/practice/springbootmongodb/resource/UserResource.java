package com.home.practice.springbootmongodb.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.practice.springbootmongodb.document.User;
import com.home.practice.springbootmongodb.repositories.UserRepository;

@RestController
@RequestMapping("/rest/users")
public class UserResource {

	private UserRepository repository;

	public UserResource() {
	}

	@Autowired
	public UserResource(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping("/user")
	public List<User> getAll() {
		return repository.findAll();
	}

	@PostMapping("/user")
	public User add(@RequestBody User user) {
		return repository.save(user);
	}

	@PutMapping("/user/{id}")
	public User update(@RequestBody User user, @PathVariable String id) {
		System.out.println(repository.findById(id.trim()));
		return repository.findById(id.trim()).map(userNew -> {
			userNew.setName(user.getName());
			userNew.setTeamName(user.getTeamName());
			return repository.save(userNew);
		}).orElseGet(() -> {
			user.setId(id);
			return repository.save(user);
		});
	}

	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable String id) {
		repository.deleteById(id);
	}

	@GetMapping("/test")
	public String getName() {
		return "Rest is Working";
	}
}
