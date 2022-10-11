package org.acme.workloads.Reservation;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.acme.workloads.Customer.Customer;
import org.acme.workloads.Employee.Employee;
import org.acme.workloads.Table_Entity.TableEntity;

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

    private Integer reservation_time;

    private String reservation_date;
    private Timestamp reservation_timestamp;
    private Integer person_amount;

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

    public Integer getReservation_time() {
        return reservation_time;
    }

    public void setReservation_time(Integer reservation_time) {
        this.reservation_time = reservation_time;
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

    public Integer getPerson_amount() {
        return person_amount;
    }

    public void setPerson_amount(Integer person_amount) {
        this.person_amount = person_amount;
    }


}
