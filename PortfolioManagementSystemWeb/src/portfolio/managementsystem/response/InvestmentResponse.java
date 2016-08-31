package portfolio.managementsystem.response;

public class InvestmentResponse{
	
	private int investmentId;
	private String ticker;
	private double investmentCost;
	private int units;
	private String username;
	private String portfolio;
	private double profit;
	
	public InvestmentResponse(){
		super();
	}

	public int getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public double getInvestmentCost() {
		return investmentCost;
	}

	public void setInvestmentCost(double investmentCost) {
		this.investmentCost = investmentCost;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	
}
