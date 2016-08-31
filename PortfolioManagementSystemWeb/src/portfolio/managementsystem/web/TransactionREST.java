package portfolio.managementsystem.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import portfolio.managementsystem.ejb.TransactionBeanLocal;
import portfolio.managementsystem.jpa.Transaction;
import portfolio.managementsystem.response.TransactionResponse;

@Path("/transactions")
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
	@Produces("application/json")
	@Path("/new")
	public String insertTransaction(TransactionResponse t) throws ParseException {
		
		String ticker = t.ticker;
		int units = t.units;
		double price = t.price;
		DateFormat df = new SimpleDateFormat("yyyyy-MM-dd HH:mm:ss");
		Date d = Calendar.getInstance().getTime();
		System.out.println(d.toString());
		String username = "sun32";
		int buySell = t.buySell;
		System.out.println(ticker+ units + "" + price + ""+ buySell);
		
		return bean.insertNewTransaction(buySell, ticker, units, price, df.parse(t.getDateTime()), username);
		
	} 
	
	@GET
	@Produces("application/json")
	@Path("/{ticker}")
	public List<TransactionResponse> getTransactionsByTicker(@PathParam("ticker") String ticker){
		List<TransactionResponse> response = new ArrayList<>();
		System.out.println(bean.getTransactionsByTicker(ticker));
		for(Transaction t : bean.getTransactionsByTicker(ticker)){
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
	
	@GET
	@Produces("application/json")
	@Path("/dates")
	public List<TransactionResponse> getTransactionsByDate(@QueryParam("start")long start, @QueryParam("end")long end) throws ParseException{
		
		Date d1 = new java.sql.Date((long)start);
		Date d2 = new java.sql.Date((long)end);
		List<TransactionResponse> response = new ArrayList<>();
		for(Transaction t : bean.getTransactionsByDates(d1, d2)){
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

}