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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", columnDefinition = "nvarchar(100)")
	private String name;
	
	@Column(name = "logo")
	private String logo;

	@Column(name = "level")
	private int level;

	@Column(name = "parent_name", columnDefinition = "nvarchar(100)")
	private String parentName;

	@Column(name = "status")
	private boolean status;
	
	@Column(name = "is_parent")
	private boolean isParent;
	
	@Column(name = "children_level")
	private int childrenLevel;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Product> products = new HashSet<>();

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<ImageGroup> imageGroups = new HashSet<>();

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<SpecificationGroup> specificationGroups = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "categories")
	private Set<Manufacturer> manufacturers= new HashSet<>();

	//Create Category contructor
	public Category(String name, String logo, int level, String parentName, boolean status, boolean isParent,
			int childrenLevel) {
		super();
		this.name = name;
		this.logo = logo;
		this.level = level;
		this.parentName = parentName;
		this.status = status;
		this.isParent = isParent;
		this.childrenLevel = childrenLevel;
	}
	
	

}
