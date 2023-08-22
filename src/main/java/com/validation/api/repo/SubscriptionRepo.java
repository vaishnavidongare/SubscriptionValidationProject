package com.validation.api.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.validation.api.request.Subscription;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription,String > {

	static Optional<Subscription> findByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	void save(Optional<Subscription> subscription);

}
