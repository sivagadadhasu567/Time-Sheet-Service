package com.hpinfosystem.model;

public class EmployeeDTO {
    private Integer employeeId;
	private String firstName;
    private String lastName;
    private String email;

    
    public EmployeeDTO(Integer employeeId, String firstName,String lastName, String email) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void getEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + "]";
	}
}

