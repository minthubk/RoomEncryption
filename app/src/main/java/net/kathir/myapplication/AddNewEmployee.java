package net.kathir.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddNewEmployee extends AppCompatActivity {

    private EditText edName,edCity,edAge,edPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_employee);

        edName = (EditText)findViewById(R.id.editTextName);
        edCity = (EditText)findViewById(R.id.editTextCity);
        edAge = (EditText)findViewById(R.id.editTextAge);
        edPhone = (EditText)findViewById(R.id.editTextPhone);

        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTask();
            }
        });
    }


    private void saveTask() {
        final String eName = edName.getText().toString().trim();
        final String eCity = edCity.getText().toString().trim();
        final String eAge = edAge.getText().toString().trim();
        final String ePhone = edPhone.getText().toString().trim();

        if (eName.isEmpty()) {
            edName.setError("Name required");
            edName.requestFocus();
            return;
        }

        if (eCity.isEmpty()) {
            edCity.setError("City required");
            edCity.requestFocus();
            return;
        }

        if (eAge.isEmpty()) {
            edAge.setError("Age required");
            edAge.requestFocus();
            return;
        }

        if (ePhone.isEmpty()) {
            edPhone.setError("Phone required");
            edPhone.requestFocus();
            return;
        }

        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a Employee

                Employee employee = new Employee();
                employee.setEmp_name(eName);
                employee.setEmp_city(eCity);
                employee.setEmp_age(eAge);
                employee.setEmp_ph(ePhone);

                //adding to database
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .taskDao()
                        .insert(employee);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();

                //startActivity(new Intent(getApplicationContext(), RoomDBActivity.class));

                Intent intent = new Intent(AddNewEmployee.this,RoomDBActivity.class);
                startActivity(intent);
                AddNewEmployee.this.finish();

                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        SaveTask st = new SaveTask();
        st.execute();
    }
}
