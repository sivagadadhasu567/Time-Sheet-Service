package com.hpinfosystem.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ProjectDetails {
	@Id
	private Integer projectId;
    private Integer employeeId;
    private String projectName;
    private String BillingRate;
    private String PayRate;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;
    private String invoicingEmail;
    private Integer billingCycle;
}
