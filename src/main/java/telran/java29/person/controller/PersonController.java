package telran.java29.person.controller;

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
	
	@GetMapping("/{id}")
	public PersonDto findPerson(@PathVariable int id) {
		return personService.findPersonById(id);
	}

	@DeleteMapping("/{id}")
	public PersonDto deletePerson(@PathVariable int id) {
		return personService.deletePerson(id);
	}
	
	@PutMapping("/{id}")
	public PersonDto edit(@RequestBody PersonEditDto personEditDto , @PathVariable int id) {
	  return personService.editPerson(personEditDto, id);
	}
}
