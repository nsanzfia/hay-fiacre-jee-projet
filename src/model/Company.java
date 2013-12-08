package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Society
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="company")
public class Company implements Serializable {


	@Id
	private String symbol;
	private String name;	
	private float lastSale;	
	private float marketCap;	
	private String ADR_TSO;	
	private String IPOyear;	
	private String sector;
	private String industry;
	private String summaryQuote;

	
	public Company() {
		super();
	}
	
	public Company(String symbol, String name, float lastSale, 
			float marketCap, String ADR_TSO, String IPOyear, 
			String sector, String industry, String summaryQuote) {
		this.symbol = symbol;
		this.ADR_TSO = ADR_TSO;
		this.IPOyear = IPOyear;
		this.name = name;
		this.lastSale = lastSale;
		this.marketCap = marketCap;
		this.sector = sector;
		this.industry = industry;
		this.setSummaryQuote(summaryQuote);
	}

	public float getLastSale() {
		return lastSale;
	}

	public void setLastSale(float lastSale) {
		this.lastSale = lastSale;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(float marketCap) {
		this.marketCap = marketCap;
	}

	public String getADR_TSO() {
		return ADR_TSO;
	}

	public void setADR_TSO(String aDR_TSO) {
		ADR_TSO = aDR_TSO;
	}

	public String getIPOyear() {
		return IPOyear;
	}

	public void setIPOyear(String iPOyear) {
		IPOyear = iPOyear;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getSummaryQuote() {
		return summaryQuote;
	}

	public void setSummaryQuote(String summaryQuote) {
		this.summaryQuote = summaryQuote;
	}
   
}
