package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.PeopleEntity;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PeopleService  {

	@Autowired
	private PeopleRepository peopleRepository;
	
	public List<PeopleEntity> findAllPeople() {
		return peopleRepository.findAll();
	}

	public PeopleEntity findPeopleById(Long id) {
		return peopleRepository.findPeopleById(id);
	}

	public PeopleEntity createPeople(PeopleEntity people) {
		peopleRepository.save(people);
		return people;
	}

}
