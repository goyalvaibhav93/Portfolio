package portfolio.managementsystem.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="users")

public class User implements Serializable {

	   
	
	private String username;
	private String password;
	private static final long serialVersionUID = 1L;
	
	@JsonManagedReference
	private List<Investment> investments = new ArrayList<>();

	public User() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	
	@OneToMany(mappedBy="user")
	public List<Investment> getInvestments() {
		return investments;
	}

	public void setInvestments(List<Investment> investments) {
		this.investments = investments;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
   
}
