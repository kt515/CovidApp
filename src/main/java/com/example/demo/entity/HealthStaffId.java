package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Embeddable
public class HealthStaffId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    private User staff_id;

    public HealthStaffId() {
    }

    public HealthStaffId(User staff_id) {
        this.staff_id = staff_id;
    }

    public User getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(User staff_id) {
        this.staff_id = staff_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(staff_id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        HealthStaffId other = (HealthStaffId) obj;
        return staff_id.equals(other.staff_id);
    }

}
