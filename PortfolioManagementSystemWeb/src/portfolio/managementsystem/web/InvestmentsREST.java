package portfolio.managementsystem.web;

import java.util.ArrayList;

import java.util.List;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


//import org.json.JSONObject;

import portfolio.managementsystem.ejb.InvestmentBeanLocal;
import portfolio.managementsystem.jpa.Investment;
import portfolio.managementsystem.response.InvestmentResponse;

@Path("/investments")
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
	@Path("/current")
	public List<InvestmentResponse> getAllInvestments(){
		List<InvestmentResponse> response = new ArrayList<>();
		for(Investment i : bean.getAllInvestments()){
			
			InvestmentResponse obj = new InvestmentResponse();
			
			obj.setInvestmentId(i.getInvestmentId());
			obj.setTicker(i.getStock().getTicker());
			obj.setInvestmentCost(i.getinvestmentCost());
			obj.setUnits(i.getUnits());
			obj.setUsername(i.getUser().getUsername());
			obj.setPortfolio(i.getStock().getPortfolio().getPortfolioName());
			response.add(obj);
		}	
		return response;
	}
	/*
	@GET
	@Produces("application/json")
	@Path("/{portfolioName}")
	public List<InvestmentResponse> getAllInvestmentsByPortfolio(@PathParam("portfolioName")String portfolioName){
		List<InvestmentResponse> response = new ArrayList<>();
		for(Investment i : bean.getInvestmentsByPortfolio(portfolioName)){
			
			InvestmentResponse obj = new InvestmentResponse();
			
			obj.setInvestmentId(i.getInvestmentId());
			obj.setTicker(i.getStock().getTicker());
			obj.setInvestmentCost(i.getinvestmentCost());
			obj.setUnits(i.getUnits());
			obj.setUsername(i.getUser().getUsername());
			obj.setPortfolio(i.getStock().getPortfolio().getPortfolioName());
			response.add(obj);
		}	
		return response;
	}*/	
	
	@GET
	@Produces("application/json")
	@Path("/{portfolioName}")
	public List<InvestmentResponse> getAllInvestmentsByPortfolio(@PathParam("portfolioName") String portfolioName) {
		List<InvestmentResponse> response = new ArrayList<>();
		for (Investment i : bean.getInvestmentsByPortfolio(portfolioName)) {

			InvestmentResponse obj = new InvestmentResponse();

			obj.setInvestmentId(i.getInvestmentId());
			obj.setTicker(i.getStock().getTicker());
			obj.setInvestmentCost(i.getinvestmentCost());
			obj.setUnits(i.getUnits());
			obj.setUsername(i.getUser().getUsername());
			obj.setPortfolio(i.getStock().getPortfolio().getPortfolioName());
			response.add(obj);
		}
		return response;
	}	
}
