package pojo;

import java.util.List;



public class listUsers  {
	
	private int page;
	private int per_page;
	private int total;
	private int total_page;
	private List<dataTest> data;
	private adTest ad;
	
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_page() {
		return total_page;
	}
	public void setTotal_page(int total_page) {
		this.total_page = total_page;
	}
	public List<dataTest> getData() {
		return data;
	}
	public void setData(List<dataTest> data) {
		this.data = data;
	}
	public adTest getAd() {
		return ad;
	}
	public void setAd(adTest ad) {
		this.ad = ad;
	}
	 

}
