package portfolio.managementsystem.response;

import java.util.List;

import portfolio.managementsystem.jpa.Market;

public class AnalyzeFinalResponse {

	private double avgChange;
	private String volatility;
	private String liquidity;
	
	private List<Market> marketList;
	
	public List<Market> getMarketList() {
		return marketList;
	}

	public void setMarketList(List<Market> marketList) {
		this.marketList = marketList;
	}

	public double getAvgChange() {
		return avgChange;
	}

	public void setAvgChange(double avgChange) {
		this.avgChange = avgChange;
	}

	public String getVolatility() {
		return volatility;
	}

	public void setVolatility(String volatility) {
		this.volatility = volatility;
	}

	public String getLiquidity() {
		return liquidity;
	}

	public void setLiquidity(String liquidity) {
		this.liquidity = liquidity;
	}


	
}
