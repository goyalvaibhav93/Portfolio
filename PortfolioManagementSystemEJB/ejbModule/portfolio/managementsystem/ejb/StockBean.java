package portfolio.managementsystem.ejb;

import java.util.List;

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
	String name;
	
    public StockBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName = "PortfolioManagementSystemJPA-PU")
    EntityManager em;
    
    @Override
    public void init(String name){
    	this.name = name;
    }
    
    @Override
    public String getName(){
    	return this.name;
    }
    
    @Override
    public List<Stock> getAllStocks(){
//    	String sql = "SELECT s FROM Stock AS s";
    	String sql = "SELECT p FROM Stock AS p WHERE p.name LIKE '%a%'";
    	TypedQuery<Stock> query = em.createQuery(sql,Stock.class);
    	return query.getResultList();
    }

}
