package portfolio.managementsystem.web;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import portfolio.managementsystem.ejb.InvestmentBeanLocal;

//import portfolio.managementsystem.response.JSONParse;

@Path("/posttest")
public class PostTest{

	private InvestmentBeanLocal bean;
	
	public PostTest() throws NamingException {
		// TODO Auto-generated constructor stub
		try{
			InitialContext context = new InitialContext();
			bean = (InvestmentBeanLocal) context.lookup("java:app/PortfolioManagementSystemEJB/InvestmentBean!portfolio.managementsystem.ejb.InvestmentBeanLocal");
		} catch (NamingException ex){
			ex.printStackTrace();
		}
	}
	
	@POST
	@Consumes("application/json")
	public void retrieveInvestment(JSONParse content) {
		
		int id = content.investmentId;
		String ticker = content.ticker;
		long buyDate = content.buyDate;
		int units = content.units;
		double buyPrice = content.buyPrice;
		 
		System.out.println(id + " " + ticker + " " + buyDate + " " + units + " " + buyPrice);
		
		bean.insertNewInvestment(buyPrice, units, "sun32", ticker);
		
	} 
	/*
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public void retrieveInvestment2(String content) { 
	}*/
	
}

class JSONParse {
	public String ticker;
	public int investmentId;
	public long buyDate;
	public int units;
	public double buyPrice;
	public long getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(long buyDate) {
		this.buyDate = buyDate;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public int getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}
}
