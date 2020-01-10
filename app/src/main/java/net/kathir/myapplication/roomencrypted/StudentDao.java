package net.kathir.myapplication.roomencrypted;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM student_table")
    List<Student> getAll();

    @Insert
    void insert(Student student);

}
