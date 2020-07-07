package entitys;

public class Schedule {
	private int cdSchedule;
	private String deliveryDate;
	private String payday;
	private boolean pending;
	
	public Schedule(String deliveryDate, String payday, boolean pending, int cdClient) {
		this.deliveryDate = deliveryDate;
		this.payday = payday;
		this.pending = pending;
		this.cdClient = cdClient;
	}
	
	private int cdClient;
	
	public int getCdSchedule() {
		return cdSchedule;
	}
	public void setCdSchedule(int cdSchedule) {
		this.cdSchedule = cdSchedule;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getPayday() {
		return payday;
	}
	public void setPayday(String payday) {
		this.payday = payday;
	}
	public boolean isPending() {
		return pending;
	}
	public void setPending(boolean pending) {
		this.pending = pending;
	}
	public int getCdClient() {
		return cdClient;
	}
	public void setCdClient(int cdClient) {
		this.cdClient = cdClient;
	}
}
