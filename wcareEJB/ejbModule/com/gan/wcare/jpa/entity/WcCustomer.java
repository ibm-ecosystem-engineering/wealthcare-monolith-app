package com.gan.wcare.jpa.entity;


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;

@Table(name = "WCCUSTOMER")
@Entity
public class WcCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "wcuserid")
    private int wcUserId;

    @Column(name = "wcwealthmanagerid")
    private int wcWealthManagerId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private int age;

    @Column(name = "avgincome")
    private double avgIncome;

    @Column(name = "married")
    private boolean married;

    @Column(name = "spousefirstname")
    private String spouseFirstName;

    @Column(name = "spouselastname")
    private String spouseLastName;

    @Column(name = "spousegender")
    private String spouseGender;

    @Column(name = "spouseage")
    private int spouseAge;

    @Column(name = "spouseavgincome")
    private double spouseAvgIncome;

    @Column(name = "noofchildren")
    private int noOfChildren;

    @Column(name = "child1firstname")
    private String child1FirstName;

    @Column(name = "child1lastname")
    private String child1LastName;

    @Column(name = "child1gender")
    private String child1Gender;

    @Column(name = "child1age")
    private int child1Age;

    @Column(name = "child2firstname")
    private String child2FirstName;

    @Column(name = "child2lastname")
    private String child2LastName;

    @Column(name = "child2gender")
    private String child2Gender;

    @Column(name = "child2age")
    private int child2Age;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    @Column(name = "emailid")
    private String emailId;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "country")
    private String country;

    @Column(name = "zipcode")
    private String zipCode;

    @JsonInclude()
    @Transient
    private String startDateString;

    @JsonInclude()
    @Transient
    private String image;

    @JsonInclude()
    @Transient
    private String wealthManagerName;

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

    public int getWcWealthManagerId() {
        return wcWealthManagerId;
    }

    public void setWcWealthManagerId(int wcWealthManagerId) {
        this.wcWealthManagerId = wcWealthManagerId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAvgIncome() {
        return avgIncome;
    }

    public void setAvgIncome(double avgIncome) {
        this.avgIncome = avgIncome;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getSpouseFirstName() {
        return spouseFirstName;
    }

    public void setSpouseFirstName(String spouseFirstName) {
        this.spouseFirstName = spouseFirstName;
    }

    public String getSpouseLastName() {
        return spouseLastName;
    }

    public void setSpouseLastName(String spouseLastName) {
        this.spouseLastName = spouseLastName;
    }

    public String getSpouseGender() {
        return spouseGender;
    }

    public void setSpouseGender(String spouseGender) {
        this.spouseGender = spouseGender;
    }

    public int getSpouseAge() {
        return spouseAge;
    }

    public void setSpouseAge(int spouseAge) {
        this.spouseAge = spouseAge;
    }

    public double getSpouseAvgIncome() {
        return spouseAvgIncome;
    }

    public void setSpouseAvgIncome(double spouseAvgIncome) {
        this.spouseAvgIncome = spouseAvgIncome;
    }

    public int getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public String getChild1FirstName() {
        return child1FirstName;
    }

    public void setChild1FirstName(String child1FirstName) {
        this.child1FirstName = child1FirstName;
    }

    public String getChild1LastName() {
        return child1LastName;
    }

    public void setChild1LastName(String child1LastName) {
        this.child1LastName = child1LastName;
    }

    public String getChild1Gender() {
        return child1Gender;
    }

    public void setChild1Gender(String child1Gender) {
        this.child1Gender = child1Gender;
    }

    public int getChild1Age() {
        return child1Age;
    }

    public void setChild1Age(int child1Age) {
        this.child1Age = child1Age;
    }

    public String getChild2FirstName() {
        return child2FirstName;
    }

    public void setChild2FirstName(String child2FirstName) {
        this.child2FirstName = child2FirstName;
    }

    public String getChild2LastName() {
        return child2LastName;
    }

    public void setChild2LastName(String child2LastName) {
        this.child2LastName = child2LastName;
    }

    public String getChild2Gender() {
        return child2Gender;
    }

    public void setChild2Gender(String child2Gender) {
        this.child2Gender = child2Gender;
    }

    public int getChild2Age() {
        return child2Age;
    }

    public void setChild2Age(int child2Age) {
        this.child2Age = child2Age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStartDateString() {
        return startDateString;
    }

    public void setStartDateString(String startDateString) {
        this.startDateString = startDateString;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWealthManagerName() {
        return wealthManagerName;
    }

    public void setWealthManagerName(String wealthManagerName) {
        this.wealthManagerName = wealthManagerName;
    }
}
