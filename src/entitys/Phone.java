package entitys;

public class Phone {
	private int cdPhone;
	private String phoneType;
	private String ddd;
	private String number;
	private int cdClient;
	
	public Phone(String phoneType, String ddd, String number, int cdClient) {
		this.phoneType = phoneType;
		this.ddd = ddd;
		this.number = number;
		this.cdClient = cdClient;
	}
	public int getCdPhone() {
		return cdPhone;
	}
	public void setCdPhone(int cdPhone) {
		this.cdPhone = cdPhone;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getCdClient() {
		return cdClient;
	}
	public void setCdClient(int cdClient) {
		this.cdClient = cdClient;
	}
}
