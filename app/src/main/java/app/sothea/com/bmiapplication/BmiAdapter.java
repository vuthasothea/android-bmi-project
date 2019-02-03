package app.sothea.com.bmiapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BmiAdapter extends RecyclerView.Adapter<BmiAdapter.MyViewHolder> {

    private List<BmiEntiry> bmiList;

    public BmiAdapter(List<BmiEntiry> bmiList) {
        this.bmiList = bmiList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bmi_list_row, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BmiEntiry bmi = bmiList.get(position);
        holder.txtMain.setText("Weight: " + bmi.getWeight() +"kg Height: " + bmi.getHeight() +"cm");
        holder.txtResultText.setText(bmi.getResultText());
        holder.txtResultNumber.setText(Float.toString(bmi.getResultNumber()));
        holder.txtDate.setText(bmi.getDate());
    }

    @Override
    public int getItemCount() {
        return bmiList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView txtMain, txtResultText, txtResultNumber, txtDate;

        public MyViewHolder(View view) {
            super(view);
            txtMain = (TextView) view.findViewById(R.id.txtMain);
            txtResultText = (TextView) view.findViewById(R.id.txtResultText);
            txtResultNumber = (TextView) view.findViewById(R.id.txtResultNumber);
            txtDate = (TextView) view.findViewById(R.id.txtDate);
        }

    }

}
