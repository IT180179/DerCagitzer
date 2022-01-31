package org.acme.model;

public class JobDTO {

    private String job_title;
    private boolean permission;

    public JobDTO(String job_title, boolean permission) {
        this.job_title = job_title;
        this.permission = permission;
    }

    public JobDTO() {
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
}
