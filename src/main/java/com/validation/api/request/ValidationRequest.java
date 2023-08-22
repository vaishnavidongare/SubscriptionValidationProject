package com.validation.api.request;

public class ValidationRequest {
	//@Id
	String user_id;
	String device_id;
	boolean signed_in;
	String  mode;
    String	source;
	String  token;
	String  subscription_id;
	String package_name;
	String  product_id;
	boolean renewable;
	
	public ValidationRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public boolean getSigned_in() {
		return signed_in;
	}

	public void setSigned_in(boolean signed_in) {
		this.signed_in = signed_in;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSubscription_id() {
		return subscription_id;
	}

	public void setSubscription_id(String subscription_id) {
		this.subscription_id = subscription_id;
	}

	public String getPackage_name() {
		return package_name;
	}

	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public boolean isRenewable() {
		return renewable;
	}

	public void setRenewable(boolean renewable) {
		this.renewable = renewable;
	}

	public ValidationRequest(String user_id, String device_id, boolean signed_in, String mode, String source,
			String token, String subscription_id, String package_name, String product_id, boolean renewable) {
		super();
		this.user_id = user_id;
		this.device_id = device_id;
		this.signed_in = signed_in;
		this.mode = mode;
		this.source = source;
		this.token = token;
		this.subscription_id = subscription_id;
		this.package_name = package_name;
		this.product_id = product_id;
		this.renewable = renewable;
	}

	@Override
	public String toString() {
		return "ValidationRequest [user_id=" + user_id + ", device_id=" + device_id + ", signed_in=" + signed_in
				+ ", mode=" + mode + ", source=" + source + ", token=" + token + ", subscription_id=" + subscription_id
				+ ", package_name=" + package_name + ", product_id=" + product_id + ", renewable=" + renewable + "]";
	}
	
}
