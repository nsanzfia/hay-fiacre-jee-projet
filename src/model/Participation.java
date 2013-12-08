package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Participation
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="participation")
public class Participation implements Serializable {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)	
	int idParticipation;

	@ManyToOne
	private Client client;
	@ManyToOne
	private Transaction transaction;
	
	public Participation() {
		super();
	}
	
	public Participation(Client client, Transaction trans) {
		this.client = client;
		this.transaction = trans;
	}
	
	public int getIdParticipation() {
		return idParticipation;
	}

	public void setIdParticipation(int idParticipation) {
		this.idParticipation = idParticipation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
   
}
