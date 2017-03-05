package com.jkcs.profilebuilder.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by AmilaVM on 2/6/2017.
 */
@Entity
public class UserprofileSkillRate {



    @EmbeddedId
    private UserprofileSkillRateId id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_userprofile", insertable = false, updatable = false, nullable = false)
    private UserProfile userprofile;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_skill", insertable = false, updatable = false, nullable = false)
    private Skills skill;

    private String rate;

    public UserprofileSkillRate(){}

    public UserProfile getUserprofile() {
        return userprofile;
    }

    public void setUserprofile(UserProfile userprofile) {
        this.userprofile = userprofile;
        this.id.setUserprofileId(userprofile.getCandidate_id());
    }

    public Skills getSkill() {
        return skill;
    }

    public void setSkill(Skills skill) {
        this.skill = skill;
        this.id.setSkillId(skill.getId());
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
