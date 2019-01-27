package app.sothea.com.bmiapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculateFragment extends Fragment {

    private TextView textResultNumber;

    public CalculateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);

        textResultNumber = view.findViewById(R.id.text_result_number);
        textResultNumber.setText("23.00kg/m\u00B2");

        return view;
    }

}
