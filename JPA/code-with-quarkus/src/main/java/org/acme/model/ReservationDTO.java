package org.acme.model;

import org.acme.workloads.Customer.Customer;
import org.acme.workloads.Employee.Employee;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class ReservationDTO implements Serializable {
    private final Long reservation_id;
    private final Employee employee;
    private final Customer customer;
    private final Integer time;
    private final Date date;
    private final Timestamp timestamp;
    private final Integer person_amount;
    private final List<TableEntityDTO> table_Entities;

    public ReservationDTO(Long reservation_id, Employee employee, Customer customer, Integer time, Date date, Timestamp timestamp, Integer person_amount, List<TableEntityDTO> table_Entities) {
        this.reservation_id = reservation_id;
        this.employee = employee;
        this.customer = customer;
        this.time = time;
        this.date = date;
        this.timestamp = timestamp;
        this.person_amount = person_amount;
        this.table_Entities = table_Entities;
    }

    public Long getReservation_id() {
        return reservation_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Integer getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Integer getPerson_amount() {
        return person_amount;
    }

    public List<TableEntityDTO> getTable_Entities() {
        return table_Entities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservationDTO)) return false;
        ReservationDTO that = (ReservationDTO) o;
        return Objects.equals(getReservation_id(), that.getReservation_id()) && Objects.equals(getEmployee(), that.getEmployee()) && Objects.equals(getCustomer(), that.getCustomer()) && Objects.equals(getTime(), that.getTime()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getTimestamp(), that.getTimestamp()) && Objects.equals(getPerson_amount(), that.getPerson_amount()) && Objects.equals(getTable_Entities(), that.getTable_Entities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReservation_id(), getEmployee(), getCustomer(), getTime(), getDate(), getTimestamp(), getPerson_amount(), getTable_Entities());
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "reservation_id=" + reservation_id +
                ", employee=" + employee +
                ", customer=" + customer +
                ", time=" + time +
                ", date=" + date +
                ", timestamp=" + timestamp +
                ", person_amount=" + person_amount +
                ", table_Entities=" + table_Entities +
                '}';
    }
}
