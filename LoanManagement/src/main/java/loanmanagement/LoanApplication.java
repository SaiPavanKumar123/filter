package loanmanagement;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "loanapplicants")
@Entity
public class LoanApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int loan_applicant_id;
	@Column(name = "loan_application_date")
	Date applicationDate;
	@Column(name = "loan_type_id")
	int loanTypeID;
	@Column(name = "loan_amount_req")
	double amountRequired;
	@Column(name = "loan_no_of_req")
	int monthsRequired;
	double annualincome;
	double disposalincome;

	public LoanApplication() {

	}

	public LoanApplication(Date applicationDate, int loanTypeID, double amountRequired, int monthsRequired) {

		this.applicationDate = applicationDate;
		this.loanTypeID = loanTypeID;
		this.amountRequired = amountRequired;

		this.monthsRequired = monthsRequired;
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

	public Date getApplicationDate() {
		return applicationDate;
	}

	public int getLoanTypeID() {
		return loanTypeID;
	}

	public double getAmountRequired() {
		return amountRequired;
	}

	public int getMonthsRequired() {
		return monthsRequired;
	}

	public void setApplicationDate(String applicationDate) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = dateFormat.parse(applicationDate);
			this.applicationDate = new Date(utilDate.getTime());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void setLoanTypeID(int loanTypeID) {
		this.loanTypeID = loanTypeID;
	}

	public void setAmountRequired(double amountRequired) {
		this.amountRequired = amountRequired;
	}

	public void setMonthsRequired(int monthsRequired) {
		this.monthsRequired = monthsRequired;
	}

}
