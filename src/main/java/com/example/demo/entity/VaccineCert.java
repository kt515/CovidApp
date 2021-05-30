package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "vaccine_cert")
public class VaccineCert {

    @Id
    @Column(name = "cert_id")
    private String cert_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name = "public_userid", referencedColumnName = "public_userid"),
            @JoinColumn(name = "public_firstname", referencedColumnName = "first_name"),
            @JoinColumn(name = "public_lastname", referencedColumnName = "last_name"),
            @JoinColumn(name = "public_dob", referencedColumnName = "dob") })
    private Public public_cert;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name = "org_id", referencedColumnName = "org_id"),
            @JoinColumn(name = "org_name", referencedColumnName = "org_name") })
    private HealthOrg org_cert;

    @Column(name = "vaccine_location")
    private String vaccine_location;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private String time;

    public VaccineCert() {

    }

    public VaccineCert(String cert_id, Public public_cert, HealthOrg org_cert, String vaccine_location, Date date,
            String time) {
        this.cert_id = cert_id;
        this.public_cert = public_cert;
        this.org_cert = org_cert;
        this.vaccine_location = vaccine_location;
        this.date = date;
        this.time = time;
    }

    public String getCert_id() {
        return cert_id;
    }

    public void setCert_id(String cert_id) {
        this.cert_id = cert_id;
    }

    public String getVaccine_location() {
        return vaccine_location;
    }

    public void setVaccine_location(String vaccine_location) {
        this.vaccine_location = vaccine_location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public HealthOrg getOrg_cert() {
        return org_cert;
    }

    public void setOrg_cert(HealthOrg org_cert) {
        this.org_cert = org_cert;
    }

    public Public getPublic_cert() {
        return public_cert;
    }

    public void setPublic_cert(Public public_cert) {
        this.public_cert = public_cert;
    }

    @Override
    public String toString() {
        return "VaccineCert [cert_id=" + cert_id + ", date=" + date + ", org_cert=" + org_cert + ", public_cert="
                + public_cert + ", time=" + time + ", vaccine_location=" + vaccine_location + "]";
    }

}
