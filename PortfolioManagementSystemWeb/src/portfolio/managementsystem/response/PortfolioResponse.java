package portfolio.managementsystem.response;

public class PortfolioResponse {

	public int investmentId;
	public int investmentCost;
	public int getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}
	public int getInvestmentCost() {
		return investmentCost;
	}
	public void setInvestmentCost(int investmentCost) {
		this.investmentCost = investmentCost;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public int units;
	public String ticker;
}
