package portfolio.managementsystem.ejb;

import java.util.List;

import javax.ejb.Local;

import portfolio.managementsystem.jpa.Stock;

@Local
public interface StockBeanLocal {
	public String getName();
	public void init(String name);
	public List<Stock> getAllStocks();
//	public void addToDatabase(Object content);
//	public void addToDatabase(Stock content);
}
