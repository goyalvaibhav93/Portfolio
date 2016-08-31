package portfolio.managementsystem.web;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import portfolio.managementsystem.ejb.MarketBeanLocal;
import portfolio.managementsystem.ejb.StockBeanLocal;
import portfolio.managementsystem.jpa.Stock;
import portfolio.managementsystem.response.AnalyzeFinalResponse;


@Path("stocks/analyze")
public class AnalyzeREST {
	
	private MarketBeanLocal beanMarket;
	private StockBeanLocal beanStock;
	
	public AnalyzeREST() throws NamingException {

		try {
			InitialContext contextTransaction = new InitialContext();
			beanMarket = (MarketBeanLocal) contextTransaction.lookup(
					"java:app/PortfolioManagementSystemEJB/MarketBean!portfolio.managementsystem.ejb.MarketBeanLocal");
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
		
		try {
			InitialContext contextStock = new InitialContext();
			beanStock = (StockBeanLocal) contextStock.lookup(
					"java:app/PortfolioManagementSystemEJB/StockBean!portfolio.managementsystem.ejb.StockBeanLocal");
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
		
	}
	
	@GET
	@Produces("application/json")
	@Path("/{ticker}")
	public AnalyzeFinalResponse getStockAnalysis(@PathParam("ticker")String ticker){
			
		Stock s = beanStock.getStockByTicker(ticker);
		
		AnalyzeFinalResponse obj = new AnalyzeFinalResponse();
		obj.setLiquidity(s.getLiquidity());
		obj.setVolatility(s.getVolatility());
		obj.setAvgChange(s.getAvgChange());
		obj.setMarketList(beanMarket.getStockMarketDetails(ticker));
			
		return obj;
		
	}
	



}
