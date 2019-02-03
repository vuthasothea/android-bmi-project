package app.sothea.com.bmiapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    private List<BmiEntiry> bmiList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BmiAdapter bmiAdapter;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        bmiList = AppDatabase.getAppDatatbase(getContext()).bmiDao().getAll();

        bmiAdapter = new BmiAdapter(bmiList);
        RecyclerView.LayoutManager bmiLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(bmiLayoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));


        recyclerView.setAdapter(bmiAdapter);

        return view;
    }

}
