package com.hpinfosystem.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hpinfosystem.model.ApprovedTimesheets;

@Repository
public interface ApprovedTimesheetRepository extends JpaRepository<ApprovedTimesheets,Integer>{

	@Query("SELECT t FROM ApprovedTimesheets t WHERE t.employeeId = :employeeId AND t.startDate = :startDate AND t.project = :project ")
	ApprovedTimesheets findPathAndWeekNumberByIdStartDateAndProject(Integer employeeId, LocalDate startDate, String project);

}
