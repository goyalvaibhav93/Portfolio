package portfolio.managementsystem.web;

import java.util.HashSet;
import java.util.Set;

import javax.naming.NamingException;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class WebApplication  extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	
	public WebApplication() throws NamingException{
		singletons.add(new InvestmentsREST());
		singletons.add(new PostTest());
	}
	
	@Override
	public Set<Class<?>> getClasses() { return empty; }
	
	@Override
	public Set<Object> getSingletons() { return singletons; }
	
}

