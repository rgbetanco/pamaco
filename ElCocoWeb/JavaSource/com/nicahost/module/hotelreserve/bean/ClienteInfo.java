/*
 * Created on Sep 27, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.bean;

public class ClienteInfo {

    private String Name;
    private String LastName;
    private String sex;
    private int rangeAge;
    private long ArrivalTime;
    private String passport;
    private int NoNationality;
    private int NoCountry;
    private String email;
    private String company;
    private String phoneCompany;
    private int roomId;
    private double price;
    private int Noguests;
    private String commentaries;
    private int active;

    public ClienteInfo() {
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setRangeAge(int rangeAge) {
        this.rangeAge = rangeAge;
    }

    public int getRangeAge() {
        return rangeAge;
    }

    public void setArrivalTime(long arrivalTime) {
        this.ArrivalTime = arrivalTime;
    }

    public long getArrivalTime() {
        return ArrivalTime;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    public void setNoNationality(int noNationality) {
        this.NoNationality = noNationality;
    }

    public int getNoNationality() {
        return NoNationality;
    }

    public void setNoCountry(int noCountry) {
        this.NoCountry = noCountry;
    }

    public int getNoCountry() {
        return NoCountry;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setPhoneCompany(String phoneCompany) {
        this.phoneCompany = phoneCompany;
    }

    public String getPhoneCompany() {
        return phoneCompany;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setNoguests(int noguests) {
        this.Noguests = noguests;
    }

    public int getNoguests() {
        return Noguests;
    }

    public void setCommentaries(String commentaries) {
        this.commentaries = commentaries;
    }

    public String getCommentaries() {
        return commentaries;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getActive() {
        return active;
    }
}
