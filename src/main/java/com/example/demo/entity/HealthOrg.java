package com.example.demo.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "healthorg")
public class HealthOrg implements Serializable {

    @EmbeddedId
    private HealthOrgId healthOrgId;

    @Column(name = "org_address")
    private String org_address;

    @Column(name = "contact_no")
    private Integer contact_no;

    @OneToMany(mappedBy = "org_cert", cascade = CascadeType.ALL)
    private List<VaccineCert> org_cert;

    @OneToMany(mappedBy = "org_staff", cascade = CascadeType.ALL)
    private List<HealthStaff> org_staff;

    public HealthOrg() {
    }

    public HealthOrg(HealthOrgId healthOrgId, String org_address, Integer contact_no) {
        this.healthOrgId = healthOrgId;
        this.org_address = org_address;
        this.contact_no = contact_no;
    }

    public HealthOrgId getHealthOrgId() {
        return healthOrgId;
    }

    public void setHealthOrgId(HealthOrgId healthOrgId) {
        this.healthOrgId = healthOrgId;
    }

    public String getOrg_address() {
        return org_address;
    }

    public void setOrg_address(String org_address) {
        this.org_address = org_address;
    }

    public Integer getContact_no() {
        return contact_no;
    }

    public void setContact_no(Integer contact_no) {
        this.contact_no = contact_no;
    }

    @Override
    public String toString() {
        return "HealthOrg [contact_no=" + contact_no + ", healthOrgId=" + healthOrgId + ", org_address=" + org_address
                + "]";
    }

}
