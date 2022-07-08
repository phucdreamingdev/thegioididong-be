package vn.com.groupfive.tgdd.payload.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "transaction_date")
	private Date transactionDate;
	
	@Column(name = "total")
	private int total;
	
	@Column(name = "detail")
	private String detail;
	 
	@ManyToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	@JoinTable(name = "transaction_branch",
			joinColumns = { @JoinColumn(name ="transaciton_id")},
			inverseJoinColumns = { @JoinColumn(name ="branch_id")})
	private Set<Branch> branchs = new HashSet<>();
	
	@OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<TransactionDetail> transactionDetails = new HashSet<>();
}
