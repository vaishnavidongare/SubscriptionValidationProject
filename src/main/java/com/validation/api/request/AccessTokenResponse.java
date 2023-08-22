package com.validation.api.request;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity(name = "tokenDetails")
public class AccessTokenResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer access_token_key;
	@JsonProperty(value = "access_token")
	private String access_token;
	@JsonProperty(value = "expires_in")
	private long expires_in;
	@JsonProperty(value = "token_type")
	private String token_type;
	private Instant created_At;
	private Instant expire_At;
	public Instant getExpire_At() {
		return expire_At;
	}
	public void setExpire_At(Instant expire_At) {
		this.expire_At = expire_At;
	}
	public AccessTokenResponse(Integer access_token_key, String access_token, long expires_in, String token_type,
			Instant created_At) {
		super();
		this.access_token_key = access_token_key;
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.token_type = token_type;
		this.created_At = created_At;
	}
	public Integer getAccess_token_key() {
		return access_token_key;
	}
	public void setAccess_token_key(Integer access_token_key) {
		this.access_token_key = access_token_key;
	}

	public Instant getCreated_At() {
		return created_At;
	}
	public void setCreated_At(Instant created_At) {
		this.created_At = created_At;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public AccessTokenResponse(String access_token) {
		super();
		this.access_token = access_token;
	}
	
	public AccessTokenResponse(String access_token, long expires_in, String token_type) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.token_type = token_type;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(long expiryIn) {
		this.expires_in = expiryIn;
	}

	public AccessTokenResponse() {
		// TODO Auto-generated constructor stub
	}
	
}
