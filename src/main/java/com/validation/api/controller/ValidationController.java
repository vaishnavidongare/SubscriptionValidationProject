package com.validation.api.controller;

import java.net.URISyntaxException;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.validation.api.repo.SubStatusRepo;
import com.validation.api.request.InAppPurchaseData;
import com.validation.api.request.Subscription;
import com.validation.api.request.ValidationRequest;
import com.validation.api.service.SubscriptionService;
import com.validation.api.service.ValidationService;
import com.fasterxml.jackson.core.JsonProcessingException;
@RestController
@RequestMapping("/validate-token")
public class ValidationController {
	
	@Autowired
	private ValidationService validationService;
	@Autowired 
	private SubscriptionService subscriptionService;
	
	@PostMapping
    public ResponseEntity<Object> validateEntity(@RequestBody ValidationRequest purchase) throws URISyntaxException, JsonMappingException, JsonProcessingException, ParseException {	
		InAppPurchaseData inapp=  validationService.getResponsedataFromSubUrl(purchase.getToken(),purchase.getSubscription_id());
			boolean isValid = validationService.validatePurchase(purchase,inapp.getExpirationDate());
	        if (isValid) {
	        	//create subscription based on the purchase data
	        	Subscription subscription =  subscriptionService.saveSubscription(purchase,inapp);
	            return ResponseEntity.ok(subscription);
	            
	        } else {
	            return ResponseEntity.badRequest().body("Invalid purchase.");
	        }
		}    
    }
	
	
	

