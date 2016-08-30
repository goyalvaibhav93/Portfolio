package portfolio.managementsystem.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="investments")
public class Investment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int investmentId;
	private Date buyDate;
	private double buyPrice;
	private int units;
	
	@JsonBackReference
	private Stock stock;
	
	@JsonBackReference
	private User user;
	
	private String ticker;
	private String username;
	
	public Investment(){
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}
	
	@ManyToOne
	@JoinColumn(name="ticker")
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	@ManyToOne
	@JoinColumn(name="users_username")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
	
}
