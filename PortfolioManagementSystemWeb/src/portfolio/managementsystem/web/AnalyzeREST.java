package portfolio.managementsystem.web;


import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import portfolio.managementsystem.ejb.MarketBeanLocal;
import portfolio.managementsystem.ejb.StockBeanLocal;
import portfolio.managementsystem.jpa.Stock;
import portfolio.managementsystem.response.AnalyzeFinalResponse;
import portfolio.managementsystem.response.CompareResponse;


@Path("/stocks")
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
	@Path("/analyze/{ticker}")
	public AnalyzeFinalResponse getStockAnalysis(@PathParam("ticker")String ticker){
			
		Stock s = beanStock.getStockByTicker(ticker);
		
		AnalyzeFinalResponse obj = new AnalyzeFinalResponse();
		obj.setLiquidity(s.getLiquidity());
		obj.setVolatility(s.getVolatility());
		obj.setAvgChange(s.getAvgChange());
		obj.setMarketList(beanMarket.getStockMarketDetails(ticker));
			
		return obj;
		
	}
	
/*	@GET
	@Produces("application/json")
	@Path("/compare")
	public CompareResponse compare(@QueryParam("ticker1")String ticker1, @QueryParam("ticker2")String ticker2){
		
//		System.out.println(ticker1);
//		System.out.println(ticker2);
//		System.out.println(s1.getTicker()+s1.getLiquidity());
//		System.out.println(s2.getTicker()+s2.getLiquidity());
		Stock s1 = beanStock.getStockByTicker(ticker1);
		Stock s2 = beanStock.getStockByTicker(ticker2);
		
		System.out.println(s1);
		System.out.println(s2);
		
		CompareResponse response = new CompareResponse();
		response.setAvgChange1(s1.getAvgChange());
		response.setAvgChange2(s2.getAvgChange());
		response.setLiquidity1(s1.getLiquidity());
		response.setLiquidity2(s2.getLiquidity());
		response.setVolatility1(s2.getVolatility());
		response.setVolatility2(s2.getVolatility());
		
		return response;
		
	}
*/	

	@GET
	@Produces("application/json")
	@Path("/compare")
	public List<AnalyzeFinalResponse> compare(@QueryParam("ticker1")String ticker1, @QueryParam("ticker2")String ticker2){
		
		Stock s1 = beanStock.getStockByTicker(ticker1);
		Stock s2 = beanStock.getStockByTicker(ticker2);
		
		List<AnalyzeFinalResponse> response = new ArrayList<>(); 
		
		AnalyzeFinalResponse obj1 = new AnalyzeFinalResponse();
		AnalyzeFinalResponse obj2 = new AnalyzeFinalResponse();
		obj1.setAvgChange(s1.getAvgChange());
		obj1.setLiquidity(s1.getLiquidity());
		obj1.setVolatility(s1.getVolatility());
		obj1.setMarketList(beanMarket.getStockMarketDetails(ticker1));
		System.out.println(obj1.getAvgChange()+obj1.getLiquidity()+obj1.getVolatility());
		response.add(obj1);
		
		obj2.setAvgChange(s2.getAvgChange());
		obj2.setLiquidity(s2.getLiquidity());
		obj2.setVolatility(s2.getVolatility());
		System.out.println(obj2.getAvgChange()+obj2.getLiquidity()+obj2.getVolatility());
		obj2.setMarketList(beanMarket.getStockMarketDetails(ticker2));
		response.add(obj2);
		System.out.println(response);
		return response;
		
	}

}
