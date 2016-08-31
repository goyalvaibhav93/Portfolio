package portfolio.managementsystem.web;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import portfolio.managementsystem.ejb.AnalyzeBeanLocal;
import portfolio.managementsystem.jpa.Investment;
import portfolio.managementsystem.jpa.Transaction;
import portfolio.managementsystem.response.InvestmentResponse;
import portfolio.managementsystem.response.AnalyzeResponse;


@Path("stocks/analyze")
public class AnalyzeREST {
	
	private AnalyzeBeanLocal bean;
	
	public AnalyzeREST() throws NamingException {

		try {
			InitialContext context = new InitialContext();
			bean = (AnalyzeBeanLocal) context.lookup(
					"java:app/PortfolioManagementSystemEJB/AnalyzeBean!portfolio.managementsystem.ejb.AnalyzeBeanLocal");
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
	}
	
	@GET
	@Produces("application/json")
	@Path("/{ticker}")
	public AnalyzeResponse sendTickerResponse(@PathParam("ticker")String ticker){
		 AnalyzeResponse response = new AnalyzeResponse();
		   Transaction transaction = bean.getTransactionByTicker(ticker);
			//InvestmentResponse response = new InvestmentResponse();
			response.setTransactionId(transaction.getTransactionId());
			response.setTicker(ticker);
			//response.setTransactionDate(transaction.getDate());
			response.setTransactionPrice(transaction.getPrice());
			response.setUnits(transaction.getUnits());
			return response;
	}
	



}
