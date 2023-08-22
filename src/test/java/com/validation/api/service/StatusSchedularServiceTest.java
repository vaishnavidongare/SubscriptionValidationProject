package com.validation.api.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.ArgumentMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.validation.api.repo.InAppPurchaseRepo;
import com.validation.api.repo.SubStatusRepo;
import com.validation.api.repo.SubscriptionRepo;
import com.validation.api.request.InAppPurchaseData;
import com.validation.api.request.SubStatusEntity;
import com.validation.api.request.Subscription;

@ExtendWith(MockitoExtension.class)
public class StatusSchedularServiceTest {
	@InjectMocks
	private StatusSchedularService statusSchedularService;
	
	@Mock
	private SubStatusRepo subStatusRepo;
	
	@Mock
	private SubscriptionRepo subscriptionRepo;
	
	@Mock
	private ValidationService validationService;
	
	@Mock
	private InAppPurchaseRepo inAppPurchaseRepo;
	
	@Test
	public void testupdateSubscriptionStatus() throws JsonMappingException, JsonProcessingException, URISyntaxException {
		//creating mock object data
		SubStatusEntity subStatusEntity = new SubStatusEntity("1682575215117.68FA99C8.2792", 0, null, 1693202167327L);
		InAppPurchaseData inAppPurchaseData = new InAppPurchaseData(true, true, "1687932067328.761DD9FB.2792", "1685080833095.B475C54A.2792", "com.vuclip.viu", 101167366, "101167366","viuHuaweiZAmonthly29", 2, "Viu Huawei ZA monthly 29", "F24ECC004CD34F37AD0192119B34B863", 1690524067327L, 1682575233078L, false, "00000187c14c4a0d59714702a6f4ec89cbacebd8f21ca626c437e4b1ae6f78a78ffa6e383ababe38x5a41.5.2792", "ZAR", 2900, "ZA", "1682575215117.68FA99C8.2792", 1, 90, 4, 0, 1693202467327L, 0, true, false, false, true, 0, 30, "Ad2023072714012101309C65F92", "34", true, "1");
	    Subscription subscription=new Subscription("u-12345678kpm67890", "d-12345678kpm67890", true, "1682575215117.68FA99C8.2792", "1687932067328.761DD9FB.2792", "viuHuaweiZAmonthly29", 1693202467327L, 1693202467327L, "ACT_INIT", "Huawei", "ANDROID_APP", null, false, false, false);
	    //configure mock behavior 
	    when(subStatusRepo.findAllScheduleTimeBeforeCurrentTime(ArgumentMatchers.anyLong())).thenReturn(Collections.singletonList(subStatusEntity));
	    when(inAppPurchaseRepo.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(inAppPurchaseData));
	    when(validationService.getResponsedataFromSubUrl(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(inAppPurchaseData);
	    when(subscriptionRepo.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(subscription));
	    
	    try {
	    	statusSchedularService.updateSubscriptionStatus();  //call method to test
	    }catch (Exception e) {
			
		}
	    //verify the result
	    verify(subStatusRepo,times(1)).deleteById(ArgumentMatchers.anyString());
	    verify(subStatusRepo,times(1)).save(ArgumentMatchers.any(SubStatusEntity.class));
	    verify(subscriptionRepo,times(1)).save(ArgumentMatchers.any(Subscription.class));
	
	}
}
