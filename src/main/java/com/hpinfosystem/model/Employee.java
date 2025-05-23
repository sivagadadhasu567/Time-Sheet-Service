package com.hpinfosystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee{

    @Id
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String SSN;
    private String visaStatus;
    private String email;
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", SSN="
				+ SSN + ", visaStatus=" + visaStatus + ", email="
				+ email + "]";
	}
}