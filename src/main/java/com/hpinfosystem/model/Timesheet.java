package com.hpinfosystem.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "TimesheetData")
public class Timesheet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer timesheetId;
	@Column(name = "employeeId")
	private Integer employeeId;
	@Column(name = "employeeName")
	private String employeeName;
	@Column(name = "startDate")
	private LocalDate startDate;
	@Column(name = "endDate")
	private LocalDate endDate;
	@Column(name = "timesheetHours")
	@OneToMany(targetEntity = WeekHours.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "timesheet_workhours_fk", referencedColumnName = "timesheetId")
	private List<WeekHours> timesheetHours;
	@Column(name = "totalHours")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private Double totalHours;
	@Column(name = "submitted")
	private String submitted;
	@Column(name = "approved")
	private String approved;
	@Column(name = "project")
	private String project;
	
	public Double getTotalHours() {
		return timesheetHours.stream()
                .mapToDouble(weekHours -> 
                    (weekHours.getMonday() != null ? weekHours.getMonday() : 0.00) +
                    (weekHours.getTuesday() != null ? weekHours.getTuesday() : 0.00) +
                    (weekHours.getWednesday() != null ? weekHours.getWednesday() : 0.00) +
                    (weekHours.getThursday() != null ? weekHours.getThursday() : 0.00) +
                    (weekHours.getFriday() != null ? weekHours.getFriday() : 0.00) +
                    (weekHours.getSaturday() != null ? weekHours.getSaturday() : 0.00) +
                    (weekHours.getSunday() != null ? weekHours.getSunday() : 0.00))
                .sum();
    }
	public void setTotalHours() {
		this.totalHours = timesheetHours.stream()
                .mapToDouble(weekHours -> 
                    (weekHours.getMonday() != null ? weekHours.getMonday() : 0.00) +
                    (weekHours.getTuesday() != null ? weekHours.getTuesday() : 0.00) +
                    (weekHours.getWednesday() != null ? weekHours.getWednesday() : 0.00) +
                    (weekHours.getThursday() != null ? weekHours.getThursday() : 0.00) +
                    (weekHours.getFriday() != null ? weekHours.getFriday() : 0.00) +
                    (weekHours.getSaturday() != null ? weekHours.getSaturday() : 0.00) +
                    (weekHours.getSunday() != null ? weekHours.getSunday() : 0.00))
                .sum();
	}
	@Override
	public String toString() {
		return "Timesheet [timesheetId=" + timesheetId + ", employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", timesheetHours=" + timesheetHours
				+ ", totalHours=" + totalHours + ", submitted=" + submitted + ", approved=" + approved + ", project="
				+ project + "]";
	}
}
