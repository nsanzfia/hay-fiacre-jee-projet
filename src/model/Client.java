package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import model.Participation;


/**
 * The persistent class for the client database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="client")
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String firstName;
	private String lastName;

	//directional one-to-one association to Account
    @OneToOne
	@JoinColumn(name="idAccount")
	private Account account;

	
    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="client")
    private List<Participation> participations = new ArrayList<Participation>();
    
    public Client() {
    }
    
    public Client(String firstName, String lastName, Account account) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.account = account;
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}
	
}