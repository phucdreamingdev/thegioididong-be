package vn.com.groupfive.tgdd.payload.entities;

import java.util.Set;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "specification_detail")
public class SpecificationDetail {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", columnDefinition = "nvarchar(100)")
	private String name;
	
	@Column(name = "content")
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "specification_group_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private SpecificationGroup specificationGroup;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "specification_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Specification specification;
	
	
}
