package com.validation.api.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.Base64;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.validation.api.repo.AccessTokenResponseRepo;
import com.validation.api.request.AccessTokenResponse;
import com.validation.api.request.InAppPurchaseData;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class HuaweiSubscriptionService {
	@Autowired
	private AccessTokenResponseRepo accessTokenResponseRepo;
	public String huaweiToken;
	@Autowired
	private RestTemplate restTemplate;

	@Value("${huawei.sub.api.url}")
	private String apiUrl;

	@Value("${huawei.token.url}")
	private String tokenurl;

	@Value("${huawei.client_id}")
	private String clientId;
	@Value("${huawei.client_secret}")
	private String clientSecret;
	@Value("${huawei.grant_type}")
	private String grant_type;
	private final ObjectMapper objectMapper = new ObjectMapper();

	Logger logger = LoggerFactory.getLogger(HuaweiSubscriptionService.class);
	int count1 = 0, count2 = 0;

	public String generateAccessToken() throws URISyntaxException {
		//find existing token & check if it is expired or not
		AccessTokenResponse accessTokenResponse = accessTokenResponseRepo.findById(1).orElse(null);
		if (accessTokenResponse != null) {
			Instant expireAt = accessTokenResponse.getExpire_At();
			Instant currentTime = Instant.now();
			if (expireAt != null && currentTime.isAfter(expireAt)) {
				this.huaweiToken = generateNewToken();
			} else {
				this.huaweiToken = accessTokenResponse.getAccess_token();
			}
		} else {
			this.huaweiToken = generateNewToken();
		}
		return huaweiToken;
	}

	//To generate new token
	private String generateNewToken() throws URISyntaxException {
		AccessTokenResponse responseEntity = refreshHuaweiToken(); // Call huawei token generating api
		String accesstoken = responseEntity.getAccess_token();
		String token_type = responseEntity.getToken_type();
		long expiryIn = responseEntity.getExpires_in();
		String toEncode = "APPAT:" + accesstoken; // append APPAT to token received from huawei api
		String encodedString = Base64.getEncoder().encodeToString(toEncode.getBytes()); // encode token to base 64
																						// format
		// find existing token & update that token
		AccessTokenResponse accessTokenResponse = accessTokenResponseRepo.findById(1).orElse(new AccessTokenResponse());
		accessTokenResponse.setAccess_token_key(1);
		accessTokenResponse.setExpires_in(expiryIn);
		accessTokenResponse.setToken_type(token_type);
		accessTokenResponse.setAccess_token(encodedString);
		accessTokenResponse.setCreated_At(Instant.now());
		accessTokenResponse.setExpire_At(Instant.now().plusSeconds(3300));
		accessTokenResponseRepo.save(accessTokenResponse);

		this.huaweiToken = encodedString;
		return huaweiToken;

	}

	//call huawei subscription api
	@Retry(name = "retryApi")
	public InAppPurchaseData validateSubscriptionInfo(String token, String subId)
			throws URISyntaxException, JsonMappingException, JsonProcessingException {
		String accessToken = generateAccessToken();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Basic " + accessToken);// headers.set("Authorization", "Basic " + accessToken);
		JSONObject requestBodyJson = new JSONObject();
		requestBodyJson.put("purchaseToken", token);
		requestBodyJson.put("subscriptionId", subId);
		String requestBody = requestBodyJson.toString();
		System.out.println(requestBody);
		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
		// error handling to be done
		logger.info(++count1 + "calling subscription api");
		ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
		String jsonResponse = response.getBody();
		JsonNode jsonNode = objectMapper.readTree(jsonResponse);
		String dataNode = jsonNode.get("inappPurchaseData").asText();
		InAppPurchaseData inapp = objectMapper.readValue(dataNode, InAppPurchaseData.class);
		return inapp;
	}

	//call huawei token api
	@Retry(name = "retryApi")
	public AccessTokenResponse refreshHuaweiToken() throws URISyntaxException {
		logger.info(++count2 + "calling huaweitoken api");
		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		String requestBody = "grant_type=" + grant_type + "&client_id=" + clientId + "&client_secret=" + clientSecret;
		RequestEntity<String> requestEntity = new RequestEntity<>(requestBody, httpHeaders, HttpMethod.POST,
				new URI(tokenurl));
		AccessTokenResponse responseEntity = restTemplate
				.exchange(tokenurl, HttpMethod.POST, requestEntity, AccessTokenResponse.class).getBody();
		return responseEntity;
	}
}
