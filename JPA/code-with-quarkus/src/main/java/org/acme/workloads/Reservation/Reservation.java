package org.acme.workloads.Reservation;

import org.acme.workloads.Customer.Customer;
import org.acme.workloads.Employee.Employee;
import org.acme.workloads.Table_Entity.TableEntity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservation_id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Integer time;
    private Date date;
    private Timestamp timestamp;
    private Integer person_amount;

    @ManyToOne
    @JoinColumn(name = "tableno")
    private TableEntity tableEntity;

    public TableEntity getTableEntity() {
        return tableEntity;
    }

    public void setTableEntity(TableEntity tableEntity) {
        this.tableEntity = tableEntity;
    }

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getPerson_amount() {
        return person_amount;
    }

    public void setPerson_amount(Integer person_amount) {
        this.person_amount = person_amount;
    }


}
