package com.enginyenice.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates")
public class Candidate {
	

    @Id
    @Column(name = "user_id")
    private int id;
	
	
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    
    
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_number")
	private String nationalityNumber;
	
	@Column(name="year_of_birth")
	private int yearOfBirth;
	
}
