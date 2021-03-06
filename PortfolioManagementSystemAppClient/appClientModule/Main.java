import java.util.Properties;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import portfolio.managementsystem.ejb.AnalyzeBeanRemote;
import portfolio.managementsystem.ejb.InvestmentBeanRemote;
import portfolio.managementsystem.ejb.MarketBeanRemote;
import portfolio.managementsystem.ejb.TransactionBeanLocal;
import portfolio.managementsystem.ejb.TransactionBeanRemote;
import portfolio.managementsystem.jpa.Investment;

public class Main {
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		
		/*TestPortfolioMS test =  new TestPortfolioMS();
		
		// Create Properties for JNDI InitialContext.
		Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName()); 
		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		prop.put("jboss.naming.client.ejb.context", true);
		
		// Create the JNDI InitialContext.
		Context context = new InitialContext(prop); 
		
		
		//EJBs
		MarketBeanRemote MarketBean = (MarketBeanRemote) context.lookup("PortfolioManagementSystem/PortfolioManagementSystemEJB/MarketBean!portfolio.managementsystem.ejb.MarketBeanRemote");
		InvestmentBeanRemote investmentBean = (InvestmentBeanRemote) context.lookup("PortfolioManagementSystem/PortfolioManagementSystemEJB/InvestmentBean!portfolio.managementsystem.ejb.InvestmentBeanRemote");
		//TransactionBeanRemote transactionBean = (TransactionBeanRemote) context.lookup("PortfolioManagementSystem/PortfolioManagementSystemEJB/TransactionBean!portfolio.managementsystem.ejb.TransactionBeanRemote");
		//test.receiveData(MarketBean, investmentBean);
*/		//Testing AnalyzeBean @Get function
		//Testing InvestmentBean @Get function
		//test.testInvestmentBeanFunction(investmentBean.getAllInvestments());
		
		//Testing Portfolio @Get function
		//test.testInvestmentByPortfolioFunction(investmentBean.getInvestmentsByPortfolio("Finance"));
		
		//Testing transactions
		//String testTransaction = transactionBean.getAllTransactions().toString();
		//test.testAllTransactions(testTransaction);
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}