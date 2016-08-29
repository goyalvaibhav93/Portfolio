package portfolio.managementsystem.web;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import portfolio.managementsystem.ejb.InvestmentBeanLocal;
import portfolio.managementsystem.ejb.StockBeanLocal;
import portfolio.managementsystem.jpa.Investment;
import portfolio.managementsystem.jpa.Stock;

@Path("/investments/current")
public class InvestmentsREST {
	private InvestmentBeanLocal bean;
	
	public InvestmentsREST() throws NamingException{
		
		try{
			InitialContext context = new InitialContext();
			bean = (InvestmentBeanLocal) context.lookup("java:app/PortfolioManagementSystemEJB/InvestmentBean!portfolio.managementsystem.ejb.InvestmentBeanLocal");
		} catch (NamingException ex){
			ex.printStackTrace();
		}
	}
	
	@GET
	@Produces("application/json")
	public List<Investment> getAllStocks(){
		return bean.getAllInvestments();
	}
	
	
}
