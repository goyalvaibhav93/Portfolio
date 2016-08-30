package portfolio.managementsystem.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity implementation class for Entity: Transaction
 *
 */
@Entity
@Table(name="transactions")
public class Transaction implements Serializable {

	   
	private int transactionId;
	private int units;
	private double price;
	private Date transactionDate;
	private int buySell;
	private static final long serialVersionUID = 1L;

	@JsonBackReference
	private Stock stockTransaction;
	
	@JsonBackReference
	private User userTransaction;
	
	public Transaction() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}   
	
	
	@ManyToOne
	@JoinColumn(name="ticker")
	public Stock getStockTransaction() {
		return stockTransaction;
	}

	public void setStockTransaction(Stock stockTransaction) {
		this.stockTransaction = stockTransaction;
	}
	
	
	@ManyToOne
	@JoinColumn(name="username")
	public User getUserTransaction() {
		return userTransaction;
	}

	public void setUserTransaction(User userTransaction) {
		this.userTransaction = userTransaction;
	}

	public int getUnits() {
		return this.units;
	}
	
	public void setUnits(int units) {
		this.units = units;
	}   
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}   
	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

		public int getBuySell() {
		return this.buySell;
	}

	public void setBuySell(int buySell) {
		this.buySell = buySell;
	}
   
}
