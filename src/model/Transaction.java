package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@Table(name="transaction")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

    public Transaction() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}