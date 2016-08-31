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

import portfolio.managementsystem.jpa.Investment;
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
    
    public String insertNewTransaction(int type, String ticker, int units, double price, Date d, String username){
    	
    	Transaction t = new Transaction();
    	
    	String sqlStock = "SELECT s FROM Stock AS s WHERE s.ticker='"+ticker+"'";
    	TypedQuery<Stock> queryStock = em.createQuery(sqlStock,Stock.class);
    	if (queryStock.getResultList().size()==0) return "Ticker Not Found";
    	t.setStockTransaction(queryStock.getResultList().get(0));
    	
    	String sqlUser = "SELECT u FROM User AS u WHERE u.username='"+username+"'";
    	TypedQuery<User> queryUser = em.createQuery(sqlUser,User.class);
    	t.setUserTransaction(queryUser.getResultList().get(0));
    	
    	String sqlInvestment = "SELECT i FROM Investment AS i WHERE stock.ticker='"+queryStock.getResultList().get(0).getTicker()+"'";
		TypedQuery<Investment> queryInvestment = em.createQuery(sqlInvestment,Investment.class);
		
    	
    	if(type==0){
    		int unitsCheck = queryInvestment.getResultList().get(0).getUnits();
    		if(unitsCheck - units < 0) {
    			return "You do not have sufficient units of this stock";
    		}
    		else if(unitsCheck - units==0){
    			em.remove(queryInvestment.getResultList().get(0));
    		}
    		else{
    			double ic = queryInvestment.getResultList().get(0).getinvestmentCost();
    			int u = queryInvestment.getResultList().get(0).getUnits();
    			double totalprice =  ic - ( price * (double)units);
    			int totalunits = u - units;
    			Investment in = new Investment();
    			in.setInvestmentId(queryInvestment.getResultList().get(0).getInvestmentId());
    			in.setStock(queryInvestment.getResultList().get(0).getStock());
    			in.setUser(queryInvestment.getResultList().get(0).getUser());
    			in.setUnits(totalunits);
    			in.setinvestmentCost(totalprice);
    			em.merge(in);
    		}
    	}
    	
    	if(type==1){
    		int size = queryInvestment.getResultList().size();
    		if(size!=0){
    			double totalprice = (double)units * price + queryInvestment.getResultList().get(0).getinvestmentCost();
    			int totalunits = units + queryInvestment.getResultList().get(0).getUnits();
    			Investment in = new Investment();
    			in.setInvestmentId(queryInvestment.getResultList().get(0).getInvestmentId());
    			in.setStock(queryInvestment.getResultList().get(0).getStock());
    			in.setUser(queryInvestment.getResultList().get(0).getUser());
    			in.setUnits(totalunits);
    			in.setinvestmentCost(totalprice);
    			em.merge(in);
    		}
    		else{
    			double totalprice = (double)units * price;
    			int totalunits = units;
    			Investment in = new Investment();
    			in.setStock(queryStock.getResultList().get(0));
    			in.setUser(queryUser.getResultList().get(0));
    			in.setUnits(totalunits);
    			in.setinvestmentCost(totalprice);
    			em.persist(in);
    		}
    		
    	}
    	
    	t.setBuySell(type);
    	t.setTransactionDate(Calendar.getInstance().getTime());
    	t.setPrice(price);
    	t.setUnits(units);
    	
    	System.out.println(t);
    	
    	em.persist(t);
    	return "Transaction successfully added";
    }

    public List<Transaction> getTransactionsByTicker(String ticker){
    	String sqlStock = "SELECT s from Stock AS s where ticker='"+ticker+"'";
    	TypedQuery<Stock> query = em.createQuery(sqlStock,Stock.class);
    	Stock s =query.getResultList().get(0);
    	
    	String sqlTransaction = "SELECT t from Transaction AS t where stockTransaction.ticker = '"+s.getTicker()+"'";
    	TypedQuery<Transaction> qTransaction = em.createQuery(sqlTransaction,Transaction.class);
    	return qTransaction.getResultList();
    }

}
