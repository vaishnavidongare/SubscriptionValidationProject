package com.validation.api.service;


import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.validation.api.repo.InAppPurchaseRepo;
import com.validation.api.repo.SubStatusRepo;
import com.validation.api.request.InAppPurchaseData;
import com.validation.api.request.SubStatusEntity;
import com.validation.api.request.ValidationRequest;

@Service
public class ValidationService {


	@Autowired
	private SubStatusRepo subRepo;
	@Autowired
	private HuaweiSubscriptionService huaweiService;
	@Autowired
	private InAppPurchaseRepo inAppPurchaseRepo;
	public void saveSubscription(String user_id) {
		// TODO Auto-generated method stub

	}
	public boolean validatePurchase(ValidationRequest validationRequest, long l) throws ParseException {
		//long timestampInMillis = Long.parseLong(l);
		long timestampInMillis=l;
		Date date = new Date(timestampInMillis);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String convertedDate = dateFormat.format(date);
		Date currentDate = new Date();
		dateFormat.format(currentDate);
		System.out.println(convertedDate);
		boolean result=true;
		if(date.before(currentDate)) {
			result = false;
		}
		else {
			result= true;
		}
		return result;
	}
	public InAppPurchaseData getResponsedataFromSubUrl(String token,String subId) throws JsonMappingException, JsonProcessingException, URISyntaxException {
		SubStatusEntity sentity = new SubStatusEntity();
			InAppPurchaseData inapp = huaweiService.validateSubscriptionInfo(token, subId);
			System.out.println(inapp);
			inAppPurchaseRepo.save(inapp);
			sentity.setSubId(inapp.getSubscriptionId());
			sentity.setScheduleTime(inapp.getExpirationDate()-300000);//set the scheduletime 5 min before the expirytime
			subRepo.save(sentity);
		return inapp;
	}
}
