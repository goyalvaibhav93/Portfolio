package portfolio.managementsystem.ejb;

import java.util.List;

import javax.ejb.Remote;

import portfolio.managementsystem.jpa.Stock;

@Remote
public interface StockBeanRemote {
	public String getName();
	public void init(String name);
	public List<Stock> getAllStocks();
//	public void addToDatabase(Stock content);

}
