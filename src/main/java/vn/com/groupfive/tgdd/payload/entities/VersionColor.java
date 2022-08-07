package vn.com.groupfive.tgdd.payload.entities;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "version_color")
public class VersionColor {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_default")
	private boolean isDefault;

	@Column(name = "name", columnDefinition = "nvarchar(100)")
	private String name;

	@Column(name = "price")
	private double price;
	
	@Column(name = "avartar")
	private String avartar;

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

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "versionColors")
	private Set<Promotion> promotions = new HashSet<>();

	@OneToMany(mappedBy = "versionColor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<TransactionDetail> transactionDetails = new HashSet<>();

	@OneToMany(mappedBy = "versionColor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<OrderDetail> orderDetails = new HashSet<>();

	@OneToMany(mappedBy = "versionColor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<BranchStock> branchStocks = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "versionColors")
	private Set<Image> images = new HashSet<>();
	
}
