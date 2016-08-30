package portfolio.managementsystem.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


//import org.json.JSONObject;

import portfolio.managementsystem.ejb.InvestmentBeanLocal;
import portfolio.managementsystem.jpa.Investment;
import portfolio.managementsystem.response.InvestmentResponse;

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
	public List<InvestmentResponse> getAllInvestments2(){
		List<InvestmentResponse> response = new ArrayList<>();
		for(Investment i : bean.getAllInvestments()){
			
			InvestmentResponse obj = new InvestmentResponse();
			
			obj.setInvestmentId(i.getInvestmentId());
			obj.setTicker(i.getInstrument().getTicker());
			obj.setBuyDate(i.getBuyDate());
			obj.setBuyPrice(i.getBuyPrice());
			obj.setUnits(i.getUnits());
			obj.setUsername(i.getUser().getUsername());
			response.add(obj);
		}	
		return response;
	}
	
	
	
	
	
}
