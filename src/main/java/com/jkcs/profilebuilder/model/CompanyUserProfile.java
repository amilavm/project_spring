package com.jkcs.profilebuilder.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by AmilaVM on 3/9/2017.
 */
@Entity
public class CompanyUserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String com_userName;
    private String com_UserPassword;
    private String com_email;
    private String com_CompanyName;
    private String com_location;
    private String com_telNo;

    @OneToMany(targetEntity = JobVacancy.class ,mappedBy = "companyUserProfile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<JobVacancy> jobVacancy;

    public CompanyUserProfile(){};


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCom_userName() {
        return com_userName;
    }

    public void setCom_userName(String com_userName) {
        this.com_userName = com_userName;
    }

    public String getCom_UserPassword() {
        return com_UserPassword;
    }

    public void setCom_UserPassword(String com_UserPassword) {
        this.com_UserPassword = com_UserPassword;
    }

    public String getCom_CompanyName() {
        return com_CompanyName;
    }

    public void setCom_CompanyName(String com_CompanyName) {
        this.com_CompanyName = com_CompanyName;
    }

    public String getCom_location() {
        return com_location;
    }

    public void setCom_location(String com_location) {
        this.com_location = com_location;
    }

    public String getCom_telNo() {
        return com_telNo;
    }

    public void setCom_telNo(String com_telNo) {
        this.com_telNo = com_telNo;
    }

    public String getCom_email() {
        return com_email;
    }

    public void setCom_email(String com_email) {
        this.com_email = com_email;
    }

    public List<JobVacancy> getJobVacancy() {
        return jobVacancy;
    }

    public void setJobVacancy(List<JobVacancy> jobVacancy) {
        this.jobVacancy = jobVacancy;
    }

    @Override
    public String toString() {
        return "CompanyUserProfile{" +
                "id=" + id +
                ", com_userName='" + com_userName + '\'' +
                ", com_UserPassword='" + com_UserPassword + '\'' +
                ", com_CompanyName='" + com_CompanyName + '\'' +
                ", com_location='" + com_location + '\'' +
                ", com_telNo='" + com_telNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyUserProfile)) return false;

        CompanyUserProfile that = (CompanyUserProfile) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
