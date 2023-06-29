package com.pbma.ngo.entity;

import java.sql.Date;
import java.sql.Timestamp;


// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "training", schema = "student")
//@Table(name = "training")
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "training_id")
	private Long trainingId;
	
	//foreignkey
	@Column(name = "trainee_id")
	private Long traineeId;
	
    @Column(name = "course_name")
    private String courseName;
    
    @Column(name = "sector")
    private String sector;
    
    @Column(name = "batch_start_date")
    private Date batchStartDate;
    
    @Column(name = "batch_end_date")
    private Date batchEndDate;
    
    @Column(name = "industry_visit_completed")
    private String industryVisitCompleted;
      
	@Column(name = "ojt_completed")
    private String ojtCompleted;
    
	@Column(name = "training_status")
    private String trainingStatus;

    @Column(name = "attendence_percentage")
    private float  attendencePercentage;
    
    @Column(name = "assessment_conducted")
    private String assessmentConducted;
    
    @Column(name = "certified")
    private String certified;
    
    @Column(name = "date_of_course_passing")
    private Date dateOfCoursePassing;
    
    @Column(name = "date_of_issuance_of_certificate")
    private Date dateOfIssuanceOfCertificate;
    
    @Column(name = "certificate_name_or_award")
    private String certificateNameOrAward;
    
    @Column(name = "grade")
    private String grade;
    
    @Column(name = "comments")
    private String comments;
    
    @Column(name = "last_update_timestamp")
    private Timestamp lastUpdateTimestamp;

    @Column(name = "creation_timestamp")
    private Timestamp creationTimestamp;
}
