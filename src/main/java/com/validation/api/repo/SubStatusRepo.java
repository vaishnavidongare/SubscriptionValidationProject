package com.validation.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.validation.api.request.SubStatusEntity;

import io.lettuce.core.dynamic.annotation.Param;

@Repository
@EnableJpaRepositories
public interface SubStatusRepo extends JpaRepository<SubStatusEntity, String> {

	@Query(value = "SELECT * FROM sub_status_entity s WHERE s.schedule_time < :currentTime1",nativeQuery = true)
	List<SubStatusEntity> findAllScheduleTimeBeforeCurrentTime(@Param("currentTime1") Long currentTime1);

	
}
