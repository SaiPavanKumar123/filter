package loanmanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ajay_credentials")
@Entity
public class Credentials {

	@Id
	@Column(name = "username")
	String user;
	String password;

	public Credentials() {

	}

	public Credentials(String user, String password) {

		this.user = user;
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
