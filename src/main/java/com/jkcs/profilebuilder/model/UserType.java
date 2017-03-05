package com.jkcs.profilebuilder.model;

/**
 * Created by AmilaVM on 2/1/2017.
 */
public enum UserType {

    CANDIDATE("CANDIDATE"),
    COMPANY("COMPANY"),
    ADMIN("ADMIN");

    String userType;

    private UserType(String userType){
        this.userType = userType;
    }

    public String getUserType(){
        return userType;
    }

}
