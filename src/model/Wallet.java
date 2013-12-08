package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the wallet database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="wallet")
public class Wallet implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Action
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="wallet")
	private Set<Action> actions;

    public Wallet() {
    }
    
    public Wallet(Set<Action> actions) {
    	this.actions = actions;
    }
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Set<Action> getActions() {
		return this.actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}
	
}