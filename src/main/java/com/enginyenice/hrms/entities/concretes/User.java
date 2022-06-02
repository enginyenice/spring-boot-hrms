package com.enginyenice.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;
@Column(name = "email")
private String email;
@Column(name= "password")
private String password;

@Column(name= "email_verification")
private boolean emailVerification;

@Column(name= "hrms_verification")
private boolean hrmsVerification; 

@Nullable
@OneToOne(mappedBy = "user")
@PrimaryKeyJoinColumn
private Candidate candidate;

@Nullable
@OneToOne(mappedBy = "user")
@PrimaryKeyJoinColumn
private Person person;

@Nullable
@OneToOne(mappedBy = "user")
@PrimaryKeyJoinColumn
private Employer employer;

@Nullable
@OneToOne(mappedBy = "user")
@PrimaryKeyJoinColumn
private Activation activation;

}
