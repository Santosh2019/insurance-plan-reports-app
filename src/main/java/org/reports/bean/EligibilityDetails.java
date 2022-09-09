package org.reports.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ELIGIBILITY_DETAILS")
public class EligibilityDetails {
	@Id
	@Column(name = "ELIGIBILITYDTLS_NO")
	private Integer eligibilityId;

	@Column(name = "MOBILE_NUMBER")
	private Long mobileNumber;

	@Column(name = "name")
	private String name;

	@Column(name = "EMAIL_ID")
	private String emaiId;

	@Column(name = "PLAN_NAME")
	private String planName;

	@Column(name = "SSN")
	private Long ssn;

	@Column(name = "GENDER")
	private Character gender;

	@Column(name = "PLAN_STATUS")
	private String planStatus;

	@Column(name = "CREATED_DATE")
	private LocalDate createdDate;

	@Column(name = "UPDATED_DATE")
	private LocalDate updatedDate;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "START_DATE")
	private LocalDate planStartDate;

	@Column(name = "END_DATE")
	private LocalDate planEndDate;

	public Integer getEligibilityId() {
		return eligibilityId;
	}

	public void setEligibilityId(Integer eligibilityId) {
		this.eligibilityId = eligibilityId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmaiId() {
		return emaiId;
	}

	public void setEmaiId(String emaiId) {
		this.emaiId = emaiId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	@Override
	public String toString() {
		return "EligibilityDetails [eligibilityId=" + eligibilityId + ", mobileNumber=" + mobileNumber + ", name="
				+ name + ", emaiId=" + emaiId + ", planName=" + planName + ", ssn=" + ssn + ", gender=" + gender
				+ ", planStatus=" + planStatus + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", updatedBy=" + updatedBy + ", createdBy=" + createdBy + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + "]";
	}

}
