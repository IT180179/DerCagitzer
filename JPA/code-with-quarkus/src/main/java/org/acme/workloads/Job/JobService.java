package org.acme.workloads.Job;

import org.acme.model.JobDTO;

import java.util.List;

public interface JobService {

    List<Job> getAllJobs();
    Job addJob(JobDTO jobDTO);
    Job updateJob(JobDTO jobDTO);
    Job deleteJob(JobDTO jobDTO);

}