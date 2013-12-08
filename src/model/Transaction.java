package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import model.Participation;


/**
 * The persistent class for the transaction database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="transaction")
public class Transaction implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	/**
	 * Transaction amount: can be negative
	 */
	private float amount;
	
	/**
	 * Comment about transaction: buying or selling 
	 */
	private String comment;
	
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="transaction")
	private List<Participation> participations = new ArrayList<Participation>();
	  
    public Transaction() {
    }

    public Transaction(float amount, String comment) {
    	this.amount = amount;
    	this.comment = comment;
    }
    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}