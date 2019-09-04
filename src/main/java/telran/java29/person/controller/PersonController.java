package telran.java29.person.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.java29.person.dto.PersonDto;
import telran.java29.person.dto.PersonEditDto;
import telran.java29.person.model.Address;
import telran.java29.person.model.Person;
import telran.java29.person.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@PostMapping
	public boolean addPerson(@RequestBody PersonDto personDto) {
		return personService.addPerson(personDto);
	}
	
	@GetMapping("/name/{name}")
	public List<PersonDto> findByName(@PathVariable String name) {
	return personService.findByName(name);	
	}
	
	@GetMapping("ages/{from}/{to}")
	public List<PersonDto> findByDates(@PathVariable LocalDate from, @PathVariable LocalDate to ) {
		return personService.findByDates(from, to);	
		}
	@GetMapping("/{id}")
	public PersonDto findPerson(@PathVariable int id) {
		return personService.findPersonById(id);
	}

	@DeleteMapping("/{id}")
	public PersonDto deletePerson(@PathVariable int id) {
		return personService.deletePerson(id);
	}
	
	@PutMapping("{/addres/{id}")
		public PersonDto updateAddress(@PathVariable int id, @RequestBody Address adderess) {
			return  personService.updateAddress(id, adderess);
		}
	
	
	
	@PutMapping("/{id}")
	public PersonDto edit(@RequestBody PersonEditDto personEditDto , @PathVariable int id) {
	  return personService.editPerson(personEditDto, id);
	}
}
