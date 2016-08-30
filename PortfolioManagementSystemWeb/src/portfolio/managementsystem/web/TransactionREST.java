package portfolio.managementsystem.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import portfolio.managementsystem.ejb.TransactionBeanLocal;
import portfolio.managementsystem.jpa.Transaction;
import portfolio.managementsystem.response.TransactionResponse;

@Path("/sun32/transactions")
public class TransactionREST {
	
private TransactionBeanLocal bean;
	
	public TransactionREST() throws NamingException{
		
		try{
			InitialContext context = new InitialContext();
			bean = (TransactionBeanLocal) context.lookup("java:app/PortfolioManagementSystemEJB/TransactionBean!portfolio.managementsystem.ejb.TransactionBeanLocal");
		} catch (NamingException ex){
			ex.printStackTrace();
		}
	}
	
	@GET
	@Produces("application/json")
	@Path("/all")
	public List<TransactionResponse> getAllTransactions(){
		List<TransactionResponse> response = new ArrayList<>();
		for(Transaction t : bean.getAllTransactions()){
			TransactionResponse r = new TransactionResponse();
			r.setBuySell(t.getBuySell());
			r.setDate(t.getTransactionDate());
			r.setPrice(t.getPrice());
			r.setTicker(t.getStockTransaction().getTicker());
			r.setTransactionId(t.getTransactionId());
			r.setUnits(t.getUnits());
			r.setUsername(t.getUserTransaction().getUsername());
			response.add(r);
		}
		return response;
	}
	
	@POST
	@Consumes("application/json")
	@Path("/new")
	public void insertTransaction(TransactionResponse t) {
		
		String ticker = t.ticker;
		int units = t.units;
		double price = t.price;
		Date d = Calendar.getInstance().getTime();
		String username = "sun32";
		int buySell = t.buySell;
		System.out.println(ticker+ units + "" + price + ""+ buySell);
		
		bean.insertNewTransaction(buySell, ticker, units, price, d, username);
		
	} 
	
}