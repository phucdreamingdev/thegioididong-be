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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "image_group_version")
public class ImageGroupVersion {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "detail", columnDefinition = "nvarchar(200)")
	private String detail;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "image_group_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private ImageGroup imageGroup;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "version_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Version version;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "imageGroupVersions")
	private Set<Image> image = new HashSet<>();

}
