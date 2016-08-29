package portfolio.managementsystem.ejb;

import java.util.List;


import javax.ejb.Remote;

import portfolio.managementsystem.jpa.Investment;

@Remote
public interface InvestmentBeanRemote {
	
	public List<Object> getAllInvestments();
	public List<Investment> getAllInvestmentsTest();
	public void insertNewInvestment(double buyPrice, int units, String username, String ticker);
	
}