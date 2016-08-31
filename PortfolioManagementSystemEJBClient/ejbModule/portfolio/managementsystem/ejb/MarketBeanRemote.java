package portfolio.managementsystem.ejb;

import java.util.List;

import javax.ejb.Remote;

import portfolio.managementsystem.jpa.Market;

@Remote
public interface MarketBeanRemote {
	public List<Market> getStockMarketDetails(String ticker);
}
