package com.jkcs.profilebuilder.model;

import javax.persistence.*;

/**
 * Created by AmilaVM on 2/1/2017.
 */
@Entity
@Table(name = "User_Types")
public class UserTypeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String type = UserType.CANDIDATE.getUserType();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTypeProfile that = (UserTypeProfile) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return type != null ? type.equals(that.type) : that.type == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserTypeProfile{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
