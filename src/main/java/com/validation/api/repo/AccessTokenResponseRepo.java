package com.validation.api.repo;

import java.time.Instant;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.validation.api.request.AccessTokenResponse;

@Repository
public interface AccessTokenResponseRepo extends JpaRepository<AccessTokenResponse, Integer>{


}
