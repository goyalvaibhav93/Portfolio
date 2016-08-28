package portfolio.managementsystem.ejb;

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
    public List<Investment> getAllInvestments(){
    	String sql = "SELECT p FROM Investment AS p";
    	TypedQuery<Investment> query = em.createQuery(sql,Investment.class);
    	return query.getResultList();
    }

}
