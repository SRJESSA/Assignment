package DeserializationPojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListUsersResponsePojo {
	private int page;
	@JsonProperty("per_page")
	private int perPage;
	private int total;
	@JsonProperty("total_pages")
	private int totalPages;
	private List<UserPojo> data;
	private AdPojo ad;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<UserPojo> getData() {
		return data;
	}
	public void setData(List<UserPojo> data) {
		this.data = data;
	}
	public AdPojo getAd() {
		return ad;
	}
	public void setAd(AdPojo ad) {
		this.ad = ad;
	}
}
