package portfolio.managementsystem.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import portfolio.managementsystem.jpa.Transaction;

@Remote
public interface TransactionBeanRemote {
	public List<Transaction> getAllTransactions();
	public String insertNewTransaction(int type, String ticker, int units, double price, Date d, String username);
	public List<Transaction> getTransactionsByTicker(String ticker);
	public List<Transaction> getTransactionsByDates(Date d1, Date d2);
}
