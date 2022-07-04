package vn.com.groupfive.tgdd.entities;

import java.util.Collection;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "version_color")
public class VersionColor {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_default")
	private boolean isDefault;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private float price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "version_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Version version;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "color_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Color color;

	@OneToMany(mappedBy = "version_color", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Collection<Promotion> promotions;

	@OneToMany(mappedBy = "version_color", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Collection<TransactionDetail> transactionDetails;

	@OneToMany(mappedBy = "version_color", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Collection<OrderDetail> orderDetails;

	@OneToMany(mappedBy = "version_color", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Collection<BranchStock> branchStocks;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "version_color")
	private Set<Image> images = new HashSet<>();
}
