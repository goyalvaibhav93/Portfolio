package portfolio.managementsystem.ejb;

import javax.ejb.Remote;

import portfolio.managementsystem.jpa.Stock;

@Remote
public interface StockBeanRemote {
	public Stock getStockByTicker(String ticker);
}
