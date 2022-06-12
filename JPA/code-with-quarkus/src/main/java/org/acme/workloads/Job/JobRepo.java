package org.acme.workloads.Job;

import java.util.List;

public interface JobRepo {

    List<Job> getAllJobs();
    void add(Job job);
    void update(Job job);
    void delete(Job job);

}