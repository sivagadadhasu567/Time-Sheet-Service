package com.hpinfosystem.repository;

import com.hpinfosystem.model.Timesheet;
import com.hpinfosystem.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
@Repository
public interface TimeSheetRepository extends ReactiveCrudRepository<Timesheet, Integer> {
	Flux<Timesheet> findByEmployeeId(Integer employeeId);

	Mono<Timesheet> findByEmployeeIdAndStartDateAndEndDateAndProject(
			Integer employeeId,
			LocalDate startDate,
			LocalDate endDate,
			String project);

	Flux<Timesheet> findByStartDateAndEndDateAndApprovedNot(
			LocalDate startDate,
			LocalDate endDate,
			String approved	);

	Flux<Timesheet> findByApprovedNot(String approved);

	Mono<Employee> findByEmployeeIdAndFirstName(Integer employeeId, String employeeName);

	Flux<Timesheet> findByEmployeeIdAndStartDateAndProject(
			Integer employeeId,
			LocalDate startDate,
			String project
	);

	Flux<Timesheet> findByProjectAndApprovedNot(String project, String approved);

	Flux<Timesheet> findByEmployeeIdAndProject(Integer employeeId, String project);

	Flux<Timesheet> findByApprovedNotAndEmployeeIdAndStartDate(
			String approved,
			Integer employeeId,
			LocalDate startDate
	);

	Flux<Timesheet> findByApprovedInAndEmployeeIdAndEmployeeNameAndProject(
			Iterable<String> approved,
			Integer employeeId,
			String employeeName,
			String project
	);

	Flux<Timesheet> findByApprovedInAndEmployeeIdAndProject(
			Iterable<String> approved,
			Integer employeeId,
			String project
	);

	Flux<Timesheet> findByApprovedInAndEmployeeIdAndEmployeeName(
			Iterable<String> approved,
			Integer employeeId,
			String employeeName
	);

	Flux<Timesheet> findByApprovedInAndProjectAndEmployeeName(
			Iterable<String> approved,
			String project,
			String employeeName
	);

	Flux<Timesheet> findByApprovedInAndEmployeeName(
			Integer approved,
			String employeeName
	);

	Flux<Timesheet> findByApprovedInAndEmployeeId(
			Iterable<String> approved,
			Integer employeeId
	);
}
