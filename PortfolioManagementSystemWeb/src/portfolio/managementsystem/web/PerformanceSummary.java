package portfolio.managementsystem.web;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import portfolio.managementsystem.ejb.StockBeanLocal;
import portfolio.managementsystem.jpa.Stock;

@Path("/")
public class PerformanceSummary {
	private StockBeanLocal bean;
	
	public PerformanceSummary() throws NamingException{
		try{
			InitialContext context = new InitialContext();
			bean = (StockBeanLocal) context.lookup("java:app/PortfolioManagementSystemEJB/StockBean!portfolio.managementsystem.ejb.StockBeanLocal");
		} catch (NamingException ex){
			ex.printStackTrace();
		}
	}
	
	@GET
	@Path("/performanceSummary")
	@Produces("application/json")
	public List<Stock> getAllStocks(){
		return bean.getAllStocks();
	}
	
	@POST
	@Path("/performance")
	@Consumes("application/json")
	@Produces("application/json")
	public void putAllStocks(Object content){
		System.out.println( content.toString());
		//bean.addToDatabase(content);
	}
	
	
	
}


	
	
	/*@GET
	@Produces("application/json")
	public List<Product> getProductsByName(@QueryParam("filter") @DefaultValue("") String filter){
		if(filter==null)
			return bean.getAllProducts();
		else
			return bean.getProductsByName(filter);
	}
	
	@GET
	@Produces("application/json")
	@Path("/{categoryName}")
	public List<Product> getProductsInCategory(@PathParam("categoryName") String cat){
		return bean.getProductsInCategory(cat);
	}*/
	
	/*@GET
	@Produces("text/plain")
	public String getText(){
		return "Hello World";
	}*/