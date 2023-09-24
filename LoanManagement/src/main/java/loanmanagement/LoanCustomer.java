package loanmanagement;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ajaycustomers")
@Entity
public class LoanCustomer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cust_id;
	String cust_firstname;
	String cust_lastname;
	Date cust_dob;
	String cust_panno;
	String cust_mobile;
	String cust_address;
	String cust_gname;
	Date lastupdateddate = null;
	int lastuser = 0;

	public LoanCustomer() {

	}

	public LoanCustomer(String cust_firstname, String cust_lastname, Date cust_dob, String cust_panno, String cust_mobile,
			String cust_address, String cust_gname) {
		this.cust_firstname = cust_firstname;
		this.cust_lastname = cust_lastname;
		this.cust_dob = cust_dob;
		this.cust_panno = cust_panno;
		this.cust_mobile = cust_mobile;
		this.cust_address = cust_address;
		this.cust_gname = cust_gname;
	}

	public String getCust_firstname() {
		return cust_firstname;
	}

	public int getCust_id() {
		return cust_id;
	}
	public String getCust_lastname() {
		return cust_lastname;
	}

	public Date getCust_dob() {
		return cust_dob;
	}

	public String getCust_panno() {
		return cust_panno;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public String getCust_address() {
		return cust_address;
	}

	public String getCust_gname() {
		return cust_gname;
	}

	public void setCust_firstname(String cust_firstname) {
		this.cust_firstname = cust_firstname;
	}

	public void setCust_lastname(String cust_lastname) {
		this.cust_lastname = cust_lastname;
	}

	public void setCust_dob(String cust_dob) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = dateFormat.parse(cust_dob);
			this.cust_dob = new Date(utilDate.getTime());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void setCust_panno(String cust_panno) {
		this.cust_panno = cust_panno;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public void setCust_gname(String cust_gname) {
		this.cust_gname = cust_gname;
	}

}