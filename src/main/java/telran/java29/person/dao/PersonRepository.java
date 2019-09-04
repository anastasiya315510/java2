package telran.java29.person.dao;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import telran.java29.person.dto.PersonDto;
import telran.java29.person.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	

	List<Person> findByDateCreatedBetween(LocalDate from, LocalDate to);

	List<Person> findByName(String name);



}
