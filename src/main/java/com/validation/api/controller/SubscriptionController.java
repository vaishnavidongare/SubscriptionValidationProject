package com.validation.api.controller;

import javax.persistence.Cacheable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.validation.api.service.SubscriptionService;
import com.validation.api.service.ValidationService;

@RestController
@RequestMapping("/api/subcription/get")
@Cacheable
public class SubscriptionController {
	@Autowired
	private SubscriptionService subscriptionService;
	@Autowired
	private ValidationService validationService;

	@GetMapping("/{userId}")
	public ResponseEntity<Object> getSubscriptionByUserId(@PathVariable("userId") String userId) {
		ResponseEntity<Object> response = subscriptionService.fetchSubscriptionByUserId(userId);
        
		return response;
	}

}
