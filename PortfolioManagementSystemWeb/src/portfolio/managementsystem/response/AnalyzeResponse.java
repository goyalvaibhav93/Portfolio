package portfolio.managementsystem.response;

import java.util.Date;

public class AnalyzeResponse {
	private String ticker;
	private double open;
	private double high;
	private double low;
	private double close;
	private int volumeTraded;
	private Date date;
	
	
	public AnalyzeResponse(){
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public int getVolumeTraded() {
		return volumeTraded;
	}

	public void setVolumeTraded(int volumeTraded) {
		this.volumeTraded = volumeTraded;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

		
		
}
