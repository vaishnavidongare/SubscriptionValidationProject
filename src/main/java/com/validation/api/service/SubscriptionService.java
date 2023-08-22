package com.validation.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.validation.api.repo.SubscriptionRepo;
import com.validation.api.request.InAppPurchaseData;
import com.validation.api.request.Subscription;
import com.validation.api.request.ValidationRequest;

@Service
public class SubscriptionService {

	@Autowired
	private SubscriptionRepo subscriptionRepo;

	private final CacheService cacheService;

	public SubscriptionService(SubscriptionRepo subscriptionRepo, CacheService cacheService) {
		super();
		this.subscriptionRepo = subscriptionRepo;
		this.cacheService = cacheService;

	}

	public ResponseEntity<Object> fetchSubscriptionByUserId(String userId) {
		String cacheKey = "User:" + userId;
		//first chk the record in cache
		Subscription cacheResult = (Subscription) cacheService.get(cacheKey);
		if (cacheResult != null) {
			System.out.println("Returning from cache..");
			return ResponseEntity.ok(cacheResult);
		}
		//if not in cache return from db & update the record in cache & save it for 1hour
		Subscription subscription = subscriptionRepo.findById(userId).orElse(null);
		if (subscription != null) {
			cacheService.put(cacheKey, subscription);
		}
		System.out.println("Returning from db..");
		return ResponseEntity.ok(subscription);
	}

	public Subscription saveSubscription(ValidationRequest purchase, InAppPurchaseData inapp) {
		// Save subscription to DB
		Subscription subscription = new Subscription();
		subscription.setDeviceId(purchase.getDevice_id());
		subscription.setUserId(purchase.getUser_id());
		subscription.setSignIn(purchase.getSigned_in());
		subscription.setOriginalTransactionId(purchase.getSubscription_id());
		subscription.setServiceId(purchase.getProduct_id());
		subscription.setState("ACT_INIT");
		subscription.setUserSource("Huawei");
		subscription.setServiceId(inapp.getProductId());
		subscription.setEndDate(inapp.getExpirationDate());
		subscription.setNextBillingDate(inapp.getExpirationDate());
		subscription.setMode(purchase.getMode());
		subscription.setIntroductory(inapp.isIntroductoryFlag());
		subscription.setTransactionId(inapp.getOrderId());
		subscription.setSubId(inapp.getSubscriptionId());
		System.out.println(inapp.getCountry());
		return subscriptionRepo.save(subscription);
	}


}
