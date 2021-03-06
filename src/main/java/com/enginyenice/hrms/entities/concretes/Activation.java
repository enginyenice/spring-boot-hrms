package com.enginyenice.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Activations")
public class Activation {

    @Id
    @Column(name = "user_id")
    private int id;
	
	
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", nullable = true)
    private User user;
    
	@Column(name="code")
	private String code;
	
}
