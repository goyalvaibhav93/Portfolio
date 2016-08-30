package portfolio.managementsystem.ejb;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import portfolio.managementsystem.jpa.Instrument;
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
	
//	String tick;
	
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
    public void insertNewInvestment(double buyPrice, int units, String username, String ticker){
    	
    	Investment i = new Investment();
    	i.setBuyDate(Calendar.getInstance().getTime());
    	i.setBuyPrice(buyPrice);
    	i.setUnits(units);
    	
    	String sqlUser = "SELECT u FROM User u WHERE username='"+username+"'";
    	TypedQuery<User> query = em.createQuery(sqlUser,User.class);
    	
    	i.setUser(query.getResultList().get(0));
    	
    	String sqlTicker = "SELECT t FROM  Instrument t WHERE ticker='"+ticker+"'";
    	TypedQuery<Instrument> queryTicker = em.createQuery(sqlTicker,Instrument.class);
    	
    	i.setInstrument(queryTicker.getResultList().get(0));
    	
    	em.persist(i);
    	
    	//System.out.println(buyPrice +" " +units + " " + username + ticker);
    	
    }

}
