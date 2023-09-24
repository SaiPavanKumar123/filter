package loanmanagement;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="emiMaster")
@Entity
public class LoanEMIMaster {

	@Id
	int applicantid;
	double emiIntrest;
	int noOfEmis;
	double sanctionedAmount;
	double repayAmount;
	
	
	
	public LoanEMIMaster() {

	}
	
	
	public int getApplicantid() {
		return applicantid;
	}
	public void setApplicantid(int applicantid) {
		this.applicantid = applicantid;
	}
	public double getEmiIntrest() {
		return emiIntrest;
	}
	public void setEmiIntrest(double emiIntrest) {
		this.emiIntrest = emiIntrest;
	}
	public int getNoOfEmis() {
		return noOfEmis;
	}
	public void setNoOfEmis(int noOfEmis) {
		this.noOfEmis = noOfEmis;
	}
	public double getSanctionedAmount() {
		return sanctionedAmount;
	}
	public void setSanctionedAmount(double sanctionedAmount) {
		this.sanctionedAmount = sanctionedAmount;
	}
	public double getRepayAmount() {
		return repayAmount;
	}
	public void setRepayAmount(double repayAmount) {
		this.repayAmount = repayAmount;
	}
	
	
	
}
