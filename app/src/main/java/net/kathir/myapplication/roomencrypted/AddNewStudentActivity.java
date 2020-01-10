package net.kathir.myapplication.roomencrypted;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import net.kathir.myapplication.R;

public class AddNewStudentActivity extends AppCompatActivity {

    private EditText sdName, sdCity, sdAge, sdPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_employee);

        sdName = (EditText)findViewById(R.id.editTextName);
        sdCity = (EditText)findViewById(R.id.editTextCity);
        sdAge = (EditText)findViewById(R.id.editTextAge);
        sdPhone = (EditText)findViewById(R.id.editTextPhone);

        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTask();
            }
        });
    }


    private void saveTask() {
        final String eName = sdName.getText().toString().trim();
        final String eCity = sdCity.getText().toString().trim();
        final String eAge = sdAge.getText().toString().trim();
        final String ePhone = sdPhone.getText().toString().trim();

        if (eName.isEmpty()) {
            sdName.setError("Name required");
            sdName.requestFocus();
            return;
        }

        if (eCity.isEmpty()) {
            sdCity.setError("City required");
            sdCity.requestFocus();
            return;
        }

        if (eAge.isEmpty()) {
            sdAge.setError("Age required");
            sdAge.requestFocus();
            return;
        }

        if (ePhone.isEmpty()) {
            sdPhone.setError("Phone required");
            sdPhone.requestFocus();
            return;
        }

        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a Employee

                Student student = new Student();
                student.setStu_name(eName);
                student.setStu_city(eCity);
                student.setStu_age(eAge);
                student.setStu_ph(ePhone);

                //adding to database

//                StudentDatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
//                        .taskDao()
//                        .insert(student);

                StudentDatabase.getINSTANCE(AddNewStudentActivity.this).taskDao().insert(student);


                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                startActivity(new Intent(getApplicationContext(), RoomEncryptedDBActivity.class));
                AddNewStudentActivity.this.finish();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        SaveTask st = new SaveTask();
        st.execute();
    }


}
