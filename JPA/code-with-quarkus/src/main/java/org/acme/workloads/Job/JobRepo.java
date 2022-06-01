package org.acme.workloads.Job;

import org.acme.workloads.Drinks.Drinks;

import java.util.List;

public interface JobRepo {

    List<Job> getAllJobs();
    void add(Job job);
    void update(Job job);
    void delete(Job job);

}