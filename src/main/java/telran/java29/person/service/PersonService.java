package telran.java29.person.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import telran.java29.person.dto.PersonDto;
import telran.java29.person.dto.PersonEditDto;
import telran.java29.person.model.Address;
import telran.java29.person.model.Person;

public interface PersonService {
	
	boolean addPerson(PersonDto personDto);
	
	PersonDto findPersonById(int id);

	PersonDto deletePerson(int id);

	

	PersonDto editPerson(PersonEditDto personEditDto, int id);

	PersonDto updateAddress(@PathVariable int id, @RequestBody Address adderess);

	List<PersonDto> findByName(String name);

	List<PersonDto> findByDates(LocalDate from, LocalDate to);

}
