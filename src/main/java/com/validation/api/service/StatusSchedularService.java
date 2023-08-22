package com.validation.api.service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.validation.api.repo.InAppPurchaseRepo;
import com.validation.api.repo.SubStatusRepo;
import com.validation.api.repo.SubscriptionRepo;
import com.validation.api.request.InAppPurchaseData;
import com.validation.api.request.SubStatusEntity;
import com.validation.api.request.Subscription;

@Service
public class StatusSchedularService {

	@Autowired
	private SubscriptionRepo subscriptionRepo;
	@Autowired
	private ValidationService validationService;
	@Autowired
	private InAppPurchaseRepo inAppPurchaseRepo;
	@Autowired
	private SubStatusRepo subRepo;

	@Transactional           //make this method transactional
	@Scheduled(fixedRate = 60000)//schedule it for every minute
	public void updateSubscriptionStatus() throws JsonMappingException, JsonProcessingException, URISyntaxException {
		Long currentTime1 = System.currentTimeMillis();
		//filter out the records from subststusentity which have scheduletime<currenttime
		List<SubStatusEntity> filterEntity = subRepo.findAllScheduleTimeBeforeCurrentTime(currentTime1);
		for (SubStatusEntity subStatusEntity : filterEntity) {
			int count = subStatusEntity.getAttempt_no();
			if(count<20) {    //if attempt no is less than 20 then only perform expiry checking
				String subId = subStatusEntity.getSubId();
				String status = subStatusEntity.getSubStatus();
				Optional<InAppPurchaseData> inAppPurchaseData = inAppPurchaseRepo.findById(subId);
				InAppPurchaseData data = inAppPurchaseData.orElse(null);
				String purchaseToken = data.getPurchaseToken();
				//Taking the token & subId from Inapppurchasedata and call sub api
				InAppPurchaseData newdata = validationService.getResponsedataFromSubUrl(purchaseToken, subId);
				inAppPurchaseRepo.save(newdata);
				Optional<Subscription> subscription = subscriptionRepo.findById(subId);
				Subscription sub = subscription.orElse(null);
				if (newdata.isAutoRenewing()) { //chk if autorenewing is true then update the enddate in subscription table
					count++;
					if (sub != null) {
						long newExpiryDate = newdata.getExpirationDate();
						sub.setEndDate(newExpiryDate);
						status = "active";
						sub.setStatus(status);
						subscriptionRepo.save(sub);
					}
					subStatusEntity.setAttempt_no(count);
					long newDate =newdata.getExpirationDate();
					subStatusEntity.setScheduleTime(newDate-300000);//set 5 min less than expirytime as schedule time
					subStatusEntity.setSubStatus(status);
					subRepo.save(subStatusEntity);

				} else {
					// remove the record from substatusentity table if autorenewing is false
					subRepo.deleteById(subId);//mark the status as deactivate in subscription
					sub.setStatus("deactive");
					subscriptionRepo.save(sub);
				}

			//}
			}
		}
	}
}
