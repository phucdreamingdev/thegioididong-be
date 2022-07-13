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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "product")

public class Product {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "is_actived")
	private boolean isActived;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manufacturer_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Manufacturer manufacturer;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Version> versions = new HashSet<>();

}
