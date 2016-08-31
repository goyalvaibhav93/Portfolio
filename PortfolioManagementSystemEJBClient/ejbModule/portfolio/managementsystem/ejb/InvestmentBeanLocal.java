package portfolio.managementsystem.ejb;

import java.util.List;


import javax.ejb.Local;

import portfolio.managementsystem.jpa.Investment;

@Local
public interface InvestmentBeanLocal {

	public List<Investment> getAllInvestments();
	public void insertNewInvestment(double buyPrice, int units, String username, String ticker);
	public List<Investment> getInvestmentsByPortfolio(String portfolioName);
	public double getProfit(String ticker);
	
}
