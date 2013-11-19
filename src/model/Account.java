package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table(name="account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private float amount;

	//bi-directional many-to-one association to Wallet
    @ManyToOne
	@JoinColumn(name="idWallet")
	private Wallet wallet;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="account")
	private Set<Client> clients;

    public Account() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Wallet getWallet() {
		return this.wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
}