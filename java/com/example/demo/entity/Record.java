package com.example.demo.entity;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "record")
public class Record {

    @Id
    @Column(name = "record_id")
    private String record_id;

    @Column(name = "date_visited")
    private Date date_visited;

    @Column(name = "checkin_time")
    private String checkin_time;

    @Column(name = "checkout_time")
    private String checkout_time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name = "public_userid", referencedColumnName = "public_userid"),
            @JoinColumn(name = "public_firstname", referencedColumnName = "first_name"),
            @JoinColumn(name = "public_lastname", referencedColumnName = "last_name"),
            @JoinColumn(name = "public_dob", referencedColumnName = "dob") })
    private Public public_record;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name = "store_id", referencedColumnName = "store_id"),
            @JoinColumn(name = "store_name", referencedColumnName = "store_name"),
            @JoinColumn(name = "store_address", referencedColumnName = "store_address") })
    private Business business_record;

    public Record() {
    }

    public Record(String record_id, Date date_visited, String checkin_time, String checkout_time, Public public_record,
            Business business_record) {
        this.record_id = record_id;
        this.date_visited = date_visited;
        this.checkin_time = checkin_time;
        this.checkout_time = checkout_time;
        this.public_record = public_record;
        this.business_record = business_record;
    }

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
    }

    public Date getDate_visited() {
        return date_visited;
    }

    public void setDate_visited(Date date_visited) {
        this.date_visited = date_visited;
    }

    public String getCheckin_time() {
        return checkin_time;
    }

    public void setCheckin_time(String checkin_time) {
        this.checkin_time = checkin_time;
    }

    public String getCheckout_time() {
        return checkout_time;
    }

    public void setCheckout_time(String checkout_time) {
        this.checkout_time = checkout_time;
    }

    public Public getPublic_record() {
        return public_record;
    }

    public void setPublic_record(Public public_record) {
        this.public_record = public_record;
    }

    public Business getBusiness_record() {
        return business_record;
    }

    public void setBusiness_record(Business business_record) {
        this.business_record = business_record;
    }

    @Override
    public String toString() {
        return "Record [business_record=" + business_record + ", checkin_time=" + checkin_time + ", checkout_time="
                + checkout_time + ", date_visited=" + date_visited + ", public_record=" + public_record + ", record_id="
                + record_id + "]";
    }

}
