package portfolio.managementsystem.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class PortfolioBean
 */
@Stateful
@Local(PortfolioBeanLocal.class)
@Remote(PortfolioBeanRemote.class)
public class PortfolioBean implements PortfolioBeanRemote, PortfolioBeanLocal {

    /**
     * Default constructor. 
     */
    public PortfolioBean() {
        // TODO Auto-generated constructor stub
    }
    
    

}
