package portfolio.managementsystem.ejb;

import java.util.List;

import javax.ejb.Local;

import portfolio.managementsystem.jpa.Investment;

@Local
public interface InvestmentBeanLocal {

	public List<Investment> getAllInvestments();
	
}
