package it.polito.tdp.yelp.model;

public class LocaleMigliore {
	private Business b;
	private double val;
	public LocaleMigliore(Business b, double val) {
		super();
		this.b = b;
		this.val = val;
	}
	public Business getB() {
		return b;
	}
	public void setB(Business b) {
		this.b = b;
	}
	public double getVal() {
		return val;
	}
	public void setVal(double val) {
		this.val = val;
	}
	@Override
	public String toString() {
		return "LocaleMigliore [b=" + b.getBusinessName() + ", val=" + val + "]";
	}
	

}
