package org.acme.workloads.Customer;

import io.vertx.codegen.annotations.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "firstName")
    private String first_name;
    @Column(name = "lastName", nullable = false)
    private String last_name;
    private String email;
    @Column(name = "telephoneNumber", nullable = false)
    private String teleNr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeleNr() {
        return teleNr;
    }

    public void setTeleNr(String teleNr) {
        this.teleNr = teleNr;
    }
}
