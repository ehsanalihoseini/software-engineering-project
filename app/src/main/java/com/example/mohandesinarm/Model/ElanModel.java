package com.example.mohandesinarm.Model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ElanModel {
    @PrimaryKey(autoGenerate = true)
    public int eid;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "matn")
    public String matn;

    @ColumnInfo(name = "sath")
    public int sath;

    @ColumnInfo(name = "olaviat")
    public String olaviat;

    @ColumnInfo(name = "group")
    public String group;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "phone")
    public String phone;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatn() {
        return matn;
    }

    public void setMatn(String matn) {
        this.matn = matn;
    }

    public int getSath() {
        return sath;
    }

    public void setSath(int sath) {
        this.sath = sath;
    }

    public String getOlaviat() {
        return olaviat;
    }

    public void setOlaviat(String olaviat) {
        this.olaviat = olaviat;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
