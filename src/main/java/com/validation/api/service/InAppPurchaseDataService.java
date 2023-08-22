package com.validation.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validation.api.repo.InAppPurchaseRepo;
import com.validation.api.request.InAppPurchaseData;

@Service
public class InAppPurchaseDataService {

	@Autowired
	private InAppPurchaseRepo inAppPurchaseRepo;
	
	public List<InAppPurchaseData> getAllInAppResponse() {
		List<InAppPurchaseData> data = inAppPurchaseRepo.findAll();
		return data; 
		
	}
}
