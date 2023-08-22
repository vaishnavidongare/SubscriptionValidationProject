package com.validation.api.request;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {

	private String responseCode;
	private InAppPurchaseData inappPurchaseData;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public InAppPurchaseData getInappdata() {
		return inappPurchaseData;
	}

	public void setInappdata(InAppPurchaseData inappPurchaseData) {
		this.inappPurchaseData = inappPurchaseData;
	}

	public ApiResponse() {
		// TODO Auto-generated constructor stub
	}

	public ApiResponse(String responseCode, InAppPurchaseData inappPurchaseData) {
		super();
		this.responseCode = responseCode;
		this.inappPurchaseData = inappPurchaseData;
	}

	@Override
	public String toString() {
		return "ApiResponse [responseCode=" + responseCode + ", inappPurchaseData=" + inappPurchaseData + "]";
	}
}
