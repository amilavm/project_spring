package com.jkcs.profilebuilder.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by AmilaVM on 2/6/2017.
 */
@Embeddable
public class UserprofileSkillRateId implements Serializable {
    @Column(name = "fk_userprofile")
    protected Integer userprofileId;


    @Column(name = "fk_skill")
    protected Integer skillId;

    public UserprofileSkillRateId(){}

    public UserprofileSkillRateId(Integer userprofileId,Integer skillId){
        this.userprofileId = userprofileId;
        this.skillId = skillId;
    }

    public Integer getUserprofileId() {
        return userprofileId;
    }

    public void setUserprofileId(Integer userprofileId) {
        this.userprofileId = userprofileId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserprofileSkillRateId)) return false;

        UserprofileSkillRateId that = (UserprofileSkillRateId) o;

        if (userprofileId != null ? !userprofileId.equals(that.userprofileId) : that.userprofileId != null)
            return false;
        return skillId != null ? skillId.equals(that.skillId) : that.skillId == null;

    }

    @Override
    public int hashCode() {
        int result = userprofileId != null ? userprofileId.hashCode() : 0;
        result = 31 * result + (skillId != null ? skillId.hashCode() : 0);
        return result;
    }



}
