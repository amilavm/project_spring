package com.jkcs.profilebuilder.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by AmilaVM on 1/26/2017.
 */
@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer candidate_id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String confirmPassword;
    private String address;
    private String gender; //radio button
    private String country; //dropdown menu
    private Date dob;
    private String phone;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "users_with_skills")
//    private List<Skills> skills;

    @OneToMany(mappedBy = "userprofile" , fetch = FetchType.EAGER ,
    cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE ,
    org.hibernate.annotations.CascadeType.DELETE})
    private List<UserprofileSkillRate> skills;



    public UserProfile()  {

    }
    public Integer getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(Integer candidate_id) {
        this.candidate_id = candidate_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public List<Skills> getSkills() {
//        return skills;
//    }

//    public void setSkills(List<Skills> skills) {
//        this.skills = skills;
//    }


    public List<UserprofileSkillRate> getSkills() {
        return skills;
    }

    public void setSkills(List<UserprofileSkillRate> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "UserProfile [candidate_id=" + candidate_id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
                + ", address=" + address + ", gender=" + gender + ", country=" + country + ", dob=" + dob +
                ", phone=" + phone + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (candidate_id ^ (candidate_id >>> 32));
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        UserProfile up = (UserProfile) obj;
        return up.getCandidate_id().equals(this.candidate_id);
    }
}
