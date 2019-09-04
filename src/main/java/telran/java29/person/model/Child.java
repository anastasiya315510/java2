package telran.java29.person.model;

import java.time.LocalDate;

import org.hibernate.annotations.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@javax.persistence.Entity
public class Child extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	String kindergadenString;


	public Child(int id, String name, LocalDate birthDate, Address address, String kindergadenString) {
		super(id, name, birthDate, address);
		this.kindergadenString = kindergadenString;
	}

}
