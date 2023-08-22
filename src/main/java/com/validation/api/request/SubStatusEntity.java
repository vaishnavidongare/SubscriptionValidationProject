package com.validation.api.request;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubStatusEntity {
	@Id
	private String subId;
	private int attempt_no;
	private String subStatus;
	private long scheduleTime;
	public SubStatusEntity() {
		// TODO Auto-generated constructor stub
	}
	public String getSubId() {
		return subId;
	}
	public void setSubId(String subId) {
		this.subId = subId;
	}
	
	public int getAttempt_no() {
		return attempt_no;
	}
	public void setAttempt_no(int attempt_no) {
		this.attempt_no = attempt_no;
	}
	public long getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(long scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public String getSubStatus() {
		return subStatus;
	}
	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}
	public SubStatusEntity(String subId, int attempt_no, String subStatus, long scheduleTime) {
		super();
		this.subId = subId;
		this.attempt_no = attempt_no;
		this.subStatus = subStatus;
		this.scheduleTime = scheduleTime;
	}
	
	
}
