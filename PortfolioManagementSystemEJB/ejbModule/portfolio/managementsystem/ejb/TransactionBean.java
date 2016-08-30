package portfolio.managementsystem.ejb;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import portfolio.managementsystem.jpa.Stock;
import portfolio.managementsystem.jpa.Transaction;
import portfolio.managementsystem.jpa.User;

/**
 * Session Bean implementation class TransactionBean
 */
@Stateful
@Local(TransactionBeanLocal.class)
@Remote(TransactionBeanRemote.class)
public class TransactionBean implements TransactionBeanRemote, TransactionBeanLocal {

    /**
     * Default constructor. 
     */
    public TransactionBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName = "PortfolioManagementSystemJPA-PU")
    EntityManager em;
    
    public List<Transaction> getAllTransactions(){
    	System.out.println("CHeck");
    	String sql = "SELECT t FROM Transaction AS t";
    	TypedQuery<Transaction> query = em.createQuery(sql,Transaction.class);
    	System.out.println(query.getResultList());
    	return query.getResultList();
    }
    
    public void insertNewTransaction(int type, String ticker, int units, double price, Date d, String username){
    	
    	Transaction t = new Transaction();
    	
    	String sqlStock = "SELECT s FROM Stock AS s WHERE s.ticker='"+ticker+"'";
    	TypedQuery<Stock> queryStock = em.createQuery(sqlStock,Stock.class);
    	t.setStockTransaction(queryStock.getResultList().get(0));
    	
    	String sqlUser = "SELECT u FROM User AS u WHERE u.username='"+username+"'";
    	TypedQuery<User> queryUser = em.createQuery(sqlUser,User.class);
    	t.setUserTransaction(queryUser.getResultList().get(0));
    	
    	t.setBuySell(type);
    	t.setTransactionDate(Calendar.getInstance().getTime());
    	t.setPrice(price);
    	t.setUnits(units);
    	
    	System.out.println(t);
    	
    	em.persist(t);
    	
    }

}
