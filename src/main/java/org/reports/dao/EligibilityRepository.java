package org.reports.dao;

import java.util.List;

import org.reports.bean.EligibilityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EligibilityRepository extends JpaRepository<EligibilityDetails, Integer> {

	@Query("select distinct(planName) from EligibilityDetails ")
	public List<String> findPlanNames();

	
	@Query("select planStatus from EligibilityDetails ")
	public List<String> findPlanStatus();

}
