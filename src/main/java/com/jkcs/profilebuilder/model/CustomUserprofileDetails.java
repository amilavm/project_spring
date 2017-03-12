package com.jkcs.profilebuilder.model;

import java.util.Date;

/**
 * Created by AmilaVM on 3/8/2017.
 */
public class CustomUserprofileDetails {

    //private Integer candidate_id;
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

    private String skillName;

    private String rate;




//    public Integer getCandidate_id() {
//        return candidate_id;
//    }
//
//    public void setCandidate_id(Integer candidate_id) {
//        this.candidate_id = candidate_id;
//    }

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

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }






}
