package net.kathir.myapplication;

import androidx.room.Database;

import androidx.room.RoomDatabase;

import net.sqlcipher.database.SQLiteDatabase;

@Database(entities = { Employee.class }, version = 1)
public abstract class EmployeeDatabase extends RoomDatabase {

    public abstract EmployeeDao taskDao();

}

