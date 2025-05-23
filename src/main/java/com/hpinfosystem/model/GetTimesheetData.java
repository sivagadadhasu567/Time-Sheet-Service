package com.hpinfosystem.model;

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
public class GetTimesheetData {
	private Integer employeeId;
	private String employeeName;
	private List<ReturnedTimesheetData> listOfTimesheetDetails;

}
