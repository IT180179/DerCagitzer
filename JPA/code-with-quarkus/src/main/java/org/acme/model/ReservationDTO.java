package org.acme.model;

import org.acme.workloads.Customer.Customer;
import org.acme.workloads.Table_Entity.Table_Entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReservationDTO {


    private Customer customer;

    private List<Table_Entity> table_num = new ArrayList<>();

    private Timestamp start_time;
    private Timestamp end_time;
    private Date date;
    private Timestamp timestamp;
    private Integer person_amount;

    public ReservationDTO(Customer customer, List<Table_Entity> table_num, Timestamp start_time, Timestamp end_time, Date date, Timestamp timestamp, Integer person_amount) {
        this.customer = customer;
        this.table_num = table_num;
        this.start_time = start_time;
        this.end_time = end_time;
        this.date = date;
        this.timestamp = timestamp;
        this.person_amount = person_amount;
    }

    public ReservationDTO() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Table_Entity> getTable_num() {
        return table_num;
    }

    public void setTable_num(List<Table_Entity> table_num) {
        this.table_num = table_num;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
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
