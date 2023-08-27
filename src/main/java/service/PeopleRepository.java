package service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.PeopleEntity;

@Repository
public interface PeopleRepository extends JpaRepository<PeopleEntity, Long>{

	List<PeopleEntity> findAll();

	PeopleEntity findPeopleById(Long id);
	
	PeopleEntity createPeople(PeopleEntity people);
	
}
