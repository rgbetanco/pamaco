package com.nicahost.module.hotelreserve.bean;

import java.io.Serializable;

public class Rooms implements Serializable{
    private int roomid;
    private int roomtype;
    private int maxpeople;
    private String briefdescription;
    private double pricepernight;
    private char blocked;
    private int nomasterbill;
    private int active;
    public Rooms() {
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomtype(int roomtype) {
        this.roomtype = roomtype;
    }

    public int getRoomtype() {
        return roomtype;
    }

    public void setMaxpeople(int maxpeople) {
        this.maxpeople = maxpeople;
    }

    public int getMaxpeople() {
        return maxpeople;
    }

    public void setBriefdescription(String briefdescription) {
        this.briefdescription = briefdescription;
    }

    public String getBriefdescription() {
        return briefdescription;
    }

    public void setPricepernight(double pricepernight) {
        this.pricepernight = pricepernight;
    }

    public double getPricepernight() {
        return pricepernight;
    }

    public void setBlocked(char blocked) {
        this.blocked = blocked;
    }

    public char getBlocked() {
        return blocked;
    }

    public void setNomasterbill(int nomasterbill) {
        this.nomasterbill = nomasterbill;
    }

    public int getNomasterbill() {
        return nomasterbill;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getActive() {
        return active;
    }
}
