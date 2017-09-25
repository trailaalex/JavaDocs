package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Alexandra.Traila on 7/12/2017.
 */
@Table(name="Jobs")
public class Job {
    @Id(name = "job_id")
    Long id;
    @Column(name = "Name_Job")
    String name_job;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_job() {
        return name_job;
    }

    public void setName_job(String name_job) {
        this.name_job = name_job;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name_job='" + name_job + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (id != null ? !id.equals(job.id) : job.id != null) return false;
        return name_job != null ? name_job.equals(job.name_job) : job.name_job == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
