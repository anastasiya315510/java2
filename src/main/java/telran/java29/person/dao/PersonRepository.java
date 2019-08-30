package telran.java29.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.java29.person.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
