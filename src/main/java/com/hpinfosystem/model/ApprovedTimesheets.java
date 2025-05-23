package com.hpinfosystem.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "approved_timesheets")
public class ApprovedTimesheets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer timesheetId;
	@Column(name = "employeeId")
	private Integer employeeId;
	@Column(name = "approvalStatus")
	private String approvalStatus;
	@Column(name = "totalHours")
	private Double totalHours;
	@Column(name = "weekNumber")
	private Integer weekNumber;
	@Column(name = "path")
	private String path;
	@Column(name = "startDate")
	private LocalDate startDate;
	@Column(name = "project")
	private String project;
}
