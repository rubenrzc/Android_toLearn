package com.example.tolearn.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tolearn.DepartmentAdaptor;
import com.example.tolearn.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DepartmentAdminFragment extends Fragment {

    ArrayList<String> listDepart;
    private RecyclerView recycler;
    private DepartmentAdaptor departmentAdaptor;
    private RecyclerView.LayoutManager layoutManager;

    public DepartmentAdminFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_department_admin, container, false);

        listDepart = new ArrayList<String>();

        for (int i = 0; i < 50; i++) {
            listDepart.add("Depart " + i + " ");
        }

        layoutManager = new LinearLayoutManager(getContext());
        recycler = (RecyclerView) root.findViewById(R.id.recyclerDepart);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(layoutManager);
        departmentAdaptor = new DepartmentAdaptor(listDepart);
        recycler.setAdapter(departmentAdaptor);


        return root;
    }

}
