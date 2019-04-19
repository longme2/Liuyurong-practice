package com.hibernate.admin;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admin_table", schema = "hotel_system", catalog = "")
public class AdminTableEntity {
    private int account;
    private String password;
    private String jurisdiction;

    @Id
    @Column(name = "account", nullable = false)
    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "jurisdiction", nullable = true, length = 255)
    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminTableEntity that = (AdminTableEntity) o;
        return account == that.account &&
                Objects.equals(password, that.password) &&
                Objects.equals(jurisdiction, that.jurisdiction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, password, jurisdiction);
    }

    @Override
    public String toString() {
        return account + "..." + password + "..." + jurisdiction;
    }
}
