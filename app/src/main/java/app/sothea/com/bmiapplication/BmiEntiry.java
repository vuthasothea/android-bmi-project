package app.sothea.com.bmiapplication;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class BmiEntiry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private float weight;
    private float height;
    private String date;

    private float resultNumber;
    private String resultText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getResultNumber() {
        return resultNumber;
    }

    public void setResultNumber(float resultNumber) {
        this.resultNumber = resultNumber;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }
}
