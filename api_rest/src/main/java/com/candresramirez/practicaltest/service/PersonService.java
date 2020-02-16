package com.candresramirez.practicaltest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candresramirez.practicaltest.model.Person;

import com.candresramirez.practicaltest.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<Person>();
        personRepository.findAll().forEach(person -> persons.add(person));
        return persons;
    }
    
    public void save(Person person) {
        personRepository.save(person);
    }
	
    public boolean proccessPerson(Integer[] ids) {
		try {	
			Person p = new Person();
			for(int id : ids) {
				 p = personRepository.findById(id).get();
				 p.setProccess(true);
				 personRepository.save(p);
			}
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}
