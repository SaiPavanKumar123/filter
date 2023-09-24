package loanmanagement;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

	LoanDAOContractor loanDAO;

	@Autowired
	LoanService(LoanDAOContractor loan) {

		this.loanDAO = loan;
	}

	@Transactional
	public void addCustomer(LoanCustomer lc) {
		loanDAO.addCustomer(lc);
	}

	@Transactional
	public void addApplication(LoanApplication loan) {
		loanDAO.addApplication(loan);
	}

	@Transactional
	public void addNominee(Nominee nomine) {
		loanDAO.addNominee(nomine);
	}

	@Transactional
	public boolean verifyCredentials(String user, String password) {

		List<User> ls = loanDAO.getAllCredentials();
		System.out.println(ls.get(3).getPassword());
		boolean check = false;
		for (User c : ls) {
			if (c.getUsername().equals(user) && password.equals(c.getPassword())) {
				check = true;
				break;
			}
		}

		return check;
	}

	@Transactional
	public String verifyuser(String user, String password) {

		List<User> ls = loanDAO.getAllCredentials();
		String type = "";

		for (User c : ls) {
			if (c.getUsername().equals(user) && password.equals(c.getPassword())) {

				type = c.getUsertype();
				break;
			}
		}

		return type;
	}

	public int findUserId(String username, String password) {

		List<User> ls = loanDAO.getAllCredentials();
		int userid = 0;

		for (User c : ls) {
			if (c.getUsername().equals(username) && password.equals(c.getPassword())) {

				userid = c.getUserid();
				break;
			}
		}

		return userid;
	}

	// getting all applications
	public List<Application> getAllApplication() {

		List<Loan> list = loanDAO.findAll();
		List<Application> applist = new ArrayList<>();
		List<LoanCustomer> custList = loanDAO.getAllCustomers();
		for(LoanCustomer ln:custList) {
			System.out.println(ln.getCust_mobile());
		}
		for (Loan ln : list) {
			Application app = new Application();
			app.setAppid(ln.getApplicantid());
			app.setCustid(ln.getCustomerid());
			app.setAppdate(ln.getApplicationdate());
			app.setAmountreq(ln.getAmountreq());
			String type = "";
			if (ln.getLoantype() == 1) {
				type = "personal";
			} else if (ln.getLoantype() == 2) {
				type = "home";
			} else {
				type = "vehical";
			}
			app.setType(type);
			app.setMontsreq(ln.getMonthsreq());
			app.setStatus(ln.getStatus());
			System.out.println("ajau");
			for (LoanCustomer lc : custList) {
				if (lc.getCust_id() == ln.getCustomerid()) {
					app.setName(lc.getCust_firstname() + lc.getCust_lastname());
					app.setMobile(lc.getCust_mobile());
					System.out.println(lc.getCust_mobile());
				}
			}
			applist.add(app);
		}

		return applist;

	}

	public List<Loan> getAllApplications() {

		return loanDAO.findAll();
	}

	@Transactional
	public void addLoan(Loan ln) {
		loanDAO.addLoan(ln);
	}

	// getting all customers
	public int getAllCustomers() {

		List<LoanCustomer> ls = loanDAO.getAllCustomers();

		return ls.size();
	}

	// getting all applications by application id
	public Loan getLoanApplicant(int appid) {

		List<Loan> ls = loanDAO.findAll();
		Loan loan = new Loan();

		for (Loan ln : ls) {

			if (ln.getApplicantid() == appid) {
				loan = ln;
				break;
			}
		}
		return loan;
	}

	// updating the status as by the admin
	@Transactional
	public void updateApplication(String status, int id) {

		loanDAO.updateApplication(status, id);

	}

	// searching by name
	public List<Application> searchName(String name) {
		List<Application> appList = new ArrayList<>();
		List<LoanCustomer> custList = loanDAO.getAllCustomers();
		List<Loan> loanList = loanDAO.findAll();
		for (LoanCustomer cust : custList) {
			if (cust.getCust_firstname().equals(name)) {

				for (Loan ln : loanList) {
					if (ln.getCustomerid() == cust.getCust_id()) {
						Application app = new Application();
						app.setCustid(cust.getCust_id());
						app.setMobile(cust.getCust_mobile());
						
						app.setName(cust.getCust_firstname() + cust.getCust_lastname());
						app.setAmountreq(ln.getAmountreq());
						app.setAppdate(ln.getApplicationdate());
						app.setAppid(ln.getApplicantid());
						app.setMontsreq(ln.getMonthsreq());
						String type = "";
						if (ln.getLoantype() == 1) {
							type = "personal";
						} else if (ln.getLoantype() == 2) {
							type = "home";
						} else {
							type = "vehical";
						}
						app.setType(type);
						app.setStatus(ln.getStatus());
						appList.add(app);
					}
				}
			}
		}

		return appList;
	}

	public List<Application> searchMobile(String mobile) {
		List<Application> appList = new ArrayList<>();
		List<LoanCustomer> custList = loanDAO.getAllCustomers();
		List<Loan> loanList = loanDAO.findAll();
		for (LoanCustomer cust : custList) {
			if (cust.getCust_mobile().equals(mobile)) {

				for (Loan ln : loanList) {
					if (ln.getCustomerid() == cust.getCust_id()) {
						Application app = new Application();
						app.setCustid(cust.getCust_id());
						app.setMobile(cust.getCust_mobile());
						app.setName(cust.getCust_firstname() + cust.getCust_lastname());
						app.setAmountreq(ln.getAmountreq());
						app.setAppdate(ln.getApplicationdate());
						app.setAppid(ln.getApplicantid());
						app.setMontsreq(ln.getMonthsreq());
						String type = "";
						if (ln.getLoantype() == 1) {
							type = "personal";
						} else if (ln.getLoantype() == 2) {
							type = "home";
						} else {
							type = "vehical";
						}
						app.setType(type);
						app.setStatus(ln.getStatus());
						appList.add(app);
					}
				}
			}
		}

		return appList;
	}

	// searching loans by type of loan
	public List<Application> searchLoanType(String type) {
		int loanType = 1;
		if ("personal".equalsIgnoreCase(type)) {
			loanType = 1;
		} else if ("home".equalsIgnoreCase(type)) {
			loanType = 2;
		} else {
			loanType = 3;
		}
		List<Application> appList = new ArrayList<>();
		List<LoanCustomer> custList = loanDAO.getAllCustomers();
		List<Loan> loanList = loanDAO.findAll();

		for (Loan ln : loanList) {
			if (ln.getLoantype() == loanType) {
				for (LoanCustomer cust : custList) {
					if (cust.getCust_id() == ln.getCustomerid()) {
						Application app = new Application();
						app.setCustid(cust.getCust_id());
						app.setMobile(cust.getCust_mobile());
						app.setName(cust.getCust_firstname() + cust.getCust_lastname());
						app.setAmountreq(ln.getAmountreq());
						app.setAppdate(ln.getApplicationdate());
						app.setAppid(ln.getApplicantid());
						app.setMontsreq(ln.getMonthsreq());
						String lntype = "";
						if (ln.getLoantype() == 1) {
							lntype = "personal";
						} else if (ln.getLoantype() == 2) {
							lntype = "home";
						} else {
							lntype = "vehical";
						}
						app.setType(lntype);
						app.setStatus(ln.getStatus());
						appList.add(app);
					}
				}
			}
		}

		return appList;
	}

	// searching loans by the date range
	public List<Application> searchDate(Date from, Date to) {

		List<Application> appList = new ArrayList<>();
		List<LoanCustomer> custList = loanDAO.getAllCustomers();
		List<Loan> loanList = loanDAO.findAll();

		for (Loan ln : loanList) {
			if (ln.getApplicationdate().compareTo(from) < 0 && ln.getApplicationdate().compareTo(from) > 0) {
				for (LoanCustomer cust : custList) {
					if (cust.getCust_id() == ln.getCustomerid()) {
						Application app = new Application();
						app.setCustid(cust.getCust_id());
						app.setMobile(cust.getCust_mobile());
						app.setName(cust.getCust_firstname() + cust.getCust_lastname());
						app.setAmountreq(ln.getAmountreq());
						app.setAppdate(ln.getApplicationdate());
						app.setAppid(ln.getApplicantid());
						app.setMontsreq(ln.getMonthsreq());
						String lntype = "";
						if (ln.getLoantype() == 1) {
							lntype = "personal";
						} else if (ln.getLoantype() == 2) {
							lntype = "home";
						} else {
							lntype = "vehical";
						}
						app.setType(lntype);
						app.setStatus(ln.getStatus());
						appList.add(app);
					}
				}
			}
		}

		return appList;
	}

	// calculating the emis for the loan
	@Transactional
	public void emiCalcilation(int applicantid) {

		List<Loan> appList = loanDAO.findAll();
		Loan loan = new Loan();
		// finding respective applicant using for loop
		for (Loan ln : appList) {

			if (ln.getApplicantid() == applicantid) {
				loan = ln;
				break;
			}
		}
		double principleAmount = loan.getAmountreq();
		double rateOfInterestPerYear = 0;

		if (loan.getLoantype() == 1) {
			rateOfInterestPerYear = 7.2;
		} else if (loan.getLoantype() == 2) {
			rateOfInterestPerYear = 10.5;
		} else {
			rateOfInterestPerYear = 8.85;
		}

		double rateOfInterestPerMonth = ((rateOfInterestPerYear) / 12.0) / 100.0;
		int noOfMonthsForLoanPay = loan.getMonthsreq();

		// EMI for each month calculated formula = P * R * (1 + R)^N / ((1+R)^N-1)
		// P = PRINCIPLE AMOUNT
		// R = RATE OF INTEREST FOR MONTH
		// N = NO OF MOTHS THAT EMI SHOULD PAY OR LOAN TENURE FOR MONTHS
		double eachEmiAmount = (principleAmount * rateOfInterestPerMonth
				* Math.pow(1 + rateOfInterestPerMonth, noOfMonthsForLoanPay))
				/ (Math.pow(1 + rateOfInterestPerMonth, noOfMonthsForLoanPay) - 1);

		double totalRepay = eachEmiAmount * noOfMonthsForLoanPay;

		LoanEMIMaster emi = new LoanEMIMaster();
		emi.setApplicantid(applicantid);
		emi.setEmiIntrest(rateOfInterestPerYear);
		emi.setNoOfEmis(noOfMonthsForLoanPay);
		emi.setSanctionedAmount(loan.getAmountreq());
		emi.setRepayAmount(totalRepay);

		LocalDate currentDate = LocalDate.now();
		Month nextMonth = currentDate.getMonth();
		LocalDate startDate = LocalDate.of(2023, nextMonth, 7);
		for (int i = 1; i <= noOfMonthsForLoanPay; i++) {

			startDate = startDate.with(TemporalAdjusters.firstDayOfNextMonth());
			startDate = startDate.withDayOfMonth(7);
			Date emiDate = Date.valueOf(startDate);
			LoanEMISchedule emischedule = new LoanEMISchedule();

			emischedule.setApplicantid(applicantid);
			emischedule.setEmiAmount(eachEmiAmount);
			emischedule.setEmiIndex(i);
			emischedule.setEmiDate(emiDate);
			loanDAO.addEmiSchedule(emischedule);
		}
		loanDAO.addEmiMaster(emi);

	}

	// getting all santioned loans from the emi master table
	public List<LoanEMIMaster> getAllEMIs() {

		return loanDAO.getAllEMIsMaseters();

	}

	public double checkAmountEligibility(Eligibilty el) {

		double eligibleAmount = 0;

		eligibleAmount = el.getDisposalIncome() * el.getMonthsReq();

		return eligibleAmount;

	}

	public List<LoanEMISchedule> getEmiSchedule(int applicantid) {
		List<LoanEMISchedule> emis = loanDAO.getSchedule();
		List<LoanEMISchedule> emi = new ArrayList<>();
		for (LoanEMISchedule ems : emis) {
			if (ems.getApplicantid() == applicantid) {
				emi.add(ems);
			}

		}
		return emi;
	}

	@Transactional
	public void updateProccedeDate(int applicantid) {
		loanDAO.updateProcessedDate(applicantid);
	}

}
