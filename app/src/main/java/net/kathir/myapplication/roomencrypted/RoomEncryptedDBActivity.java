package net.kathir.myapplication.roomencrypted;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import net.kathir.myapplication.R;


import java.util.List;

public class RoomEncryptedDBActivity extends AppCompatActivity {

    FloatingActionButton add_btn;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_view_main);


        recyclerView = findViewById(R.id.recyclerview_tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        add_btn = (FloatingActionButton)findViewById(R.id.floating_button_add);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RoomEncryptedDBActivity.this, AddNewStudentActivity.class);
                startActivity(intent);
                RoomEncryptedDBActivity.this.finish();
            }
        });

        getStudents();
    }

    private void getStudents() {

        class GetStudent extends AsyncTask<Void, Void, List<Student>> {

            @Override
            protected List<Student> doInBackground(Void... voids) {


//                List<Student> taskList = StudentDatabaseClient
//                        .getInstance(getApplicationContext())
//                        .getAppDatabase()
//                        .taskDao()
//                        .getAll();


                List<Student> taskList = StudentDatabase.getINSTANCE(getApplicationContext()).taskDao().getAll();


               // List<Student> taskList = StudentDatabase.getINSTANCEWithouHelperFactory(getApplicationContext()).taskDao().getAll();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<Student> tasks) {
                super.onPostExecute(tasks);
                StudentAdapter adapter = new StudentAdapter(RoomEncryptedDBActivity.this, tasks);
                recyclerView.setAdapter(adapter);
            }
        }

        GetStudent gt = new GetStudent();
        gt.execute();
    }

}
