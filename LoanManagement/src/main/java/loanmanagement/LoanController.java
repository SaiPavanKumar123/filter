package loanmanagement;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoanController {

	LoanService loanServ;

	@Autowired
	LoanController(LoanService loanServ) {
		this.loanServ = loanServ;
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String customer() {

		return "customer";
	}

	@RequestMapping(value = "/applicant", method = RequestMethod.GET)
	public String customer(LoanCustomer customer, HttpSession ses) {

		ses.setAttribute("customer", customer);

		return "loan";

	}

	@RequestMapping(value = "/loan", method = RequestMethod.GET)
	public String loan(LoanApplication loanForm, HttpSession ses) {

		ses.setAttribute("loan", loanForm);

		return "nominne";
	}

	@RequestMapping(value = "/nominee", method = RequestMethod.GET)
	public String nominee(Nominee nomine, HttpSession ses) {

		LoanCustomer application = (LoanCustomer) ses.getAttribute("customer");
		LoanApplication loan = (LoanApplication) ses.getAttribute("loan");
		loanServ.addCustomer(application);
		Loan ln = new Loan();
		ln.setCustomerid(loanServ.getAllCustomers());
		ln.setApplicationdate(loan.getApplicationDate().toString());
		ln.setLoantype(loan.getLoanTypeID());
		ln.setAmountreq(loan.getAmountRequired());
		ln.setMonthsreq(loan.getMonthsRequired());
		ln.setAnnualincome(loan.getAnnualincome());
		ln.setDisposalincome(loan.getDisposalincome());
		loanServ.addLoan(ln);
		loanServ.addNominee(nomine);
		return "home";

	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String adminlogin() {

		return "adminlogin";
	}

	@RequestMapping(value = "/verify", method = RequestMethod.GET)
	public String verify(Credentials cred, Model mod) {

		if (!loanServ.verifyCredentials(cred.getUser(), cred.getPassword())) {

			return "adminlogin";
		} else {
			System.out.println("!else");
			if ("admin".equals(loanServ.verifyuser(cred.getUser(), cred.getPassword()))) {
				mod.addAttribute("userid", loanServ.findUserId(cred.getUser(), cred.getPassword()));
				return "loanmanagement";
			} else {

				mod.addAttribute("userid", loanServ.findUserId(cred.getUser(), cred.getPassword()));
				return "home";
			}

		}

	}

	@RequestMapping(value = "/appliedloans", method = RequestMethod.GET)
	public String appiedApplicants(@RequestParam("userid") int id, Model mod) {

		mod.addAttribute("userid", id);
		mod.addAttribute("applications", loanServ.getAllApplication());
		return "userloanmangement";
	}

	@RequestMapping(value = "/applications", method = RequestMethod.GET)
	public String applicants(Model mod) {

		mod.addAttribute("applications", loanServ.getAllApplication());
		return "applications";
	}

	@RequestMapping(value = "/oneapplicant", method = RequestMethod.GET)
	public String applicationToView(@RequestParam("applicant") String appid, Model mod) {

		int id = Integer.parseInt(appid);
		mod.addAttribute("applicant", loanServ.getLoanApplicant(id));
		return "oneapplicant";
	}

	@RequestMapping(value = "/userapplicant", method = RequestMethod.GET)
	public String userApplicant(@RequestParam("applicant") int id, Model mod) {

		mod.addAttribute("userid", id);
		mod.addAttribute("applicant", loanServ.getLoanApplicant(id));
		return "userapplicant";
	}

	@RequestMapping(value = "/updateapplication", method = RequestMethod.GET)
	public String updateApplication(@RequestParam("status") String status, @RequestParam("applicantid") int id,
			Model mod) {

		loanServ.updateApplication(status, id);
		mod.addAttribute("applications", loanServ.getAllApplication());
		return "applications";
	}

	@RequestMapping(value = "/generateexcel", method = RequestMethod.GET)
	public void ExcelDownload(HttpServletResponse response) throws Exception {

		Workbook workbook = ExcelGenerator.createExcel(loanServ.getAllApplications());

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=loan_applicants.xlsx");
		workbook.write(response.getOutputStream());
		workbook.close();
	}

	@RequestMapping(value = "/customerlogin", method = RequestMethod.GET)
	public String customerlogin() {

		return "customerlogin";
	}

	@RequestMapping(value = "/checkeligibility", method = RequestMethod.GET)
	public String eligibility() {

		return "eligibility";
	}

	@RequestMapping(value = "/checkloan", method = RequestMethod.GET)
	public String checkloan(Eligibilty eligibiltyDetails, Model mod) {

		if (eligibiltyDetails.getCibilScore() < 750) {
			return "noteligible";
		} else {
			double amount = loanServ.checkAmountEligibility(eligibiltyDetails);
			mod.addAttribute("amount", amount);
			mod.addAttribute("emi", eligibiltyDetails.getDisposalIncome() / 2);
			mod.addAttribute("months", eligibiltyDetails.getMonthsReq());
			return "eligible";
		}
	}

	@RequestMapping(value = "/customerverify", method = RequestMethod.GET)
	public String customerverify(Credentials cred) {

		if (cred.getUser().equals("ajay") && "12345".equals(cred.getPassword())) {
			return "home";
		} else {
			return "customerlogin";
		}

	}

	@RequestMapping(value = "/namefilter", method = RequestMethod.GET)
	public String namefilter() {

		return "namesearch";
	}

	@RequestMapping(value = "/namesearch", method = RequestMethod.GET)
	public String namesearch(@RequestParam("name") String name, Model mod) {

		mod.addAttribute("applications", loanServ.searchName(name));
		return "applications";
	}

	@RequestMapping(value = "/mobilefilter", method = RequestMethod.GET)
	public String mobilefilter() {

		return "mobilesearch";
	}

	@RequestMapping(value = "/mobilesearch", method = RequestMethod.GET)
	public String mobilesearch(@RequestParam("mobile") String mobile, Model mod) {

		mod.addAttribute("applications", loanServ.searchMobile(mobile));
		return "applications";
	}

	@RequestMapping(value = "/loantypefilter", method = RequestMethod.GET)
	public String loanTypefilter() {

		return "typesearch";
	}

	@RequestMapping(value = "/loantype", method = RequestMethod.GET)
	public String loanTyoeSearch(@RequestParam("type") String type, Model mod) {

		mod.addAttribute("applications", loanServ.searchLoanType(type));
		return "applications";
	}

	@RequestMapping(value = "/datefilter", method = RequestMethod.GET)
	public String datefilter() {

		return "datesearch";
	}

	@RequestMapping(value = "/datesearch", method = RequestMethod.GET)
	public String dateSearch(@RequestParam("datefrom") String from, @RequestParam("dateto") String to, Model mod) {

		Date datefrom = null;
		Date dateto = null;

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = dateFormat.parse(from);
			datefrom = new Date(utilDate.getTime());
			java.util.Date utilDate1 = dateFormat.parse(to);
			dateto = new Date(utilDate1.getTime());
		} catch (Exception e) {

			e.printStackTrace();
		}

		mod.addAttribute("applications", loanServ.searchDate(datefrom, dateto));
		return "applications";
	}

	@RequestMapping(value = "/emicalculation", method = RequestMethod.GET)
	public String calculateEmi(@RequestParam("applicantid") int applicantid) {

		loanServ.emiCalcilation(applicantid);
		loanServ.updateProccedeDate(applicantid);

		return "userapplications";
	}

	@RequestMapping(value = "/userapplications", method = RequestMethod.GET)
	public String userapplicants(@RequestParam("userid") int id, Model mod) {

		mod.addAttribute("userid", id);
		mod.addAttribute("applications", loanServ.getAllApplication());
		return "userapplications";
	}

	@RequestMapping(value = "/totalemis", method = RequestMethod.GET)
	public String totalEMIs(@RequestParam("userid") int id, Model mod) {

		mod.addAttribute("userid", id);
		mod.addAttribute("emimaster", loanServ.getAllEMIs());
		return "totalemis";
	}

	@RequestMapping(value = "/emischedule", method = RequestMethod.GET)
	public String emiSchedule(@RequestParam("applicant") int id, Model mod) {

		mod.addAttribute("userid", id);
		mod.addAttribute("emischedule", loanServ.getEmiSchedule(id));
		return "emischedule";
	}

}
