package loanmanagement;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class LoanManagementFilter extends HttpFilter implements Filter {
       
  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
	/*	
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		//List<User> userList=emt.createQuery("select user from User user").getResultList();
		System.out.println("ajay");
		
		
		int id;
		for (User c : userList) {
			if (c.getUsername().equals(user) && password.equals(c.getPassword())) {
				id = c.getUserid();
				if ("admin".equals(c.getUsertype())) {
					System.out.println("filter");
					chain.doFilter(request, response);
				} else {
					
				}
				break;
			}
		}

		System.out.println("after");
		
		*/
		
	}

	

}
