package vn.com.groupfive.tgdd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
@Entity
@Table(name = "product")

public class Product {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "is_actived")
	private boolean is_actived;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "level")
	private int level;
	
	@Column(name = "parent_name")
	private String parent_name;
	
	@Column(name = "status")
	private boolean status;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
    private Manufacturer manufacturer;
	
}
