package net.kathir.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class RoomDBActivity extends AppCompatActivity {

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

                Intent intent = new Intent(RoomDBActivity.this,AddNewEmployee.class);
                startActivity(intent);
                RoomDBActivity.this.finish();
            }
        });

        getEmployee();
    }

    private void getEmployee() {

        class GetEmployee extends AsyncTask<Void, Void, List<Employee>> {

            @Override
            protected List<Employee> doInBackground(Void... voids) {
                List<Employee> taskList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .taskDao()
                        .getAll();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<Employee> tasks) {
                super.onPostExecute(tasks);
                EmployeeAdapter adapter = new EmployeeAdapter(RoomDBActivity.this, tasks);
                recyclerView.setAdapter(adapter);
            }
        }

        GetEmployee gt = new GetEmployee();
        gt.execute();
    }

}
