package com.jkcs.profilebuilder.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by AmilaVM on 1/31/2017.
 */
@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String skillName;
    //private String skillRate;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "Skill_type_id")
    private SkillType skillType;



    @OneToMany(mappedBy = "skill" , fetch = FetchType.LAZY,
    cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
    org.hibernate.annotations.CascadeType.DELETE})
    private List<UserprofileSkillRate> userprofiles;


    @OneToMany(mappedBy = "skills" ,cascade = CascadeType.ALL)
    private List<JobTemplateSkillRate> jobTemplateSkillRates;

    public Skills(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    public List<UserprofileSkillRate> getUserprofiles() {
        return userprofiles;
    }

    public void setUserprofiles(List<UserprofileSkillRate> userprofiles) {
        this.userprofiles = userprofiles;
    }

    public List<JobTemplateSkillRate> getJobTemplateSkillRates() {
        return jobTemplateSkillRates;
    }

    public void setJobTemplateSkillRates(List<JobTemplateSkillRate> jobTemplateSkillRates) {
        this.jobTemplateSkillRates = jobTemplateSkillRates;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", skillName='" + skillName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skills skills = (Skills) o;

        return id.equals(skills.id);

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
