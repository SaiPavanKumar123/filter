package loanmanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "loanapplicantnominees")
@Entity
public class Nominee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_applican_id")
	int nomineeId;
	@Column(name = "loan_nominee")
	String name;
	@Column(name = "loan_applican_relation")
	String relation;

	public String getName() {
		return name;
	}

	public String getRelation() {
		return relation;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

}
