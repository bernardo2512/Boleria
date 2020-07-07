package entitys;

public class Product {
	private int cdProduct;
	private String description;
	private double price;
	
	public Product(String description, double price) {
		this.price = price;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getCdProduct() {
		return cdProduct;
	}

	public void setCdProduct(int cdProduct) {
		this.cdProduct = cdProduct;
	}
	
}
