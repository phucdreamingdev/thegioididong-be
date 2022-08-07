package vn.com.groupfive.tgdd.payload.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.com.groupfive.tgdd.utils.DeliveryStatus;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "member_order")
public class MemberOrder {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "order_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private Date orderDate;

	@Column(name = "delivery_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private Date deliveryDate;

	@Column(name = "recieve_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private Date recieveDate;
	
	@Column(name = "total_payment")
	private double totalPayment;
	
	@Column(name = "note",columnDefinition = "nvarchar(200)")
	private String note;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Branch branch;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Member member;

	@OneToMany(mappedBy = "memberOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<OrderDetail> orderDetails  = new HashSet<>();

	@Column(name = "delivery_status")
	@Enumerated(EnumType.STRING)
	private DeliveryStatus deliveryStatus;
}
