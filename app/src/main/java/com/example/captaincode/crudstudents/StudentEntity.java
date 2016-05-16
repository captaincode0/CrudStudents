package com.example.captaincode.crudstudents;

import java.io.Serializable;

/**
 * Created by captaincode on 2/05/16.
 */
public class StudentEntity implements Serializable {
    private int id;
    private String nocontrol, name, address, sex, carrier;

    public void setId(int id) {
        this.id = id;
    }

    public void setNocontrol(String nocontrol) {
        this.nocontrol = nocontrol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public int getId() {

        return id;
    }

    public String getNocontrol() {
        return nocontrol;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getSex() {
        return sex;
    }

    public String getCarrier() {
        return carrier;
    }
}