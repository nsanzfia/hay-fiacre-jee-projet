package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the wallet database table.
 * 
 */
@Entity
@Table(name="wallet")
public class Wallet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="wallet")
	private Set<Account> accounts;

	//bi-directional many-to-one association to Action
	@OneToMany(mappedBy="wallet")
	private Set<Action> actions;

    public Wallet() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	public Set<Action> getActions() {
		return this.actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}
	
}