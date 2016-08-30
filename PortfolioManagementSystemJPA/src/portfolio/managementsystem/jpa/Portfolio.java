package portfolio.managementsystem.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: Portfolio
 *
 */
@Entity
@Table(name="portfolio")
public class Portfolio implements Serializable {

	   
	private int portfolioId;
	private String portfolioName;
	private static final long serialVersionUID = 1L;

	@JsonManagedReference
	private List<Stock> stocks = new ArrayList<>();
	
	public Portfolio() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPortfolioId() {
		return this.portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}   
	
	
	@OneToMany(mappedBy="portfolio")
	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public String getPortfolioName() {
		return this.portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
   
}
