package org.acme.model;

import java.io.Serializable;
import java.util.Objects;

public class JobDTO implements Serializable {
    private final Integer job_id;
    private final String job_title;
    private final boolean permission;

    public JobDTO(Integer job_id, String job_title, boolean permission) {
        this.job_id = job_id;
        this.job_title = job_title;
        this.permission = permission;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public boolean getPermission() {
        return permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobDTO entity = (JobDTO) o;
        return Objects.equals(this.job_id, entity.job_id) &&
                Objects.equals(this.job_title, entity.job_title) &&
                Objects.equals(this.permission, entity.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job_id, job_title, permission);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "job_id = " + job_id + ", " +
                "job_title = " + job_title + ", " +
                "permission = " + permission + ")";
    }
}
