package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bourse
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="bourse")
public class Bourse implements Serializable {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	private String name;

	public Bourse() {
		super();
	}
	
	public Bourse(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
