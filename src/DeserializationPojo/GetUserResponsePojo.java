package DeserializationPojo;

public class GetUserResponsePojo {
	private UserPojo data;
	private AdPojo ad;
	
	public UserPojo getData() {
		return data;
	}
	public void setData(UserPojo data) {
		this.data = data;
	}
	public AdPojo getAd() {
		return ad;
	}
	public void setAd(AdPojo ad) {
		this.ad = ad;
	}
}
