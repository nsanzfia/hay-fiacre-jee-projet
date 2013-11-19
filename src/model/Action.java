package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the action database table.
 * 
 */
@Entity
@Table(name="action")
public class Action implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Wallet
    @ManyToOne
	@JoinColumn(name="idWallet")
	private Wallet wallet;

    public Action() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Wallet getWallet() {
		return this.wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
}