package com.hpinfosystem.model;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class GetUnapprovedTimesheet {

	private Integer employeeId;
	private String employeeName;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double totalHours;
	private String submitted;
	private String approved;
}
