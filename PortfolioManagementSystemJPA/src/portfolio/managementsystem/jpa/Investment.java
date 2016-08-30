package portfolio.managementsystem.jpa;

import java.io.Serializable;

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
	private double investmentCost;
	private int units;
	
	@JsonBackReference
	private Stock stock;
	
	@JsonBackReference
	private User user;
	
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

		@ManyToOne
	@JoinColumn(name="users_username")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public double getinvestmentCost() {
		return investmentCost;
	}

	public void setinvestmentCost(double investmentCost) {
		this.investmentCost = investmentCost;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
	
}
