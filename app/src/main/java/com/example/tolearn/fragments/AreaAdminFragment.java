package com.example.tolearn.fragments;


import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.example.tolearn.retrofit.AreaAPIClient;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AreaAdminFragment extends Fragment {

    private ArrayList<String> listArea;
    private RecyclerView recycler;
    private AreaAdapter areaAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button btnAddArea;

    public AreaAdminFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_area_admin, container, false);

        btnAddArea = root.findViewById(R.id.btnAddArea);
        btnAddArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewArea();
            }
        });


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
                    input.setError("introduce name");
                }else{
                    Area area = new Area();
                    area.setName(input.getText().toString());

                    AreaInterface areaInterface = AreaAPIClient.getClient();
                    Call<Void> call = (Call<Void>)areaInterface.create(area);
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if(response.code()==204){
                                Toast.makeText(getContext(),"Area created",Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {

                        }
                    });
                }

            }
        });
        dialogo1.setNegativeButton(R.string.btnDiscard, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo1.show();
    }

    private ArrayList<String> llenarListAreas() {
        ArrayList<String>listAreas = new ArrayList<String>();



        return listAreas;
    }

}
