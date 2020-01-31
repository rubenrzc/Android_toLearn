package com.example.tolearn.fragments;


import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tolearn.R;
import com.example.tolearn.adapters.AreaAdapter;
import com.example.tolearn.interfaces.AreaInterface;
import com.example.tolearn.pojos.Area;
import com.example.tolearn.pojos.plural.Areas;
import com.example.tolearn.retrofit.AreaAPIClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Author Andoni
 * This fragment get AreaList and its
 * shows on the RecyclerView
 */
public class AreaAdminFragment extends Fragment {

    private static Area areaName;
    private ArrayList<Area>listArea;
    private Set<Area>area;
    private RecyclerView recycler;
    private AreaAdapter areaAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button btnAddArea;
    private View root;




    public AreaAdminFragment() {
        // Required empty public constructor
    }
    public static Area getArea(){
        return areaName;
    }
    /**
     * onCreate method
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root =  inflater.inflate(R.layout.fragment_area_admin, container, false);

        btnAddArea = root.findViewById(R.id.btnAddArea);
        btnAddArea.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * launch addNewAera() method
             */
            public void onClick(View v) {
                addNewArea();
            }
        });


        llenarRecyclerArea();

        return root;
    }

    /**
     * Get areaList and shows on the recyclrer
     */
    private void llenarRecyclerArea() {

        AreaInterface areaInterface = AreaAPIClient.getClient();
        //Find all areas Retofit call
        Call<Areas>areas = areaInterface.FindAllArea();
        areas.enqueue(new Callback<Areas>() {
            /**
             * OnResponse method
             * @param call
             * @param response
             */
            @Override
            public void onResponse(Call<Areas> call, Response<Areas> response) {
                if(response.isSuccessful()){
                    if(response.code()==200){
                        Set<Area> areas = new HashSet<>();
                        //Saving areas
                        for(Area a : response.body().getAreas()){
                            areas.add(a);
                        }
                        Log.d("msg", "tamaño: "+areas.size());
                        Area[] area = new Area[areas.size()];
                        //Set<> to Array
                        areas.toArray(area);
                        //Array to ArrayList
                        ArrayList<Area> listArea = new ArrayList<Area>(Arrays.asList(area));
                        //RecyclerView configuration
                        layoutManager = new LinearLayoutManager(getContext());
                        recycler = (RecyclerView) root.findViewById(R.id.reyclerArea);
                        recycler.setHasFixedSize(true);
                        recycler.setLayoutManager(layoutManager);
                        areaAdapter = new AreaAdapter(listArea);
                        recycler.setAdapter(areaAdapter);
                        areaAdapter.setOnClickListener(new View.OnClickListener() {
                            /**
                             * Area addapter on click method, it launch
                             * AreaProfile fragment
                             * @param v
                             */
                            @Override
                            public void onClick(View v) {
                                areaName = listArea.get(recycler.getChildAdapterPosition(v));
                                Navigation.findNavController(v).navigate(R.id.action_nav_areaAdmin_to_nav_areaProfile);

                            }
                        });
                    }
                }
            }

            /**
             * Onfailure mehtod
             * @param call
             * @param t
             */
            @Override
            public void onFailure(Call<Areas> call, Throwable t) {
                Log.d("msg","Estamos en el on failure  "+t.getMessage());
            }
        });

    }

    /**
     * This method launch an alertdialog to
     * add a new area
     */
    private void addNewArea() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
        dialogo1.setTitle(R.string.btnAddArea);
        dialogo1.setMessage(R.string.addArea);
        final EditText input = new EditText(getContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        dialogo1.setView(input);
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                if(input.getText()==null){
                    input.setError(""+R.string.introduceName);
                }else{
                    Area area = new Area();
                    area.setName(input.getText().toString());
                    AreaInterface areaInterface = AreaAPIClient.getClient();
                    Call<Void> call = (Call<Void>)areaInterface.create(area);
                    call.enqueue(new Callback<Void>() {
                        /**
                         * onResponse method
                         * @param call
                         * @param response
                         */
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if(response.code()==204){
                                Toast.makeText(getContext(),R.string.areaCreated,Toast.LENGTH_LONG).show();
                            }
                        }

                        /**
                         * onFailure method
                         * @param call
                         * @param t
                         */
                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {

                        }
                    });
                }
            }
        });
        dialogo1.setNegativeButton(R.string.btnDiscard, new DialogInterface.OnClickListener() {
            /**
             * negative button
              * @param dialogo1
             * @param id
             */
            public void onClick(DialogInterface dialogo1, int id) {
            }
        });
        dialogo1.show();

    }
}

