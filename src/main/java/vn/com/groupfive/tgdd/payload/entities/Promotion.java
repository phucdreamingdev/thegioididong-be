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
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "promotion")
public class Promotion {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "promotion_percent")
	private int promotionPercent;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "is_actived")
	private boolean isActived;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "promotion_verion_color", 
	joinColumns = { @JoinColumn(name = "promotion_id") }, 
	inverseJoinColumns = {@JoinColumn(name = "province_id")})
	private Set<VersionColor> versionColors = new HashSet<>();

	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "promotions")
	private Set<Province> provinces = new HashSet<>();

	//contructor to create promotion
	public Promotion(int promotionPercent, Date startDate, Date endDate, boolean isActived,
			Set<VersionColor> versionColors, Set<Province> provinces) {
		
		this.promotionPercent = promotionPercent;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isActived = isActived;
		this.versionColors = versionColors;
		this.provinces = provinces;
	}
	
	
}
