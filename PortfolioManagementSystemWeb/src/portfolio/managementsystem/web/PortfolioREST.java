package portfolio.managementsystem.web;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import portfolio.managementsystem.ejb.InvestmentBeanLocal;
import portfolio.managementsystem.jpa.Investment;
import portfolio.managementsystem.response.InvestmentResponse;

@Path("/portfolios")
public class PortfolioREST {
	
private InvestmentBeanLocal bean;
	
	public PortfolioREST() throws NamingException{
		
		try{
			InitialContext context = new InitialContext();
			bean = (InvestmentBeanLocal) context.lookup("java:app/PortfolioManagementSystemEJB/InvestmentBean!portfolio.managementsystem.ejb.InvestmentBeanLocal");
		} catch (NamingException ex){
			ex.printStackTrace();
		}
	}
	
	@GET
	@Produces("application/json")
	@Path("/compare")
	public double[] getAllInvestmentsByPortfolio() {
		List<InvestmentResponse> response = new ArrayList<>();
		String[] portfolios = new String[3];
		portfolios[0]="Finance";
		portfolios[1]="Automobiles";
		portfolios[2]="Information Technology";
		double[] profits = new double[6];
		int x=0;
		for(int cnt=0;cnt<3;cnt++){
			for (Investment i : bean.getInvestmentsByPortfolio(portfolios[cnt])) {
	
				InvestmentResponse obj = new InvestmentResponse();
	
				obj.setInvestmentId(i.getInvestmentId());
				obj.setTicker(i.getStock().getTicker());
				obj.setInvestmentCost(i.getinvestmentCost());
				obj.setUnits(i.getUnits());
				obj.setUsername(i.getUser().getUsername());
				obj.setPortfolio(i.getStock().getPortfolio().getPortfolioName());
				double price = bean.getProfit(obj.getTicker());
				double profit = price*(double)obj.getUnits() - obj.getInvestmentCost();
				profits[x] += profit;
				profits[x+1] += profit/obj.getInvestmentCost();
				obj.setProfit(profit);
				response.add(obj);
			}
			x+=2;
		}
		return profits;
		
		
		
	}	

}
