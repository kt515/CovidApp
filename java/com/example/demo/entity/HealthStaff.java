package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "healthstaff")
public class HealthStaff implements Serializable {

    @EmbeddedId
    private HealthStaffId healthStaffId;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "contact_no")
    private Integer contact_no;

    @Column(name = "residential_address")
    private String residential_address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name = "org_id"), @JoinColumn(name = "org_name") })
    private HealthOrg org_staff;

    public HealthStaff() {

    }

    public HealthStaff(HealthStaffId healthStaffId, String first_name, String last_name, Date dob, Integer contact_no,
            String residential_address, HealthOrg org_staff) {
        this.healthStaffId = healthStaffId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.contact_no = contact_no;
        this.residential_address = residential_address;
        this.org_staff = org_staff;
    }

    public HealthStaffId getHealthStaffId() {
        return healthStaffId;
    }

    public void setHealthStaffId(HealthStaffId healthStaffId) {
        this.healthStaffId = healthStaffId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getContact_no() {
        return contact_no;
    }

    public void setContact_no(Integer contact_no) {
        this.contact_no = contact_no;
    }

    public String getResidential_address() {
        return residential_address;
    }

    public void setResidential_address(String residential_address) {
        this.residential_address = residential_address;
    }

    public HealthOrg getOrg_staff() {
        return org_staff;
    }

    public void setOrg_staff(HealthOrg org_staff) {
        this.org_staff = org_staff;
    }

    @Override
    public String toString() {
        return "HealthStaff [contact_no=" + contact_no + ", dob=" + dob + ", first_name=" + first_name
                + ", healthStaffId=" + healthStaffId + ", last_name=" + last_name + ", org_staff=" + org_staff
                + ", residential_address=" + residential_address + "]";
    }

}
