package com.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "USER")
public class UserEntity extends BaseEntityAudit {

    @NotEmpty(message = "Please enter your email")
    @Email(message = "Invalid email format")
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private int role;

    @Column(name = "active")
    private int active;

    @OneToMany(mappedBy = "user")
    private List<BillEntity> bills;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getRole() {
        return role;
    }

    public UserEntity setRole(int role) {
        this.role = role;
        return this;
    }

    public int getActive() {
        return active;
    }

    public UserEntity setActive(int active) {
        this.active = active;
        return this;
    }

    public boolean isActive(){
        return active == 1;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", active=" + isActive() +
                '}';
    }

}
