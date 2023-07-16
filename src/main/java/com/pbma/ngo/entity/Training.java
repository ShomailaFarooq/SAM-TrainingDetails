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
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pbma.ngo.util.Constants;
import lombok.Data;


@Data
@Entity
@IdClass(TrainingPrimaryKey.class)
@Table(name = "training", schema = "student")
//@Table(name = "training")
public class Training {

	@Id
	@Column(name = "training_id")
	private Long trainingId;
	
	@Id
	@Column(name = "trainee_id")
	private Long traineeId;
	
    @Column(name = "course_name")
    private String courseName;
    
    @Column(name = "sector")
    private String sector;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN)
    @Column(name = "batch_start_date")
    private Date batchStartDate;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN)
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
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN)
    @Column(name = "date_of_course_passing")
    private Date dateOfCoursePassing;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN)
    @Column(name = "date_of_issuance_of_certificate")
    private Date dateOfIssuanceOfCertificate;
    
    @Column(name = "certificate_name_or_award")
    private String certificateNameOrAward;
    
    @Column(name = "grade")
    private String grade;
    
    @Column(name = "comments")
    private String comments;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.TIMESTAMP_PATTERN, timezone = Constants.TIMEZONE_ASIA)
    @Column(name = "last_update_timestamp")
    private Timestamp lastUpdateTimestamp;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.TIMESTAMP_PATTERN, timezone = Constants.TIMEZONE_ASIA)
    @Column(name = "creation_timestamp")
    private Timestamp creationTimestamp;
}
