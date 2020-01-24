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
import com.example.tolearn.adapters.CheckUserAdapter;
import com.example.tolearn.adapters.DepartmentAdapter;
import com.example.tolearn.pojos.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckUsersFragment extends Fragment {

    private ArrayList<User> listUsers;
    private RecyclerView recycler;
    private CheckUserAdapter checkUserAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public CheckUsersFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_check_users, container, false);

        layoutManager = new LinearLayoutManager(getContext());
        recycler = (RecyclerView) root.findViewById(R.id.recyclerUsers);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(layoutManager);
        checkUserAdapter = new CheckUserAdapter(listUsers);
        recycler.setAdapter(checkUserAdapter);

        checkUserAdapter.setOnClickLister(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_checkUsers_to_nav_userProfile);
            }
        });



        // Inflate the layout for this fragment
        return root;
    }

}
