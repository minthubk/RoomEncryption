package net.kathir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.kathir.myapplication.roomencrypted.RoomEncryptedDBActivity;

public class MainActivity extends AppCompatActivity {

    Button roomdb,roomencrypteddb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roomdb = (Button)findViewById(R.id.room_without_encrypt);

        roomencrypteddb = (Button)findViewById(R.id.room_with_encrypt);


        roomdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,RoomDBActivity.class);
                startActivity(intent);

            }
        });


        roomencrypteddb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, RoomEncryptedDBActivity.class);
                startActivity(intent);

            }
        });



    }
}
