package telran.java29.person.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//@Embeddable
@AllArgsConstructor@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String city;   
	String street;  
	int house;

}
