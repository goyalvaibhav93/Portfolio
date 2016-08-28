package portfolio.managementsystem.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity implementation class for Entity: Market
 *
 */
@Entity
@Table(name="instrument_market_details")
public class Market implements Serializable {

	   
	private int id;
	private Date date;
	private double open;
	private double high;
	private double low;
	private double close;
	private int volumeTraded;
	private static final long serialVersionUID = 1L;
	
	@JsonBackReference
	private Instrument instrumentMarket;
	
	public Market() {
		super();
	}  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	
	@ManyToOne
	@JoinColumn(name="financial_instruments_ticker")
	public Instrument getInstrumentMarket() {
		return instrumentMarket;
	}

	public void setInstrumentMarket(Instrument instrumentMarket) {
		this.instrumentMarket = instrumentMarket;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public double getOpen() {
		return this.open;
	}

	public void setOpen(double open) {
		this.open = open;
	}   
	public double getHigh() {
		return this.high;
	}

	public void setHigh(double high) {
		this.high = high;
	}   
	public double getLow() {
		return this.low;
	}

	public void setLow(double low) {
		this.low = low;
	}   
	public double getClose() {
		return this.close;
	}

	public void setClose(double close) {
		this.close = close;
	}   
	public int getVolumeTraded() {
		return this.volumeTraded;
	}

	public void setVolumeTraded(int volumeTraded) {
		this.volumeTraded = volumeTraded;
	}
   
}
