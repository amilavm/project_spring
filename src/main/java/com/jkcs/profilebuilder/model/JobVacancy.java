package com.jkcs.profilebuilder.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by AmilaVM on 3/10/2017.
 */
@Entity
public class JobVacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String job_title;
    private int noOfVacancies;

    @OneToMany(mappedBy = "jobvacancy" , cascade = CascadeType.ALL)
    private List<JobTemplateSkillRate> jobTemplateSkillRates;

    @ManyToOne
    @JoinColumn(name = "company_user_id")
    private CompanyUserProfile companyUserProfile;


    public JobVacancy() {
    }

    public List<JobTemplateSkillRate> getJobTemplateSkillRates() {
        return jobTemplateSkillRates;
    }

    public void setJobTemplateSkillRates(List<JobTemplateSkillRate> jobTemplateSkillRates) {
        this.jobTemplateSkillRates = jobTemplateSkillRates;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public int getNoOfVacancies() {
        return noOfVacancies;
    }

    public void setNoOfVacancies(int noOfVacancies) {
        this.noOfVacancies = noOfVacancies;
    }

    public CompanyUserProfile getCompanyUserProfile() {
        return companyUserProfile;
    }

    public void setCompanyUserProfile(CompanyUserProfile companyUserProfile) {
        this.companyUserProfile = companyUserProfile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobVacancy)) return false;

        JobVacancy that = (JobVacancy) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "JobVacancy{" +
                "id=" + id +
                ", job_title='" + job_title + '\'' +
                ", noOfVacancies=" + noOfVacancies +
                '}';
    }
}
