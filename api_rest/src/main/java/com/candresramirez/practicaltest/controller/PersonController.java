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

/**
 * Creado por Cesar Ramirez candresramirez  16/03/2020.
 * Clase controlador donde se especifican los endpoint del api rest
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
    PersonService personService;
	
	/**
	 * Este método se encarga mostrar el listado de personas registradas
	 * @author Cesar Ramirez
	 * @param N/A
	 * @return Listado de personas en formato JSON
	*/
	@GetMapping("/persons")
	private List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
	
	/**
	 * Este método se encarga de registrar las personas en base de datos
	 * @author Cesar Ramirez
	 * @param JSON {name,lastname,proccess}
	 * @return ID con que se inserto el registro
	*/
    @PostMapping("/persons")
    private int savePerson(@RequestBody Person person) {
        personService.save(person);
        return person.getId();
    }
    
	/**
	 * Este método se encarga de actualizar el estado de 
	 * las personas en base de datos
	 * @author Cesar Ramirez
	 * @param JSON con ID de los registros
	 * @return true/false
	*/
    @PostMapping("/proccess")
    private boolean proccessPerson(@RequestBody Integer[] ids) {
		return personService.proccessPerson(ids)? true : false;
	}

}
