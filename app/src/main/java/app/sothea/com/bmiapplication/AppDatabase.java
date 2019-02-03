package app.sothea.com.bmiapplication;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {BmiEntiry.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase INSTANCE;
    public abstract BmiDao bmiDao();
    public static AppDatabase getAppDatatbase(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "bmi-database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }

}
