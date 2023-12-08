package com.practice.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

import static jakarta.persistence.TemporalType.TIMESTAMP;


@Entity
@Table(name = "JOBS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class JobsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "JOBID")
    private int jobID;

    @Basic
    @Column(name = "COMPANY")
    private String company;

    @Basic
    @Column(name = "APPLIEDON")
    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date appliedon;

    @Basic
    @Column(name = "WHICHRESUME")
    private String whichResume;

    @Basic
    @Column(name = "JOBCODE")
    private String jobCode;


    @Basic
    @Column(name = "COMMENT")
    private String comment;


}
