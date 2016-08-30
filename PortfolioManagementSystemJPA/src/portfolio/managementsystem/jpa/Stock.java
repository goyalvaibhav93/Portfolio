package portfolio.managementsystem.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: Stock
 *
 */
@Entity
@Table(name="stocks")

public class Stock implements Serializable {

	
	   
	private String ticker;
	private static final long serialVersionUID = 1L;
	
	@JsonManagedReference
	private List<Investment> investments = new ArrayList<>();
	
	@JsonManagedReference
	private List<Market> stocksMarket = new ArrayList<>();
	
	@JsonManagedReference
	private List<Transaction> transactions = new ArrayList<>();
	
	@JsonBackReference
	private Portfolio portfolio;
	
	public Stock() {
		super();
	}  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}   
	
	
	@OneToMany(mappedBy="stock")
	public List<Investment> getInvestments() {
		return investments;
	}

	public void setInvestments(List<Investment> investments) {
		this.investments = investments;
	}
	
	
	@OneToMany(mappedBy="stockMarket")
	public List<Market> getInstrumentsMarket() {
		return stocksMarket;
	}

	public void setInstrumentsMarket(List<Market> stocksMarket) {
	}
	
	
	@OneToMany(mappedBy="stockTransaction")
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@ManyToOne
	@JoinColumn(name="portfolioId")
	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	
	
	
}
