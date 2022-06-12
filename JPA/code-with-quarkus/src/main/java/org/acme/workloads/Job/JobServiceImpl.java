package org.acme.workloads.Job;

import org.acme.model.JobDTO;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class JobServiceImpl implements JobService{

    private final JobRepo jobRepo;

    public JobServiceImpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public List<Job> getAllJobs() {
        return this.jobRepo.getAllJobs();
    }

    @Override
    public Job addJob(JobDTO jobDTO) {
        Job job = new Job();
        job.setJob_title(jobDTO.getJob_title());
        job.setPermission(jobDTO.getPermission());
        this.jobRepo.add(job);
        return job;
    }

    @Override
    public Job updateJob(JobDTO jobDTO) {
        Job job = new Job();
        job.setJob_title(jobDTO.getJob_title());
        job.setPermission(jobDTO.getPermission());
        this.jobRepo.update(job);
        return job;
    }

    @Override
    public Job deleteJob(JobDTO jobDTO) {
        Job job = new Job();
        job.setJob_title(jobDTO.getJob_title());
        job.setPermission(jobDTO.getPermission());
        this.jobRepo.delete(job);
        return job;
    }
}