package org.acme.workloads.Customer;

import io.vertx.codegen.annotations.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String first_name;
    @Nullable()
    private String last_name;
    private

}
