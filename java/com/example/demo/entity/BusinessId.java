package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Embeddable
public class BusinessId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private User store_id;

    @Column(name = "store_name")
    private String store_name;

    @Column(name = "store_address")
    private String store_address;

    public BusinessId() {
    }

    public BusinessId(User store_id, String store_name, String store_address) {
        this.store_id = store_id;
        this.store_name = store_name;
        this.store_address = store_address;
    }

    public User getStore_id() {
        return store_id;
    }

    public void setStore_id(User store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_address() {
        return store_address;
    }

    public void setStore_address(String store_address) {
        this.store_address = store_address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(store_id, store_name, store_address);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        BusinessId businessId = (BusinessId) obj;
        return store_id.equals(businessId.store_id) && store_name.equals(businessId.store_name)
                && store_address.equals(businessId.store_address);
    }

}
