import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import portfolio.managementsystem.ejb.InvestmentBeanRemote;
import portfolio.managementsystem.ejb.MarketBeanRemote;
import portfolio.managementsystem.ejb.TransactionBeanRemote;
import portfolio.managementsystem.jpa.Investment;
import portfolio.managementsystem.jpa.Market;
import portfolio.managementsystem.jpa.Transaction;


public class TestPortfolioMS {
	
	
	public MarketBeanRemote mb;
	public InvestmentBeanRemote ib;
	public TransactionBeanRemote tb;
	public TestPortfolioMS() throws NamingException {
		
		
		Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName()); 
		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		prop.put("jboss.naming.client.ejb.context", true);
		
		// Create the JNDI InitialContext.
		Context context = new InitialContext(prop);
		mb = (MarketBeanRemote) context.lookup("PortfolioManagementSystem/PortfolioManagementSystemEJB/MarketBean!portfolio.managementsystem.ejb.MarketBeanRemote");
		ib = (InvestmentBeanRemote) context.lookup("PortfolioManagementSystem/PortfolioManagementSystemEJB/InvestmentBean!portfolio.managementsystem.ejb.InvestmentBeanRemote");
		tb = (TransactionBeanRemote) context.lookup("PortfolioManagementSystem/PortfolioManagementSystemEJB/TransactionBean!portfolio.managementsystem.ejb.TransactionBeanRemote");

	}
	
	/*Properties prop = new Properties();
	prop.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName()); 
	prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
	prop.put("jboss.naming.client.ejb.context", true);
*/
	/*prop.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName()); 
	prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
	prop.put("jboss.naming.client.ejb.context", true);
*/
	// Create the JNDI InitialContext.
	/*MarketBeanRemote mb;
	InvestmentBeanRemote ib;
	public void receiveData(MarketBeanRemote MarketBean, InvestmentBeanRemote investmentBean ) {
		mb = MarketBean;
		ib = investmentBean;
	}
	 */
	
	//EJBs
	/*MarketBeanRemote MarketBean = (MarketBeanRemote) context.lookup("PortfolioManagementSystem/PortfolioManagementSystemEJB/MarketBean!portfolio.managementsystem.ejb.MarketBeanRemote");
	InvestmentBeanRemote investmentBean = (InvestmentBeanRemote) context.lookup("PortfolioManagementSystem/PortfolioManagementSystemEJB/InvestmentBean!portfolio.managementsystem.ejb.InvestmentBeanRemote");
	*/
	@Test
	public void testAnalyzeBeanFunction() {
		List<Market> testAnalyzeBean = mb.getStockMarketDetails("AACC");
		//String test1 = "{\"avgChange\":0.57575,\"volatility\":\"medium\",\"liquidity\":\"low\",\"marketList\":[{\"id\":1,\"date\":1293993000000,\"open\":5.99,\"high\":6.25,\"low\":5.99,\"close\":6.15,\"volumeTraded\":20300},{\"id\":440,\"date\":1294079400000,\"open\":6.15,\"high\":6.15,\"low\":6.06,\"close\":6.09,\"volumeTraded\":13000},{\"id\":879,\"date\":1294165800000,\"open\":6.1,\"high\":6.17,\"low\":6.01,\"close\":6.15,\"volumeTraded\":31000},{\"id\":1318,\"date\":1294252200000,\"open\":6.14,\"high\":6.31,\"low\":6.08,\"close\":6.19,\"volumeTraded\":12800},{\"id\":2196,\"date\":1294597800000,\"open\":6.15,\"high\":6.3,\"low\":5.97,\"close\":6.06,\"volumeTraded\":43300},{\"id\":2635,\"date\":1294684200000,\"open\":6.09,\"high\":6.32,\"low\":6.06,\"close\":6.24,\"volumeTraded\":8300},{\"id\":3074,\"date\":1294770600000,\"open\":6.29,\"high\":6.51,\"low\":6.21,\"close\":6.4,\"volumeTraded\":16400},{\"id\":3513,\"date\":1294857000000,\"open\":6.41,\"high\":6.5,\"low\":6.4,\"close\":6.41,\"volumeTraded\":10800},{\"id\":3952,\"date\":1294943400000,\"open\":6.42,\"high\":6.51,\"low\":6.42,\"close\":6.47,\"volumeTraded\":11500},{\"id\":4391,\"date\":1295202600000,\"open\":6.47,\"high\":6.47,\"low\":6.47,\"close\":6.47,\"volumeTraded\":0},{\"id\":4826,\"date\":1295289000000,\"open\":6.42,\"high\":6.46,\"low\":5.97,\"close\":6.45,\"volumeTraded\":16000},{\"id\":5264,\"date\":1295461800000,\"open\":5.99,\"high\":6.25,\"low\":5.99,\"close\":6.15,\"volumeTraded\":20300},{\"id\":5703,\"date\":1295634600000,\"open\":6.15,\"high\":6.15,\"low\":6.06,\"close\":6.09,\"volumeTraded\":13000},{\"id\":6142,\"date\":1295721000000,\"open\":6.1,\"high\":6.17,\"low\":6.01,\"close\":6.15,\"volumeTraded\":31000},{\"id\":6581,\"date\":1295893800000,\"open\":6.14,\"high\":6.31,\"low\":6.08,\"close\":6.19,\"volumeTraded\":12800},{\"id\":7020,\"date\":1295893800000,\"open\":6.22,\"high\":6.22,\"low\":5.91,\"close\":6.09,\"volumeTraded\":26300},{\"id\":7459,\"date\":1296153000000,\"open\":6.15,\"high\":6.3,\"low\":5.97,\"close\":6.06,\"volumeTraded\":43300},{\"id\":7898,\"date\":1296412200000,\"open\":6.09,\"high\":6.32,\"low\":6.06,\"close\":6.24,\"volumeTraded\":8300},{\"id\":8337,\"date\":1296585000000,\"open\":6.29,\"high\":6.51,\"low\":6.21,\"close\":6.4,\"volumeTraded\":16400},{\"id\":8776,\"date\":1296757800000,\"open\":6.41,\"high\":6.5,\"low\":6.4,\"close\":6.41,\"volumeTraded\":10800},{\"id\":9215,\"date\":1296930600000,\"open\":6.42,\"high\":6.51,\"low\":6.42,\"close\":6.47,\"volumeTraded\":11500}]}";
		int j=1;
		for(Market i: testAnalyzeBean){
			if(j > 4390)
				break;
			assertEquals(i.getId(),j);
			j+=439;
			
		}
	}
	
	@Test
	public void testInvestmentBeanFunction(){
		List<Investment> testInvestmentBean = ib.getAllInvestments();
		int[] testArray = new int[]{1,3,4,5,6,7,20,21,22,23,24,25};
		int j=0;
		String[] testTickerArray = new String[]{"AACC","BBBY","CASY","ANAT","AKAM","ATHN","AAWW","ABIO","CBEY","CAVM","CATY","BRCD"};
		for(Investment i:testInvestmentBean){
			assertEquals(i.getInvestmentId(),testArray[j]);
			assertEquals(i.getStock().getTicker(),testTickerArray[j]);
			j++;
		}
	}
	
	@Test
	public void testInvestmentByPortfolioFunction(){
		List<Investment> testPortfolio = new ArrayList<>();
		testPortfolio = ib.getInvestmentsByPortfolio("Finance");
		//String test3 = "[{\"investmentId\":1,\"ticker\":\"AACC\",\"investmentCost\":114.1735,\"units\":23,\"username\":\"sun32\",\"portfolio\":\"Finance\"},{\"investmentId\":5,\"ticker\":\"ANAT\",\"investmentCost\":8600.0,\"units\":100,\"username\":\"sun32\",\"portfolio\":\"Finance\"},{\"investmentId\":6,\"ticker\":\"AKAM\",\"investmentCost\":10290.0,\"units\":210,\"username\":\"sun32\",\"portfolio\":\"Finance\"},{\"investmentId\":7,\"ticker\":\"ATHN\",\"investmentCost\":4567.45,\"units\":100,\"username\":\"sun32\",\"portfolio\":\"Finance\"},{\"investmentId\":20,\"ticker\":\"AAWW\",\"investmentCost\":29785.0,\"units\":285,\"username\":\"sun32\",\"portfolio\":\"Finance\"},{\"investmentId\":21,\"ticker\":\"ABIO\",\"investmentCost\":67392.0,\"units\":298,\"username\":\"sun32\",\"portfolio\":\"Finance\"}]";
		int[] testA = new int[]{1,5,6,7,20,21};
		int j=0;
		String[] testS = new String[]{"AACC","ANAT","AKAM","ATHN","AAWW","ABIO"};
		for(Investment i:testPortfolio){
			assertEquals(testA[j],i.getInvestmentId());
			assertEquals(testS[j],i.getStock().getTicker());
			j++;
		}
	}
	
	/*@Test
	public void testComparisonByTicker(String testComparison){
		String test4 = "{\"volatility1\":\"medium\",\"liquidity1\":\"low\",\"avgChange1\":0.57575,\"volatility2\":\"medium\",\"liquidity2\":\"low\",\"avgChange2\":0.25218}";
		assertEquals(testComparison,test4);
	}*/
	
	@Test
	public void testAllTransactions(){
		List<Transaction> transactionList = tb.getAllTransactions();
		int i=1;
		String[] str = new String[]{"AACC","ABIO","BBBY","CASY","ANAT","AKAM","ATHN","ABIO","ABIO","BBBY","AACC","BBBY","ABIO","ABIO","ABIO","ABIO","ABIO","ABIO","ABIO","AACC","CASY","AAON","AAWW","ABIO","ABIO","ABIO","AAWW","AAWW","BBBY","BBBY","CBEY","CAVM","CATY","BRCD","ABIO","ABIO","ABIO","ABIO","ABIO","ABIO","AACC","ABIO","ABIO","ABIO","ABIO"};
		String test4 = "[{\"transactionId\":1,\"units\":123,\"price\":610.5,\"date\":1293993000000,\"buySell\":1,\"ticker\":\"AACC\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":2,\"units\":222,\"price\":3886.5,\"date\":1293993000000,\"buySell\":1,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":3,\"units\":20,\"price\":970.0,\"date\":1294165800000,\"buySell\":1,\"ticker\":\"BBBY\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":4,\"units\":30,\"price\":1200.0,\"date\":1294338600000,\"buySell\":1,\"ticker\":\"CASY\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":5,\"units\":100,\"price\":8600.0,\"date\":1294597800000,\"buySell\":1,\"ticker\":\"ANAT\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":6,\"units\":210,\"price\":10290.0,\"date\":1294770600000,\"buySell\":1,\"ticker\":\"AKAM\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":7,\"units\":100,\"price\":4567.45,\"date\":1295289000000,\"buySell\":1,\"ticker\":\"ATHN\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":8,\"units\":78,\"price\":87.0,\"date\":1472495400000,\"buySell\":1,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":9,\"units\":1000,\"price\":5000.0,\"date\":1472495400000,\"buySell\":0,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":10,\"units\":500,\"price\":8000.0,\"date\":1472495400000,\"buySell\":0,\"ticker\":\"BBBY\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":11,\"units\":100,\"price\":23.0,\"date\":1472495400000,\"buySell\":0,\"ticker\":\"AACC\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":12,\"units\":100,\"price\":1200.0,\"date\":1472495400000,\"buySell\":0,\"ticker\":\"BBBY\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":13,\"units\":100,\"price\":100.0,\"date\":1472495400000,\"buySell\":0,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":14,\"units\":343,\"price\":948.0,\"date\":1472495400000,\"buySell\":1,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":15,\"units\":1000,\"price\":5000.0,\"date\":1472495400000,\"buySell\":1,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":16,\"units\":20,\"price\":12.0,\"date\":1472495400000,\"buySell\":0,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":17,\"units\":413,\"price\":23.0,\"date\":1472495400000,\"buySell\":1,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":18,\"units\":100,\"price\":87.0,\"date\":1472495400000,\"buySell\":1,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":19,\"units\":735,\"price\":98.0,\"date\":1472495400000,\"buySell\":0,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":20,\"units\":100,\"price\":9.0,\"date\":1472495400000,\"buySell\":0,\"ticker\":\"AACC\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":21,\"units\":20,\"price\":10.0,\"date\":1472495400000,\"buySell\":0,\"ticker\":\"CASY\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":22,\"units\":125,\"price\":97.0,\"date\":1472495400000,\"buySell\":1,\"ticker\":\"AAON\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":23,\"units\":65,\"price\":89.0,\"date\":1472495400000,\"buySell\":1,\"ticker\":\"AAWW\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":24,\"units\":22,\"price\":13.0,\"date\":1472495400000,\"buySell\":1,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":25,\"units\":12,\"price\":567.0,\"date\":1472495400000,\"buySell\":1,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":26,\"units\":10,\"price\":3534.0,\"date\":1472495400000,\"buySell\":1,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":27,\"units\":100,\"price\":120.0,\"date\":1472581800000,\"buySell\":1,\"ticker\":\"AAWW\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":28,\"units\":120,\"price\":100.0,\"date\":1472581800000,\"buySell\":1,\"ticker\":\"AAWW\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":29,\"units\":10,\"price\":100.0,\"date\":1472581800000,\"buySell\":1,\"ticker\":\"BBBY\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":30,\"units\":10,\"price\":12.0,\"date\":1472581800000,\"buySell\":1,\"ticker\":\"BBBY\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":31,\"units\":72,\"price\":89.0,\"date\":1472581800000,\"buySell\":1,\"ticker\":\"CBEY\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":32,\"units\":28,\"price\":238.0,\"date\":1472581800000,\"buySell\":1,\"ticker\":\"CAVM\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":33,\"units\":382,\"price\":87.0,\"date\":1472581800000,\"buySell\":1,\"ticker\":\"CATY\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":34,\"units\":23,\"price\":98.0,\"date\":1472581800000,\"buySell\":1,\"ticker\":\"BRCD\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":35,\"units\":12,\"price\":231.0,\"date\":1472581800000,\"buySell\":1,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":36,\"units\":100,\"price\":10.0,\"date\":1472581800000,\"buySell\":1,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":37,\"units\":100,\"price\":100.0,\"date\":1472581800000,\"buySell\":1,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":38,\"units\":34,\"price\":123.0,\"date\":1472581800000,\"buySell\":1,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null},{\"transactionId\":39,\"units\":8,\"price\":876.0,\"date\":1472581800000,\"buySell\":1,\"ticker\":\"ABIO\",\"username\":\"sun32\",\"dateTime\":null}]";
		for(Transaction j:transactionList)
		{
			assertEquals(str[i-1],j.getStockTransaction().getTicker());
			assertEquals(i,j.getTransactionId());
			i++;
		}
		 System.out.println("Success 4");

	}
}
