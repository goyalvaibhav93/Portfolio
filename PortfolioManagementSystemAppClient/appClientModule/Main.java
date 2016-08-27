import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import portfolio.managementsystem.ejb.StockBeanRemote;
import portfolio.managementsystem.jpa.Stock;

public class Main {
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		
		// Create Properties for JNDI InitialContext.
		Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName()); 
		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		prop.put("jboss.naming.client.ejb.context", true);

		// Create the JNDI InitialContext.
		Context context = new InitialContext(prop);
		
		StockBeanRemote bean = (StockBeanRemote) context.lookup("PortfolioManagementSystem/PortfolioManagementSystemEJB/StockBean!portfolio.managementsystem.ejb.StockBeanRemote");
		
		bean.init("Vaibhav");
		for (Stock s : bean.getAllStocks()){
			System.out.println(s.getTicker());
		}
		
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}