package com.enginyenice.hrms.entities.concretes;

import javax.persistence.*;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
