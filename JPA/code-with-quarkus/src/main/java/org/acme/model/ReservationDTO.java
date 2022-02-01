package org.acme.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class ReservationDTO implements Serializable {
    private final Long reservation_id;
    private final EmployeeDTO employee;
    private final CustomerDTO customer;
    private final Timestamp start_time;
    private final Timestamp end_time;
    private final Date date;
    private final Timestamp timestamp;
    private final Integer person_amount;
    private final List<TableEntityDTO> table_Entities;

    public ReservationDTO(Long reservation_id, EmployeeDTO employee, CustomerDTO customer, Timestamp start_time, Timestamp end_time, Date date, Timestamp timestamp, Integer person_amount, List<TableEntityDTO> table_Entities) {
        this.reservation_id = reservation_id;
        this.employee = employee;
        this.customer = customer;
        this.start_time = start_time;
        this.end_time = end_time;
        this.date = date;
        this.timestamp = timestamp;
        this.person_amount = person_amount;
        this.table_Entities = table_Entities;
    }

    public Long getReservation_id() {
        return reservation_id;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
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
        if (o == null || getClass() != o.getClass()) return false;
        ReservationDTO entity = (ReservationDTO) o;
        return Objects.equals(this.reservation_id, entity.reservation_id) &&
                Objects.equals(this.employee, entity.employee) &&
                Objects.equals(this.customer, entity.customer) &&
                Objects.equals(this.start_time, entity.start_time) &&
                Objects.equals(this.end_time, entity.end_time) &&
                Objects.equals(this.date, entity.date) &&
                Objects.equals(this.timestamp, entity.timestamp) &&
                Objects.equals(this.person_amount, entity.person_amount) &&
                Objects.equals(this.table_Entities, entity.table_Entities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservation_id, employee, customer, start_time, end_time, date, timestamp, person_amount, table_Entities);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "reservation_id = " + reservation_id + ", " +
                "employee = " + employee + ", " +
                "customer = " + customer + ", " +
                "start_time = " + start_time + ", " +
                "end_time = " + end_time + ", " +
                "date = " + date + ", " +
                "timestamp = " + timestamp + ", " +
                "person_amount = " + person_amount + ", " +
                "table_Entities = " + table_Entities + ")";
    }
}
