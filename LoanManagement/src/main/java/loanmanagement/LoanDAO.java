package loanmanagement;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

@Component
public class LoanDAO implements LoanDAOContractor {

	@PersistenceContext
	private EntityManager emt;

	public void addCustomer(LoanCustomer loanc) {
		emt.persist(loanc);
	}

	public void addEmiMaster(LoanEMIMaster emi) {
		emt.persist(emi);
	}

	public void addEmiSchedule(LoanEMISchedule emi) {
		emt.persist(emi);
	}

	public List<Loan> findAll() {
		return emt.createQuery("SELECT e FROM Loan e").getResultList();
	}

	@Override
	public void addApplication(LoanApplication loanc) {

		emt.persist(loanc);
	}

	@Override
	public void addNominee(Nominee nomine) {
		emt.persist(nomine);
	}

	@Override
	public List<User> getAllCredentials() {

		return emt.createQuery("select user from User user").getResultList();
	}

	@Override
	public void addLoan(Loan ln) {
		emt.persist(ln);

	}

	@Override
	public List<LoanCustomer> getAllCustomers() {

		System.out.println("dao");
		return emt.createQuery("select cust from LoanCustomer cust").getResultList();
	}

	@Override
	public void updateApplication(String status, int id) {

		String jpql = "UPDATE Loan c SET c.status = :status WHERE c.applicantid = :applicantid";
		Query query = emt.createQuery(jpql);
		query.setParameter("status", status);
		query.setParameter("applicantid", id);
		query.executeUpdate();

	}

	@Override
	public List<LoanEMIMaster> getAllEMIsMaseters() {

		return emt.createQuery("select emi from LoanEMIMaster emi").getResultList();

	}

	@Override
	public List<LoanEMISchedule> getSchedule() {

		return emt.createQuery("select em from LoanEMISchedule em").getResultList();
	}

	@Override
	public void updateProcessedDate(int applicantid) {

		LocalDate currentDate = LocalDate.now();
		Date date = Date.valueOf(currentDate);
		String jpql = "UPDATE Loan c SET c.processeddate = :date WHERE c.applicantid = :applicantid";
		Query query = emt.createQuery(jpql);
		query.setParameter("date", date);
		query.setParameter("applicantid", applicantid);
		query.executeUpdate();

	}

}
