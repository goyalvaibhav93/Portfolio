package portfolio.managementsystem.ejb;

import java.util.List;

import javax.ejb.Local;

import portfolio.managementsystem.jpa.Market;

@Local
public interface MarketBeanLocal {
	public List<Market> getStockMarketDetails(String ticker);
}
