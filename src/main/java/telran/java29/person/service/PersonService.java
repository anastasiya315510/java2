package telran.java29.person.service;

import telran.java29.person.dto.PersonDto;
import telran.java29.person.dto.PersonEditDto;

public interface PersonService {
	
	boolean addPerson(PersonDto personDto);
	
	PersonDto findPersonById(int id);

	PersonDto deletePerson(int id);

	

	PersonDto editPerson(PersonEditDto personEditDto, int id);

}
