package portfolio.managementsystem.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: Instrument
 *
 */
@Entity
@Table(name="financial_instruments")

public class Instrument implements Serializable {

	
	   
	private String ticker;
	private String category;
	private static final long serialVersionUID = 1L;
	
	@JsonManagedReference
	private List<Investment> investments = new ArrayList<>();
	
	@JsonManagedReference
	private List<Market> instrumentsMarket = new ArrayList<>();
	
	public Instrument() {
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
	
	
	@OneToMany(mappedBy="instrument")
	public List<Investment> getInvestments() {
		return investments;
	}

	public void setInvestments(List<Investment> investments) {
		this.investments = investments;
	}
	
	
	@OneToMany(mappedBy="instrumentMarket")
	public List<Market> getInstrumentsMarket() {
		return instrumentsMarket;
	}

	public void setInstrumentsMarket(List<Market> instrumentsMarket) {
		this.instrumentsMarket = instrumentsMarket;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
   
}
