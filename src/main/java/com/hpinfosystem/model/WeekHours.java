package com.hpinfosystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "WeekHours")
public class WeekHours {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer weekId;
	@Column(name = "monday")
	private Double monday;
	@Column(name = "tuesday")
	private Double tuesday;
	@Column(name = "wednesday")
	private Double wednesday;
	@Column(name = "thursday")
	private Double thursday;
	@Column(name = "friday")
	private Double friday;
	@Column(name = "saturday")
	@Min(0)
	private Double saturday;
	@Column(name = "sunday")
	@Min(0)
	private Double sunday;
	
	@Override
	public String toString() {
		return "WeekHours [weekId=" + weekId + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday="
				+ wednesday + ", thursday=" + thursday + ", friday=" + friday + ", saturday=" + saturday + ", sunday="
				+ sunday + "]";
	}
	
}
