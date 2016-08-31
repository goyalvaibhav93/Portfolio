package portfolio.managementsystem.ejb;

import java.util.List;


import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import portfolio.managementsystem.jpa.Stock;
import portfolio.managementsystem.jpa.Investment;
import portfolio.managementsystem.jpa.User;

/**
 * Session Bean implementation class InvestmentBean
 */
@Stateful
@Local(InvestmentBeanLocal.class)
@Remote(InvestmentBeanRemote.class)
public class InvestmentBean implements InvestmentBeanRemote, InvestmentBeanLocal {

    /**
     * Default constructor. 
     */
	
	
    public InvestmentBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName = "PortfolioManagementSystemJPA-PU")
    EntityManager em;
    
    @Override
    public List<Investment> getAllInvestments(){
    	String sql = "SELECT p FROM Investment AS p";
    	TypedQuery<Investment> query = em.createQuery(sql,Investment.class);
    	return query.getResultList();
    }
    
    @Override
    public void insertNewInvestment(double investmentCost, int units, String username, String ticker){
    	
    	Investment i = new Investment();
    	i.setinvestmentCost(investmentCost);
    	i.setUnits(units);
    	
    	String sqlUser = "SELECT u FROM User u WHERE username='"+username+"'";
    	TypedQuery<User> query = em.createQuery(sqlUser,User.class);
    	
    	i.setUser(query.getResultList().get(0));
    	
    	String sqlTicker = "SELECT t FROM  Stock t WHERE ticker='"+ticker+"'";
    	TypedQuery<Stock> queryTicker = em.createQuery(sqlTicker,Stock.class);
    	
    	i.setStock(queryTicker.getResultList().get(0));
    	
    	em.persist(i);
    	
    	//System.out.println(buyPrice +" " +units + " " + username + ticker);
    	
    }
    
    @Override
    public List<Investment> getInvestmentsByPortfolio(String portfolioName){

    	String sql = "SELECT i FROM Investment AS i WHERE stock IN (SELECT s FROM Stock AS s WHERE portfolio.portfolioName='"+portfolioName+"')";
    	TypedQuery<Investment> query = em.createQuery(sql,Investment.class);
    	
    	return query.getResultList();
    	
    }

}
