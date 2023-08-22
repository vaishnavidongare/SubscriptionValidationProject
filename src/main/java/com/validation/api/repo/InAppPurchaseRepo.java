package com.validation.api.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.validation.api.request.InAppPurchaseData;
@Repository
public interface InAppPurchaseRepo extends JpaRepository<InAppPurchaseData, String> {

	Optional<InAppPurchaseData> findById(String anyLong);

}
