package entitys;

public class Address {
	private int cdAddress;
	private String street;
	private String number;
	private String zipCode;
	private String neighborhood;
	private int cdClient;
	
	public Address(String street, String number, String zipCode, String neighborhood, int cdClient) {
		super();
		this.street = street;
		this.number = number;
		this.zipCode = zipCode;
		this.neighborhood = neighborhood;
		this.cdClient = cdClient;
	}
	
	public int getCdAddress() {
		return cdAddress;
	}

	public void setCdAddress(int cdAddress) {
		this.cdAddress = cdAddress;
	}
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getNeighborhood() {
		return neighborhood;
	}
	
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public int getCdClient() {
		return cdClient;
	}
	
	public void setCdClient(int cdClient) {
		this.cdClient = cdClient;
	}
}
