package com.stock.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	private String companyName;
	private double sharePrice;
	
	@OneToMany(mappedBy="company")
	private Set<Share> shares=new HashSet<Share>();

	public Set<Share> getShares() {
		return shares;
	}

	public void setShares(Set<Share> shares) {
		this.shares = shares;
	}

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	@Override
	public String toString() {
		return "Company [cid=" + cid + ", companyName=" + companyName + ", sharePrice=" + sharePrice + "]";
	}
	
}
