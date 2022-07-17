package com.tplnt.studentscore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(
			name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(
			name ="subject_id"
			)
	private Subject subject; 
	
//	@Column(name = "mean_score")
	private Double meanScore;
	
//	@Column(name = "median_score")
	private Double medianScore;
	
//	@Column(name = "mode_score")
	private Double modeScore;
		
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Double getMeanScore() {
		return meanScore;
	}
	
	public void setMeanScore(Double meanScore) {
		this.meanScore = meanScore;
	}
	
	public Double getMedianScore() {
		return medianScore;
	}
	
	public void setMedianScore(Double medianScore) {
		this.medianScore = medianScore;
	}
	
	public Double getModeScore() {
		return modeScore;
	}
	
	public void setModeScore(Double modeScore) {
		this.modeScore = modeScore;
	}
	
}
