package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.*;

@Embeddable
public class PublicId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "public_userid")
    private User public_userid;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    public PublicId() {
    }

    public PublicId(User public_userid, String first_name, String lastName, Date dob) {
        this.public_userid = public_userid;
        this.first_name = first_name;
        this.lastName = lastName;
        this.dob = dob;
    }

    public User getPublic_userid() {
        return public_userid;
    }

    public void setPublic_userid(User public_userid) {
        this.public_userid = public_userid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PublicId publicId = (PublicId) o;
        return public_userid.equals(publicId.public_userid) && first_name.equals(publicId.first_name)
                && lastName.equals(publicId.lastName) && dob.equals(publicId.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(public_userid, first_name, lastName, dob);
    }

}
