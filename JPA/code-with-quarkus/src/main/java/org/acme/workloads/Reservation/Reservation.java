package org.acme.workloads.Reservation;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.acme.workloads.Customer.Customer;
import org.acme.workloads.Employee.Employee;
import org.acme.workloads.Table_Entity.TableEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservation_id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String customer_name;

    private String telNr;

    private String start_time;

    private String end_time;

    private String reservation_date;
    private Timestamp reservation_timestamp;
    private int person_amount;

    @ManyToOne
    @JoinColumn(name = "tableno")
    private TableEntity tableEntity;

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

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

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(String reservation_date) {
        this.reservation_date = reservation_date;
    }

    public Timestamp getReservation_timestamp() {
        return reservation_timestamp;
    }

    public void setReservation_timestamp(Timestamp reservation_timestamp) {
        this.reservation_timestamp = reservation_timestamp;
    }

    public int getPerson_amount() {
        return person_amount;
    }

    public void setPerson_amount(int person_amount) {
        this.person_amount = person_amount;
    }

    public String getTelNr() {
        return telNr;
    }

    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }
}
