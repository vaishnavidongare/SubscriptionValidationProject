package com.validation.api.request;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "subscription")
public class Subscription {
	@Id
	private String subId;
	private String userId;
	private String deviceId;
	private boolean signIn;
	private String originalTransactionId;
	private String transactionId;
	private String serviceId;
	private long endDate;
	private long nextBillingDate;
	private String state;
	private String userSource;
	private String mode;
	private String ubsId;
	private boolean introductory;
	private boolean freetrial;
	private boolean paid;
	public String getSubId() {
		return subId;
	}
	public void setSubId(String subId) {
		this.subId = subId;
	}
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Subscription() {
		// TODO Auto-generated constructor stub
	}
	public Subscription(String userId, String deviceId, boolean signIn, String originalTransactionId,
			String transactionId, String serviceId, long endDate, long nextBillingDate, String state,
			String userSource, String mode, String ubsId, boolean introductory, boolean freetrial, boolean paid) {
		super();
		this.userId = userId;
		this.deviceId = deviceId;
		this.signIn = signIn;
		this.originalTransactionId = originalTransactionId;
		this.transactionId = transactionId;
		this.serviceId = serviceId;
		this.endDate = endDate;
		this.nextBillingDate = nextBillingDate;
		this.state = state;
		this.userSource = userSource;
		this.mode = mode;
		this.ubsId = ubsId;
		this.introductory = introductory;
		this.freetrial = freetrial;
		this.paid = paid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public boolean isSignIn() {
		return signIn;
	}
	public void setSignIn(boolean signIn) {
		this.signIn = signIn;
	}
	public String getOriginalTransactionId() {
		return originalTransactionId;
	}
	public void setOriginalTransactionId(String originalTransactionId) {
		this.originalTransactionId = originalTransactionId;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public long getEndDate() {
		return endDate;
	}
	public void setEndDate(long enddate) {
		this.endDate = enddate;
	}
	public long getNextBillingDate() {
		return nextBillingDate;
	}
	public void setNextBillingDate(long l) {
		this.nextBillingDate = l;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUserSource() {
		return userSource;
	}
	public void setUserSource(String userSource) {
		this.userSource = userSource;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getUbsId() {
		return ubsId;
	}
	public void setUbsId(String ubsId) {
		this.ubsId = ubsId;
	}
	public boolean isIntroductory() {
		return introductory;
	}
	public void setIntroductory(boolean introductory) {
		this.introductory = introductory;
	}
	public boolean isFreetrial() {
		return freetrial;
	}
	public void setFreetrial(boolean freetrial) {
		this.freetrial = freetrial;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	
	
}
