package net.stakater.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.stakater.springboot.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/name")
public class NameController {

	@Autowired
	private Environment env;

	@CrossOrigin(origins = {"http://localhost:3000"})
	@GetMapping
	public String getEnvVariable() {
		if (null == env.getProperty("NAME") || "".equals(env.getProperty("NAME")))
			throw new ResourceNotFoundException("No value found for environment variable NAME");
		else
			return "Hello " + env.getProperty("NAME");

	}

}
