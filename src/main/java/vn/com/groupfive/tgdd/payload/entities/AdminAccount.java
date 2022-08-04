package vn.com.groupfive.tgdd.payload.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "admin_account")
public class AdminAccount implements Serializable{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fullname", columnDefinition = "nvarchar(100)")
	private String fullName;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;
}
