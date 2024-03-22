package com.dxc.scb.model;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.dxc.scb.model.Address;
import com.dxc.scb.model.Enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String username;

   
  //  @Size(min=6,max = 18, message="password lenght should be between 6 to 18 characters")
	@Column(name="password")
	private String password;
	
	@Column(name="phonenumber")
//	@Size(min = 10,message = "Phone number should be 10 digits")
	private String phoneNumber;
	
	//@Emails
	@Column(name="Email",unique=true)
	private String email;
	
//	@Column
//	@Enumerated(EnumType.STRING)
//	private Role  role;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Enums.Role role;
	
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;
    
    @OneToOne(mappedBy = "user")
    private Cart cart;

//	public String getUsername(User user1) {
//			this.username=user1.username;
//		return username;
//	}


    
}
