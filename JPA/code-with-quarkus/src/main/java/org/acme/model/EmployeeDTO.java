package org.acme.model;

import java.io.Serializable;
import java.util.Objects;

public class EmployeeDTO implements Serializable {
    private final Long employee_id;
    private final String username;
    private final String first_name;
    private final String last_name;
    private final String password;
    private final JobDTO job;

    public EmployeeDTO(Long employee_id, String username, String first_name, String last_name, String password, JobDTO job) {
        this.employee_id = employee_id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.job = job;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }

    public JobDTO getJob() {
        return job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO entity = (EmployeeDTO) o;
        return Objects.equals(this.employee_id, entity.employee_id) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.first_name, entity.first_name) &&
                Objects.equals(this.last_name, entity.last_name) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.job, entity.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, username, first_name, last_name, password, job);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "employee_id = " + employee_id + ", " +
                "username = " + username + ", " +
                "first_name = " + first_name + ", " +
                "last_name = " + last_name + ", " +
                "password = " + password + ", " +
                "job = " + job + ")";
    }
}
