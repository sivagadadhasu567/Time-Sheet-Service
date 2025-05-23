package com.hpinfosystem.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Transient;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetPendingTimesheet {

	private Integer employeeId;
	private String employeeName;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double totalHours;
	private String submitted;
	private String approved;
	private String uploadedTimesheets;
	private String project;
}
