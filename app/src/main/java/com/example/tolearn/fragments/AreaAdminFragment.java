package com.example.tolearn.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tolearn.R;
import com.example.tolearn.adapters.AreaAdapter;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AreaAdminFragment extends Fragment {

    private ArrayList<String> listArea;
    private RecyclerView recycler;
    private AreaAdapter areaAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public AreaAdminFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_area_admin, container, false);

        listArea = new ArrayList<String>();

        listArea = llenarListAreas();
        layoutManager = new LinearLayoutManager(getContext());
        recycler = (RecyclerView) root.findViewById(R.id.reyclerArea);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(layoutManager);
        areaAdapter = new AreaAdapter(listArea);
        recycler.setAdapter(areaAdapter);

        areaAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_areaAdmin_to_nav_areaProfile);
            }
        });

        return root;
    }

    private ArrayList<String> llenarListAreas() {
        ArrayList<String>listAreas = new ArrayList<String>();



        return listAreas;
    }

}
