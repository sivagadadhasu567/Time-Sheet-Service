package com.hpinfosystem.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReturnedTimesheetData {
	private Integer timesheetId;
	private LocalDate startDate;
	private LocalDate endDate;
	private List<WeekHours> timesheetHours;
	private Double totalHours;
	private String submitted;
	private String approved;
}
