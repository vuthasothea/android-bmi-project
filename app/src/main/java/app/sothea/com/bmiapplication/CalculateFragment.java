package app.sothea.com.bmiapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculateFragment extends Fragment {

    private TextView textResultNumber;
    private TextView textResultText;
    private EditText edtHeight;
    private EditText edtWeight;
    private Button btnCalculate;
    private ImageView imageBmi;

    public CalculateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);

        textResultNumber = view.findViewById(R.id.text_result_number);
        textResultText = view.findViewById(R.id.text_result_text);
        edtHeight = view.findViewById(R.id.edt_height);
        edtWeight = view.findViewById(R.id.edt_weight);
        imageBmi = view.findViewById(R.id.image_bmi);
        btnCalculate = view.findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBmi();
            }
        });

        return view;
    }

    public void calculateBmi() {
        String strHeight = edtHeight.getText().toString();
        String strWeight = edtWeight.getText().toString();
        if(strHeight != null && !strHeight.equals("") && strWeight != null && !strWeight.equals("")) {
            float height = Float.parseFloat(strHeight);
            float weight = Float.parseFloat(strWeight);
            float bmi = round((weight / (height * height)) * 10000, 1);

            textResultNumber.setText(String.format("%.1f kg/m\u00B2", bmi));
            String resultText = "";
            if(bmi < 18.5) {
                resultText = "Underweight";
                imageBmi.setImageResource(R.mipmap.underweight);
            } else if(bmi < 25) {
                resultText = "Normal weight";
                imageBmi.setImageResource(R.mipmap.healthy);
            } else if(bmi < 30) {
                resultText = "Overweight";
                imageBmi.setImageResource(R.mipmap.overweight);
            } else {
                resultText = "Obesity";
                imageBmi.setImageResource(R.mipmap.obese);
            }
            textResultText.setText(resultText);

            BmiEntiry bmiEntiry = new BmiEntiry();
            bmiEntiry.setWeight(weight);
            bmiEntiry.setHeight(height);
            bmiEntiry.setDate("11/11/1995");
            bmiEntiry.setResultNumber(bmi);
            bmiEntiry.setResultText(resultText);

            AppDatabase.getAppDatatbase(getContext()).bmiDao().insert(bmiEntiry);
            Toast.makeText(getContext(), "Insert success", Toast.LENGTH_LONG).show();

        }
    }

    public float round(float number, int digit) {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(digit, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

}
