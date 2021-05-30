package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    private String user_id;

    @Column(name = "password")
    private String password;

    @Column(name = "roles")
    private String roles;

    @OneToMany(mappedBy = "publicId.public_userid", cascade = CascadeType.ALL)
    private List<Public> public_userid;

    @OneToMany(mappedBy = "businessId.store_id", cascade = CascadeType.ALL)
    private List<Business> store_id;

    @OneToMany(mappedBy = "healthStaffId.staff_id", cascade = CascadeType.ALL)
    private List<HealthStaff> staff_id;

    @OneToMany(mappedBy = "healthOrgId.org_id", cascade = CascadeType.ALL)
    private List<HealthOrg> org_id;

    @OneToMany(mappedBy = "user_alert", cascade = CascadeType.ALL)
    private List<Alert> user_alert;

    // constructors
    public User() {
    }

    public User(String user_id, String roles, String password) {
        this.user_id = user_id;
        this.roles = roles;
        this.password = password;
    }

    // getters and setters
    public String getId() {
        return user_id;
    }

    public void setId(String user_id) {
        this.user_id = user_id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [password=" + password + ", roles=" + roles + ", user_id=" + user_id + "]";
    }

}
