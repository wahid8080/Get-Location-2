package com.example.testlocation;

public class UserInformation {

    public String name;
    public double latitude;
    public double longitude;

    public UserInformation(){

    }
    public UserInformation(String name,double latitude,double longitude){
        this.name=name;
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
