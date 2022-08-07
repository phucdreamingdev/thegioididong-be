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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "original_price")
	private float originalPrice;

	@Column(name = "promotion_price")
	private float promotionPrice;

	@Column(name = "quantity")
	private int quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "version_color_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private VersionColor versionColor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_order_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private MemberOrder memberOrder;

}
