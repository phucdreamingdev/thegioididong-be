package vn.com.groupfive.tgdd.payload.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "transaction_detail")
public class TransactionDetail {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "stock")
	private int stock;

	@Column(name = "in_stock")
	private boolean in_stock;

	@Column(name = "transaction_date")
	private Date transactionDate;

	@Column(name = "transaction_quantity")
	private int transactionQuantity;

	@Column(name = "note", columnDefinition = "nvarchar(200)")
	private String note;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "version_color_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private VersionColor versionColor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Transaction transaction;
}
