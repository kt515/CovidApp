package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "business")
public class Business implements Serializable {

    @EmbeddedId
    private BusinessId businessId;

    @Column(name = "contact_no")
    private Integer contact_no;

    @Column(name = "positive_case")
    private boolean positive_case;

    @ManyToMany(mappedBy = "business_record")
    private List<Record> business_record;

    public Business() {

    }

    public Business(BusinessId businessId, Integer contact_no, boolean positive_case) {
        this.businessId = businessId;
        this.contact_no = contact_no;
        this.positive_case = positive_case;
    }

    public BusinessId getBusinessId() {
        return businessId;
    }

    public void setBusinessId(BusinessId businessId) {
        this.businessId = businessId;
    }

    public Integer getContact_no() {
        return contact_no;
    }

    public void setContact_no(Integer contact_no) {
        this.contact_no = contact_no;
    }

    public boolean isPositive_case() {
        return positive_case;
    }

    public void setPositive_case(boolean positive_case) {
        this.positive_case = positive_case;
    }

    @Override
    public String toString() {
        return "Business [businessId=" + businessId + ", contact_no=" + contact_no + ", positive_case=" + positive_case
                + "]";
    }

}
