package loanmanagement;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ajayapplicants")
@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int applicantid;
	int customerid;
	Date applicationdate;
	int loantype;
	double amountreq;
	double emirangefrom = 0;
	double emirangeto = 0;
	int monthsreq;
	double annualincome;
	double disposalincome;
	int cibilscore = 0;
	String status = "";
	String remarks = "";
	int processeduser = 0;
	Date processeddate = null;

	public Loan() {

	}

	public Loan(int applicantid, int customerid, Date applicationdate, int loantype, double amountreq,
			double emirangefrom, double emirangeto, int monthsreq, int cibilscore, String status, String remarks,
			int processeduser, Date processeddate) {

		this.applicantid = applicantid;
		this.customerid = customerid;
		this.applicationdate = applicationdate;
		this.loantype = loantype;
		this.amountreq = amountreq;
		this.emirangefrom = emirangefrom;
		this.emirangeto = emirangeto;
		this.monthsreq = monthsreq;
		this.cibilscore = cibilscore;
		this.status = status;
		this.remarks = remarks;
		this.processeduser = processeduser;
		this.processeddate = processeddate;
	}

	public double getAnnualincome() {
		return annualincome;
	}

	public double getDisposalincome() {
		return disposalincome;
	}

	public void setAnnualincome(double annualincome) {
		this.annualincome = annualincome;
	}

	public void setDisposalincome(double disposalincome) {
		this.disposalincome = disposalincome;
	}

	public int getApplicantid() {
		return applicantid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public Date getApplicationdate() {
		return applicationdate;
	}

	public int getLoantype() {
		return loantype;
	}

	public double getAmountreq() {
		return amountreq;
	}

	public double getEmirangefrom() {
		return emirangefrom;
	}

	public double getEmirangeto() {
		return emirangeto;
	}

	public int getMonthsreq() {
		return monthsreq;
	}

	public int getCibilscore() {
		return cibilscore;
	}

	public String getStatus() {
		return status;
	}

	public String getRemarks() {
		return remarks;
	}

	public int getProcesseduser() {
		return processeduser;
	}

	public Date getProcesseddate() {
		return processeddate;
	}

	public void setApplicantid(int applicantid) {
		this.applicantid = applicantid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public void setApplicationdate(String applicationdate) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = dateFormat.parse(applicationdate);
			this.applicationdate = new Date(utilDate.getTime());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void setLoantype(int loantype) {
		this.loantype = loantype;
	}

	public void setAmountreq(double amountreq) {
		this.amountreq = amountreq;
	}

	public void setEmirangefrom(double emirangefrom) {
		this.emirangefrom = emirangefrom;
	}

	public void setEmirangeto(double emirangeto) {
		this.emirangeto = emirangeto;
	}

	public void setMonthsreq(int monthsreq) {
		this.monthsreq = monthsreq;
	}

	public void setCibilscore(int cibilscore) {
		this.cibilscore = cibilscore;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setProcesseduser(int processeduser) {
		this.processeduser = processeduser;
	}

	public void setProcesseddate(String processeddate) {

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = dateFormat.parse(processeddate);
			this.processeddate = new Date(utilDate.getTime());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
