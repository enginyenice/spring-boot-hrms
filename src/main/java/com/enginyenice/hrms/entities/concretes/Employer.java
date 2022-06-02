package com.enginyenice.hrms.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
public class Employer {

    @Id
    @Column(name = "user_id")
    private int id;
	
	
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    
    
	@Column(name="company_name")
	private String companyName;
	@Column(name="web_site")
	private String webSite;
	
    @Column(name="phone_number")
	private String phoneNumber;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;

}
