package service;

import java.util.List;

import entity.PeopleEntity;
import jakarta.validation.Valid;

public interface PeopleInterface {

	List<PeopleEntity> findAllPeople();

	PeopleEntity findPeopleById(String id);
	
	PeopleEntity createPeople(@Valid PeopleEntity people);
	
}
