package entitys;

public class Client {
	private int cdclient;
	private String nameAndSurname;
	
	public Client(String nameAndSurname) {
		this.nameAndSurname = nameAndSurname;
	}

	public String getNameAndSurname() {
		return nameAndSurname;
	}

	public void setNameAndSurname(String nameAndSurname) {
		this.nameAndSurname = nameAndSurname;
	}

	public int getCdclient() {
		return cdclient;
	}

	public void setCdclient(int cdclient) {
		this.cdclient = cdclient;
	}
}
