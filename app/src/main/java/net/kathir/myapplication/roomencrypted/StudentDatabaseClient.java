package net.kathir.myapplication.roomencrypted;

import android.content.Context;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TableLayout;

import androidx.room.Room;

import com.commonsware.cwac.saferoom.SafeHelperFactory;


public class StudentDatabaseClient {

    private Context mCtx;
    private static StudentDatabaseClient mInstance;

    //our app database object
    private StudentDatabase appDatabase;

    private StudentDatabaseClient(Context mCtx) {
        this.mCtx = mCtx;

        //creating the app database with Room database builder
        //MyToDos is the name of the database


       // appDatabase = Room.databaseBuilder(mCtx, StudentDatabase.class, "StuDos").build();

        EditText edText = new EditText(mCtx);
        edText .setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT,0f));
        edText .setInputType(InputType.TYPE_CLASS_NUMBER);
        edText.setText("abaqus77");



        SafeHelperFactory factory=SafeHelperFactory.fromUser(edText.getText());

        appDatabase=Room.databaseBuilder(mCtx, StudentDatabase.class, "StuDos")
                .openHelperFactory(null)
                .build();

    }

    public static synchronized StudentDatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new StudentDatabaseClient(mCtx);
        }
        return mInstance;
    }

    public StudentDatabase getAppDatabase() {

        return appDatabase;
    }
}
