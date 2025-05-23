package com.hpinfosystem.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovedTimesheetsDTO {
	
	private Integer employeeId;
	private String employeeName;
	private String project;
	private String approvalStatus;
	private Double totalHours;
	private Integer weekNumber;
	private LocalDate startDate;
	private String path;	

}
