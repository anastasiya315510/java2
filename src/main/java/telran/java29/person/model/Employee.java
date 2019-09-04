package telran.java29.person.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String company;
	int salary;
	public Employee(int id, String name, LocalDate birthDate, Address address, String company, int salary) {
		super(id, name, birthDate, address);
		this.company = company;
		this.salary = salary;
	}   
	

}
