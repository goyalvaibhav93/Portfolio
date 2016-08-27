package portfolio.managementsystem.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shares")
public class Stock implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private int ShareId;
	private String Ticker;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getShareId() {
		return ShareId;
	}
	public void setShareId(int id) {
		this.ShareId = id;
	}
	public String getTicker() {
		return Ticker;
	}
	public void setTicker(String name) {
		this.Ticker = name;
	}
	
}
