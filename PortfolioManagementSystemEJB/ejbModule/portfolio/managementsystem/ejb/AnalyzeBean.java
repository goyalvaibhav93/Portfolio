package portfolio.managementsystem.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import portfolio.managementsystem.jpa.Stock;
import portfolio.managementsystem.jpa.Transaction;

/**
 * Session Bean implementation class AnalyzeBean
 */
@Stateful
@Local(AnalyzeBeanLocal.class)
@Remote(AnalyzeBeanRemote.class)
public class AnalyzeBean implements AnalyzeBeanRemote, AnalyzeBeanLocal {

    /**
     * Default constructor. 
     */
    public AnalyzeBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName = "PortfolioManagementSystemJPA-PU")
    EntityManager em;
    
    @Override
    public List<Transaction> getTransaction(){
    	String sql = "SELECT t FROM Transaction AS t";
    	TypedQuery<Transaction> query = em.createQuery(sql,Transaction.class);
    	return query.getResultList();
    }
    
    @Override
    public Transaction getTransactionByTicker(String ticker){
    	String sql = "SELECT s from Stock AS s where ticker='"+ticker+"'";
    	TypedQuery<Stock> query = em.createQuery(sql,Stock.class);
    	Stock s =query.getResultList().get(0);
    	
    	sql = "SELECT t from Transaction AS t where stockTransaction.ticker = '"+s.getTicker()+"'";
    	TypedQuery<Transaction> q = em.createQuery(sql,Transaction.class);
    	return q.getResultList().get(0);
    }
    

}
