package app.sothea.com.bmiapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface BmiDao {

    @Query("SELECT * FROM BmiEntiry")
    List<BmiEntiry> getAll();

    @Insert
    void insert(BmiEntiry bmi);

}
