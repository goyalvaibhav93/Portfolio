package portfolio.managementsystem.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import portfolio.managementsystem.jpa.Transaction;

@Local
public interface TransactionBeanLocal {
	public List<Transaction> getAllTransactions();
	public void insertNewTransaction(int type, String ticker, int units, double price, Date d, String username);
}