package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the account database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="account")
public class Account implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAccount;
	
	private float amount;

	//directional one-to-one association to Wallet
    @OneToOne
	@JoinColumn(name="idWallet")
	private Wallet wallet;

    public Account() {
    }

    public Account(float amount, Wallet wallet) {
    	this.amount = amount;
    	this.wallet = wallet;
    }
    
	public int getId() {
		return this.idAccount;
	}

	public void setId(int id) {
		this.idAccount = id;
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
	
}