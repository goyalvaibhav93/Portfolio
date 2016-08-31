package portfolio.managementsystem.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import portfolio.managementsystem.jpa.Stock;

/**
 * Session Bean implementation class StockBean
 */
@Stateful
@Local(StockBeanLocal.class)
@Remote(StockBeanRemote.class)
public class StockBean implements StockBeanRemote, StockBeanLocal {

    /**
     * Default constructor. 
     */
    public StockBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName = "PortfolioManagementSystemJPA-PU")
    EntityManager em;
    
    @Override
    public Stock getStockByTicker(String ticker){
    	
    	String sql = "SELECT s from Stock AS s where ticker='"+ticker+"'";
    	TypedQuery<Stock> query = em.createQuery(sql,Stock.class);
    	return query.getResultList().get(0);
    	
    }

}
