package com.enginyenice.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "minimum_salary")
    private double minimumSalary;

    @Column(name = "maximum_salary")
    private double maximumSalary;

    @Column(name="description")
    private String description;

    @Column(name="piece")
    private int piece;

    @Column(name="deadline")
    private Date deadline;


}
