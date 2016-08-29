package portfolio.managementsystem.ejb;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import portfolio.managementsystem.jpa.Investment;

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
    public List<Investment> getAllInvestmentsTest(){
    	String sql = "SELECT p FROM Investment AS p";
    	TypedQuery<Investment> query = em.createQuery(sql,Investment.class);
    	return query.getResultList();
    }
    
    @Override
    public List<Object> getAllInvestments(){
    	String sql = "SELECT p FROM Investment AS p";
    	TypedQuery<Investment> query = em.createQuery(sql,Investment.class);
    	List<Object> response =  new ArrayList<>();
    	
    	for (Investment i : query.getResultList()){
			System.out.println(i.getInvestmentId());
			System.out.println(i.getBuyDate());
			System.out.println(i.getBuyPrice());
			System.out.println(i.getUnits());
			System.out.println(i.getInstrument().getTicker());
			System.out.println(i.getUser().getUsername());
			
			response.add((Object) Arrays.asList(i.getInvestmentId(),i.getBuyDate(),i.getBuyPrice(),i.getUnits(),i.getInstrument().getTicker(),i.getUser().getUsername()));
			
		}
    	
    	return response;
    	
    }

}
