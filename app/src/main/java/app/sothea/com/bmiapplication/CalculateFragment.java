package app.sothea.com.bmiapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculateFragment extends Fragment {

    private TextView textResultNumber;
    private TextView textResultText;
    private EditText edtHeight;
    private EditText edtWeight;
    private Button btnCalculate;

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
        btnCalculate = view.findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBmi();
            }
        });

        //textResultNumber.setText("23.00kg/m\u00B2");

        return view;
    }

    public void calculateBmi() {
        String strHeight = edtHeight.getText().toString();
        String strWeight = edtWeight.getText().toString();
        if(strHeight != null && !strHeight.equals("") && strWeight != null && !strWeight.equals("")) {
            float height = Float.parseFloat(strHeight);
            float weight = Float.parseFloat(strWeight);
            float bmi = round((weight / (height * height)) * 10000, 1);
            displayBmi(bmi);
        }
    }

    public void displayBmi(float bmi) {
        textResultNumber.setText(String.format("%.1f kg/m\u00B2", bmi));
        if(bmi < 18.5) {
            textResultText.setText("Underweight");
        } else if(bmi < 25) {
            textResultText.setText("Normal weight");
        } else if(bmi < 30) {
            textResultText.setText("Overweight");
        } else {
            textResultText.setText("Obesity");
        }
    }

    public float round(float number, int digit) {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(digit, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

}
