package loanmanagement;

import java.sql.Date;

public class Application {

	int appid;
	int custid;
	Date appdate;
	String name;
	String mobile;
	String type;
	double amountreq;
	int montsreq;
	String status;
	
	
	public Application() {
		
	}
	
	
	
	public String getMobile() {
		return mobile;
	}


	public void setMobile(String l) {
		this.mobile = l;
	}
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public Date getAppdate() {
		return appdate;
	}
	public void setAppdate(Date appdate) {
		this.appdate = appdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmountreq() {
		return amountreq;
	}
	public void setAmountreq(double amountreq) {
		this.amountreq = amountreq;
	}
	public int getMontsreq() {
		return montsreq;
	}
	public void setMontsreq(int montsreq) {
		this.montsreq = montsreq;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
