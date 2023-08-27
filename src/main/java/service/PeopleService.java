package service;

import java.util.List;

import entity.PeopleEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
@Transactional
public class PeopleService implements PeopleInterface {

	@Override
	public List<PeopleEntity> findAllPeople() {
		return PeopleEntity.listAll();
	}

	@Override
	public PeopleEntity findPeopleById(String id) {
		return PeopleEntity.findById(id);
	}

	@Override
	public PeopleEntity createPeople(@Valid PeopleEntity people) {
		PeopleEntity.persist(people);
		return people;
	}

}
