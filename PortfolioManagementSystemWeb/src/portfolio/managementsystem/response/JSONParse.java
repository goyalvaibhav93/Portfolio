package portfolio.managementsystem.response;

public class JSONParse {

	String ticker;
	int investmentId;
	long buyDate;
	double buyPrice;
	int units;
	
	
	public long getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(long buyDate) {
		this.buyDate = buyDate;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
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
	public int getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}
}
