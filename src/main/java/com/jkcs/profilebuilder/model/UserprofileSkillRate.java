package com.jkcs.profilebuilder.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by AmilaVM on 2/6/2017.
 */
@Entity
public class UserprofileSkillRate implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "fk_userprofile", insertable = false, updatable = false, nullable = false)
    private UserProfile userprofile;


    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "fk_skill", insertable = false, updatable = false, nullable = false)
    private Skills skill;


    private String rate;

    public UserprofileSkillRate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserProfile getUserprofile() {
        return userprofile;
    }

    public void setUserprofile(UserProfile userprofile) {
        this.userprofile = userprofile;
    }

    public Skills getSkill() {
        return skill;
    }

    public void setSkill(Skills skill) {
        this.skill = skill;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserprofileSkillRate)) return false;

        UserprofileSkillRate that = (UserprofileSkillRate) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}