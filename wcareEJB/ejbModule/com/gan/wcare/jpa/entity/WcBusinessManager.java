package com.gan.wcare.jpa.entity;


import javax.persistence.*;
import java.util.Date;

@Table(name = "WCBUSINESSMANAGER")
@Entity
public class WcBusinessManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "wcuserid")
    private int wcUserId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "startdate")
    private Date startDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWcUserId() {
        return wcUserId;
    }

    public void setWcUserId(int wcUserId) {
        this.wcUserId = wcUserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}