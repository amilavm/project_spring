package com.jkcs.profilebuilder.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by AmilaVM on 1/31/2017.
 */
@Entity
public class JobTemplateSkillRate{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String req_rate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jobvacancy_id")
    private JobVacancy jobvacancy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    private Skills skills;



    public JobTemplateSkillRate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReq_rate() {
        return req_rate;
    }

    public void setReq_rate(String req_rate) {
        this.req_rate = req_rate;
    }

    public JobVacancy getJobvacancy() {
        return jobvacancy;
    }

    public void setJobvacancy(JobVacancy jobvacancy) {
        this.jobvacancy = jobvacancy;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobTemplateSkillRate)) return false;

        JobTemplateSkillRate that = (JobTemplateSkillRate) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "JobTemplateSkillRate{" +
                "id=" + id +
                ", req_rate='" + req_rate + '\'' +
                '}';
    }
}
