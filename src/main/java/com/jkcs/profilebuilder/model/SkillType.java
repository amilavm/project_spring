package com.jkcs.profilebuilder.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by AmilaVM on 2/1/2017.
 */
@Entity
public class SkillType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ST_ID")
    private Integer st_id;
    private String st_name;

    @OneToMany(mappedBy = "skillType", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Skills> skills;

    public Integer getSt_id() {
        return st_id;
    }

    public void setSt_id(Integer st_id) {
        this.st_id = st_id;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

//    public List<Skills> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(List<Skills> skills) {
//        this.skills = skills;
//    }
}
