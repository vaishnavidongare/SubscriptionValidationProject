package com.validation.api.request;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class InAppPurchaseData {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer app_id;
//	public Integer getApp_id() {
//		return app_id;
//	}
//
//	public void setApp_id(Integer app_id) {
//		this.app_id = app_id;
//	}
	@Id
	private String subscriptionId;

	private boolean autoRenewing;

	private boolean subIsvalid;

	private String orderId;

	private String lastOrderId;

	private String packageName;

//	private BigInteger applicationId;
	private long applicationId;

	private String applicationIdString;

	private String productId;

	private int kind;

	private String productName;

	private String productGroup;

	private long purchaseTime;

	private long oriPurchaseTime;

	private boolean purchaseState;

	private String purchaseToken;

	private String currency;

	private long price;

	private String country;

	
	private int quantity;

	private int daysLasted;

	private int numOfPeriods;

	private int numOfDiscount;

	private long expirationDate;

	private int expirationIntent;

	private boolean retryFlag;

	private boolean introductoryFlag;

	private boolean trialFlag;

	private boolean renewStatus;

	private long renewPrice;

	private int cancelledSubKeepDays;

	private String payOrderId;

	private String payType;

	private boolean confirmed;

	private String sdkChannel;

	public InAppPurchaseData() {
		// TODO Auto-generated constructor stub
	}

	public boolean isAutoRenewing() {
		return autoRenewing;
	}

	public void setAutoRenewing(boolean autoRenewing) {
		this.autoRenewing = autoRenewing;
	}

	public boolean isSubIsvalid() {
		return subIsvalid;
	}

	public void setSubIsvalid(boolean subIsvalid) {
		this.subIsvalid = subIsvalid;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getLastOrderId() {
		return lastOrderId;
	}

	public void setLastOrderId(String lastOrderId) {
		this.lastOrderId = lastOrderId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationIdString() {
		return applicationIdString;
	}

	public void setApplicationIdString(String applicationIdString) {
		this.applicationIdString = applicationIdString;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public long getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(long purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public long getOriPurchaseTime() {
		return oriPurchaseTime;
	}

	public void setOriPurchaseTime(long oriPurchaseTime) {
		this.oriPurchaseTime = oriPurchaseTime;
	}

	public boolean isPurchaseState() {
		return purchaseState;
	}

	public void setPurchaseState(boolean purchaseState) {
		this.purchaseState = purchaseState;
	}

	public String getPurchaseToken() {
		return purchaseToken;
	}

	public void setPurchaseToken(String purchaseToken) {
		this.purchaseToken = purchaseToken;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDaysLasted() {
		return daysLasted;
	}

	public void setDaysLasted(int daysLasted) {
		this.daysLasted = daysLasted;
	}

	public int getNumOfPeriods() {
		return numOfPeriods;
	}

	public void setNumOfPeriods(int numOfPeriods) {
		this.numOfPeriods = numOfPeriods;
	}

	public int getNumOfDiscount() {
		return numOfDiscount;
	}

	public void setNumOfDiscount(int numOfDiscount) {
		this.numOfDiscount = numOfDiscount;
	}

	public long getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(long expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getExpirationIntent() {
		return expirationIntent;
	}

	public void setExpirationIntent(int expirationIntent) {
		this.expirationIntent = expirationIntent;
	}

	public boolean isRetryFlag() {
		return retryFlag;
	}

	public void setRetryFlag(boolean retryFlag) {
		this.retryFlag = retryFlag;
	}

	public boolean isIntroductoryFlag() {
		return introductoryFlag;
	}

	public void setIntroductoryFlag(boolean introductoryFlag) {
		this.introductoryFlag = introductoryFlag;
	}

	public boolean isTrialFlag() {
		return trialFlag;
	}

	public void setTrialFlag(boolean trialFlag) {
		this.trialFlag = trialFlag;
	}

	public boolean isRenewStatus() {
		return renewStatus;
	}

	public void setRenewStatus(boolean renewStatus) {
		this.renewStatus = renewStatus;
	}

	public long getRenewPrice() {
		return renewPrice;
	}

	public void setRenewPrice(long renewPrice) {
		this.renewPrice = renewPrice;
	}

	public int getCancelledSubKeepDays() {
		return cancelledSubKeepDays;
	}

	public void setCancelledSubKeepDays(int cancelledSubKeepDays) {
		this.cancelledSubKeepDays = cancelledSubKeepDays;
	}

	public String getPayOrderId() {
		return payOrderId;
	}

	public void setPayOrderId(String payOrderId) {
		this.payOrderId = payOrderId;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public String getSdkChannel() {
		return sdkChannel;
	}

	public void setSdkChannel(String sdkChannel) {
		this.sdkChannel = sdkChannel;
	}

	public InAppPurchaseData(boolean autoRenewing, boolean subIsvalid, String orderId, String lastOrderId,
			String packageName, long applicationId, String applicationIdString, String productId, int kind,
			String productName, String productGroup, long purchaseTime, long oriPurchaseTime, boolean purchaseState,
			String purchaseToken, String currency, long price, String country, String subscriptionId, int quantity,
			int daysLasted, int numOfPeriods, int numOfDiscount, long expirationDate, int expirationIntent,
			boolean retryFlag, boolean introductoryFlag, boolean trialFlag, boolean renewStatus, long renewPrice,
			int cancelledSubKeepDays, String payOrderId, String payType, boolean confirmed, String sdkChannel) {
		super();
		this.autoRenewing = autoRenewing;
		this.subIsvalid = subIsvalid;
		this.orderId = orderId;
		this.lastOrderId = lastOrderId;
		this.packageName = packageName;
		this.applicationId = applicationId;
		this.applicationIdString = applicationIdString;
		this.productId = productId;
		this.kind = kind;
		this.productName = productName;
		this.productGroup = productGroup;
		this.purchaseTime = purchaseTime;
		this.oriPurchaseTime = oriPurchaseTime;
		this.purchaseState = purchaseState;
		this.purchaseToken = purchaseToken;
		this.currency = currency;
		this.price = price;
		this.country = country;
		this.subscriptionId = subscriptionId;
		this.quantity = quantity;
		this.daysLasted = daysLasted;
		this.numOfPeriods = numOfPeriods;
		this.numOfDiscount = numOfDiscount;
		this.expirationDate = expirationDate;
		this.expirationIntent = expirationIntent;
		this.retryFlag = retryFlag;
		this.introductoryFlag = introductoryFlag;
		this.trialFlag = trialFlag;
		this.renewStatus = renewStatus;
		this.renewPrice = renewPrice;
		this.cancelledSubKeepDays = cancelledSubKeepDays;
		this.payOrderId = payOrderId;
		this.payType = payType;
		this.confirmed = confirmed;
		this.sdkChannel = sdkChannel;
	}

	
	@Override
	public String toString() {
		return "InAppPurchaseData [autoRenewing=" + autoRenewing + ", subIsvalid=" + subIsvalid + ", orderId=" + orderId
				+ ", lastOrderId=" + lastOrderId + ", packageName=" + packageName + ", applicationId=" + applicationId
				+ ", applicationIdString=" + applicationIdString + ", productId=" + productId + ", kind=" + kind
				+ ", productName=" + productName + ", productGroup=" + productGroup + ", purchaseTime=" + purchaseTime
				+ ", oriPurchaseTime=" + oriPurchaseTime + ", purchaseState=" + purchaseState + ", purchaseToken="
				+ purchaseToken + ", currency=" + currency + ", price=" + price + ", country=" + country
				+ ", subscriptionId=" + subscriptionId + ", quantity=" + quantity + ", daysLasted=" + daysLasted
				+ ", numOfPeriods=" + numOfPeriods + ", numOfDiscount=" + numOfDiscount + ", expirationDate="
				+ expirationDate + ", expirationIntent=" + expirationIntent + ", retryFlag=" + retryFlag
				+ ", introductoryFlag=" + introductoryFlag + ", trialFlag=" + trialFlag + ", renewStatus=" + renewStatus
				+ ", renewPrice=" + renewPrice + ", cancelledSubKeepDays=" + cancelledSubKeepDays + ", payOrderId="
				+ payOrderId + ", payType=" + payType + ", confirmed=" + confirmed + ", sdkChannel=" + sdkChannel + "]";
	}

}
