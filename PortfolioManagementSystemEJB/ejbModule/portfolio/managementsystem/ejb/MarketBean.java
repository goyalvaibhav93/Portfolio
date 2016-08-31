package portfolio.managementsystem.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import portfolio.managementsystem.jpa.Market;
import portfolio.managementsystem.jpa.Stock;

/**
 * Session Bean implementation class MarketBean
 */
@Stateful
@Local(MarketBeanLocal.class)
@Remote(MarketBeanRemote.class)
public class MarketBean implements MarketBeanRemote, MarketBeanLocal {

    /**
     * Default constructor. 
     */
    public MarketBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName = "PortfolioManagementSystemJPA-PU")
    EntityManager em;
    
    public List<Market> getStockMarketDetails(String ticker){
    	
    	System.out.println("check1");
    	String sqlStock = "SELECT s from Stock AS s where ticker='"+ticker+"'";
    	TypedQuery<Stock> query = em.createQuery(sqlStock,Stock.class);
    	Stock s =query.getResultList().get(0);
    	System.out.println("check2");
    	String sqlMarket = "SELECT m FROM Market AS m WHERE stockMarket.ticker='"+s.getTicker()+"'";
    	TypedQuery<Market> queryMarket = em.createQuery(sqlMarket,Market.class);
    	System.out.println("check3");
    	return queryMarket.getResultList();
    	
    }
    
    

}
