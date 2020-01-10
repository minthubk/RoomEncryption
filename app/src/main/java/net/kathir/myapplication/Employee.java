package net.kathir.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "employee_table")
public class Employee {

    @PrimaryKey(autoGenerate = true)
    private int emp_id;

    @ColumnInfo(name = "emp_name")
    private String emp_name;

    @ColumnInfo(name = "emp_city")
    private String emp_city;

    @ColumnInfo(name = "emp_age")
    private String emp_age;

    @ColumnInfo(name = "emp_ph")
    private String emp_ph;



    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_city() {
        return emp_city;
    }

    public void setEmp_city(String emp_city) {
        this.emp_city = emp_city;
    }

    public String getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(String emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_ph() {
        return emp_ph;
    }

    public void setEmp_ph(String emp_ph) {
        this.emp_ph = emp_ph;
    }


}
