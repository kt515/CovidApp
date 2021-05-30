package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class HealthOrgId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private User org_id;

    @Column(name = "org_name")
    private String org_name;

    public HealthOrgId() {
    }

    public HealthOrgId(User org_id, String org_name) {
        this.org_id = org_id;
        this.org_name = org_name;
    }

    public User getOrg_id() {
        return org_id;
    }

    public void setOrg_id(User org_id) {
        this.org_id = org_id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(org_id, org_name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        HealthOrgId other = (HealthOrgId) obj;
        return org_id.equals(other.org_id) && org_name.equals(other.org_name);
    }

}
