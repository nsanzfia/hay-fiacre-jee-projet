package model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;


/**
 * The persistent class for the action database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="action")
public class Action implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAction;
	
	private Date date;
	private float open;
	private float high;
	private float low;
	private float close;
	private float volume;
	private float adj;

	//bi-directional many-to-one association to Wallet
    @ManyToOne
	@JoinColumn(name="idWallet")
	private Wallet wallet;

    public Action() {
    }

    public Action(Date date, float open, float high, float low, 
    		float close, float volume, float adj, Wallet wallet) {
    	this.date = date;
    	this.open = open;
    	this.high = high;
    	this.low = low;
    	this.close = close;
    	this.volume = volume;
    	this.adj = adj;
    	this.wallet = wallet;
    	
    }
	public int getId() {
		return this.idAction;
	}

	public void setId(int id) {
		this.idAction = id;
	}

	public Wallet getWallet() {
		return this.wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public float getOpen() {
		return open;
	}

	public void setOpen(float open) {
		this.open = open;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getHigh() {
		return high;
	}

	public void setHigh(float high) {
		this.high = high;
	}

	public float getClose() {
		return close;
	}

	public void setClose(float close) {
		this.close = close;
	}

	public float getLow() {
		return low;
	}

	public void setLow(float low) {
		this.low = low;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getAdj() {
		return adj;
	}

	public void setAdj(float adj) {
		this.adj = adj;
	}
	
}