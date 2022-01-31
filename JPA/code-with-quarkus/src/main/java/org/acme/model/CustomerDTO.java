package org.acme.model;

import java.io.Serializable;
import java.util.Objects;

public class CustomerDTO implements Serializable {
    private final Long customer_id;
    private final String first_name;
    private final String last_name;
    private final String email;
    private final String password;
    private final String telNr;

    public CustomerDTO(Long customer_id, String first_name, String last_name, String email, String password, String telNr) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.telNr = telNr;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTelNr() {
        return telNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO entity = (CustomerDTO) o;
        return Objects.equals(this.customer_id, entity.customer_id) &&
                Objects.equals(this.first_name, entity.first_name) &&
                Objects.equals(this.last_name, entity.last_name) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.telNr, entity.telNr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_id, first_name, last_name, email, password, telNr);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "customer_id = " + customer_id + ", " +
                "first_name = " + first_name + ", " +
                "last_name = " + last_name + ", " +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "telNr = " + telNr + ")";
    }
}
