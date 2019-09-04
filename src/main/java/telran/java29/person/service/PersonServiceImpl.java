package telran.java29.person.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import telran.java29.person.dao.PersonRepository;
import telran.java29.person.dto.PersonDto;
import telran.java29.person.dto.PersonEditDto;
import telran.java29.person.model.Address;
import telran.java29.person.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;
	
	@Override
	@Transactional
	public boolean addPerson(PersonDto personDto) {
		if (personRepository.existsById(personDto.getId())) {
			return false;
		}
		Person person = convertToPerson(personDto);
		personRepository.save(person);
		return true;
	}

	@Override
	public PersonDto findPersonById(int id) {
		Person person =  personRepository.findById(id).orElse(null);
		return person == null ? null : convertToPersonDto(person);
	}
	
	private PersonDto convertToPersonDto(Person person) {
		return PersonDto.builder()
				.id(person.getId())
				.name(person.getName())
				.address(person.getAddress())
				.birthDate(person.getBirthDate().toString())
				.build();
		
	}

	private Person convertToPerson(PersonDto personDto) {
		return Person.builder()
				.id(personDto.getId())
				.name(personDto.getName())
				.address(personDto.getAddress())
				.birthDate(LocalDate.parse(personDto.getBirthDate()))
				.build();
	}

	@Override
	@Transactional
	public PersonDto deletePerson(int id) {
		Person person = personRepository.findById(id).get();
		
	 personRepository.delete(person);
	 return convertToPersonDto(person);
	 
		
	}

	@Override
	public PersonDto editPerson(PersonEditDto personEditDto, int id) {
	Person person = personRepository.findById(id).get();
	if(personEditDto.getName() != null) {
		person.setName(personEditDto.getName());
	}
	personRepository.save(person);
	
		return convertToPersonDto(person);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PersonDto> findByName(String name) {
		return personRepository.findByName(name).stream()
				.map(this::convertToPersonDto)
				.collect(Collectors.toList());
		
	}



	@Override
	public List<PersonDto> findByDates(LocalDate from, LocalDate to) {
		return personRepository.findByDateCreatedBetween(from, to).stream()
				.map(this::convertToPersonDto)
				.collect(Collectors.toList());
		
	}

	@Override
	@Transactional
	public PersonDto updateAddress(int id, Address adderess) {
		Person person = personRepository.findById(id).orElse(null);
		if(person== null) return null;  
		person.setAddress(adderess);
		personRepository.save(person);
		
		return convertToPersonDto(person);
	}



}
