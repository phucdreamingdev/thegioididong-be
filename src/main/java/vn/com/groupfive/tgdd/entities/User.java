package vn.com.groupfive.tgdd.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;
	
}
