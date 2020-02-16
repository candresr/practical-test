package com.candresramirez.practicaltest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candresramirez.practicaltest.service.PersonService;
import com.candresramirez.practicaltest.model.Person;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
    PersonService personService;
	
	@GetMapping("/persons")
	private List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
	
    @PostMapping("/persons")
    private int savePerson(@RequestBody Person person) {
        personService.save(person);
        return person.getId();
    }
    
    @PostMapping("/proccess")
    private boolean proccessPerson(@RequestBody Integer[] ids) {
		return personService.proccessPerson(ids)? true : false;
	}

}
