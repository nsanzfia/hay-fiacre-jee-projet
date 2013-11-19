package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@Table(name="client")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String firsName;

	private String name;

	//bi-directional many-to-one association to Account
    @ManyToOne
	@JoinColumn(name="idAccount")
	private Account account;

    public Client() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirsName() {
		return this.firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}