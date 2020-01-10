package net.kathir.myapplication.roomencrypted;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.commonsware.cwac.saferoom.SafeHelperFactory;


@Database(entities = { Student.class }, version = 1, exportSchema = false)

public abstract class StudentDatabase extends RoomDatabase {

    //public abstract StudentDao taskDao();


    private static StudentDatabase INSTANCE;
    private static final Object sLock = new Object();
    private static StudentDatabase dINSTANCE;
    private static final Object dsLock = new Object();
    private static final String DATABASE_NAME = "userDb";
    private static final char[] passphrase = {'m', 'a', 'r', 'k'};

    public abstract StudentDao taskDao();

    //    private static SafeHelperFactory factory = SafeHelperFactory.fromUser();
    private static SafeHelperFactory factory = new SafeHelperFactory(passphrase);

    public static StudentDatabase getINSTANCE(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE =
                        Room.databaseBuilder(context.getApplicationContext(),
                                StudentDatabase.class, DATABASE_NAME)
                                .openHelperFactory(factory)  //encrypt
                                .fallbackToDestructiveMigration()
                                .build();
            }
            return INSTANCE;
        }
    }

    public static StudentDatabase getINSTANCEWithouHelperFactory(Context context) {
        synchronized (dsLock) {
            if (dINSTANCE == null) {
                dINSTANCE =
                        Room.databaseBuilder(context.getApplicationContext(),
                                StudentDatabase.class, DATABASE_NAME)
                                .fallbackToDestructiveMigration()
                                .build();
            }
            return dINSTANCE;
        }
    }

}
