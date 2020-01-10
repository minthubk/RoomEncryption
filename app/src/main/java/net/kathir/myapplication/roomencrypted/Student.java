package net.kathir.myapplication.roomencrypted;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int stu_id;

    @ColumnInfo(name = "stu_name")
    private String stu_name;

    @ColumnInfo(name = "stu_city")
    private String stu_city;

    @ColumnInfo(name = "stu_age")
    private String stu_age;

    @ColumnInfo(name = "stu_ph")
    private String stu_ph;

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_city() {
        return stu_city;
    }

    public void setStu_city(String stu_city) {
        this.stu_city = stu_city;
    }

    public String getStu_age() {
        return stu_age;
    }

    public void setStu_age(String stu_age) {
        this.stu_age = stu_age;
    }

    public String getStu_ph() {
        return stu_ph;
    }

    public void setStu_ph(String stu_ph) {
        this.stu_ph = stu_ph;
    }


}
