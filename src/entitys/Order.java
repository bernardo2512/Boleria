package entitys;

public class Order {
	private int cdOrder;
	private int cdProduct;
	private int cdSchedule;
	private int amount;
	private double salePrice;
	
	public Order(int cdProduct, int cdSchedule, int amount, double salePrice) {
		this.cdProduct = cdProduct;
		this.cdSchedule = cdSchedule;
		this.amount = amount;
		this.salePrice = salePrice;
	}
	
	public int getCdOrder() {
		return cdOrder;
	}
	public void setCdOrder(int cdOrder) {
		this.cdOrder = cdOrder;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public int getCdProduct() {
		return cdProduct;
	}
	public void setCdProduct(int cdProduct) {
		this.cdProduct = cdProduct;
	}
	public int getCdSchedule() {
		return cdSchedule;
	}
	public void setCdSchedule(int cdSchedule) {
		this.cdSchedule = cdSchedule;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
