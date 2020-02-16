package com.candresramirez.practicaltest.repository;

import org.springframework.data.repository.CrudRepository;

import com.candresramirez.practicaltest.model.*;

public interface PersonRepository extends CrudRepository<Person,Integer> {

}
