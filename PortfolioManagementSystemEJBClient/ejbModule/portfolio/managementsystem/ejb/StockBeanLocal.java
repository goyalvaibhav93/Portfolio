package portfolio.managementsystem.ejb;

import javax.ejb.Local;

import portfolio.managementsystem.jpa.Stock;

@Local
public interface StockBeanLocal {
	public Stock getStockByTicker(String ticker);
}
