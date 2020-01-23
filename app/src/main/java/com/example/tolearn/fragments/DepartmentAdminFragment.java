package com.example.tolearn.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tolearn.adapters.DepartmentAdapter;
import com.example.tolearn.R;
import com.example.tolearn.interfaces.DepartmentInterface;
import com.example.tolearn.pojos.Department;
import com.example.tolearn.pojos.plural.Departments;
import com.example.tolearn.retrofit.DepartmentAPIClient;

import java.util.ArrayList;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DepartmentAdminFragment extends Fragment {

    private ArrayList<String> listDepart;
    private RecyclerView recycler;
    private DepartmentAdapter departmentAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public DepartmentAdminFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_department_admin, container, false);

        listDepart = new ArrayList<String>();

        listDepart = llenarDepartmentRecycler();


        layoutManager = new LinearLayoutManager(getContext());
        recycler = (RecyclerView) root.findViewById(R.id.recyclerDepart);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(layoutManager);
        departmentAdapter = new DepartmentAdapter(listDepart);
        recycler.setAdapter(departmentAdapter);

        departmentAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_departmentAdmin_to_nav_departProfile);
            }
        });

        return root;
    }

    private ArrayList<String> llenarDepartmentRecycler() {
        ArrayList<String>departments;

        departments = new ArrayList<String>();

        DepartmentInterface departmentInterface = DepartmentAPIClient.getClient();
        Call<Departments>call = departmentInterface.FindAllDepartment();
        call.enqueue(new Callback<Departments>() {
            @Override
            public void onResponse(Call<Departments> call, Response<Departments> response) {
                if(response.code()==200){
                    Departments dep = response.body();
                }

            }

            @Override
            public void onFailure(Call<Departments> call, Throwable t) {

            }
        });

        return departments;
    }

}
