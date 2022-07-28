package vn.com.groupfive.tgdd.payload.entities;

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
@Table(name = "district")
public class District {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", columnDefinition = "nvarchar(50)")
	private String name;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "province_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Province province;
}
