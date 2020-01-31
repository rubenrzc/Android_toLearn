package com.example.tolearn.fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tolearn.MenuActivity;
import com.example.tolearn.R;
import com.example.tolearn.interfaces.AreaInterface;
import com.example.tolearn.pojos.Area;
import com.example.tolearn.pojos.User;
import com.example.tolearn.retrofit.AreaAPIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Andoni
 * This fragment show the area
 * info and takes care of update and delete
 */
public class AreaProfile extends Fragment {

    private EditText etNameArea;
    private Button btnReturn;
    private Button btnUploadArea;
    private ImageButton imgBtDeleteArea;
    private Area area;
    private User user;

    public AreaProfile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_area_profile, container, false);

        Area area = AreaAdminFragment.getArea();
        user = MenuActivity.getUser();

        etNameArea = (EditText)root.findViewById(R.id.etNameArea);
        btnReturn = (Button)root.findViewById(R.id.btnReturn);
        btnUploadArea = (Button)root.findViewById(R.id.btnUploadArea);
        imgBtDeleteArea = (ImageButton) root.findViewById(R.id.imgBtDeleteArea);

        etNameArea.setText(area.getName());

        switch (user.getPrivilege()){

            case USER:
                btnUploadArea.setEnabled(false);
                btnUploadArea.setVisibility(View.GONE);
                imgBtDeleteArea.setEnabled(false);
                imgBtDeleteArea.setVisibility(View.GONE);
                etNameArea.setEnabled(false);
                break;
            case COMPANYADMIN:
                etNameArea.setEnabled(true);
                btnUploadArea.setEnabled(true);
                btnUploadArea.setVisibility(View.VISIBLE);
                imgBtDeleteArea.setEnabled(false);
                imgBtDeleteArea.setVisibility(View.GONE);
                break;
            case SUPERADMIN:
                btnUploadArea.setEnabled(true);
                btnUploadArea.setVisibility(View.VISIBLE);
                imgBtDeleteArea.setEnabled(true);
                imgBtDeleteArea.setVisibility(View.VISIBLE);
                break;
        }



        btnUploadArea.setOnClickListener(new View.OnClickListener() {
            /**
             * enable upadte
             * @param v
             */
            @Override
            public void onClick(View v) {

                btnUploadArea.setVisibility(View.GONE);
                btnUploadArea.setEnabled(false);

                uploadAreaName();

                //TODO
            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            /**
             * Go back method
             * @param v
             */
            @Override
                public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle(R.string.warning);
                dialogo1.setMessage(R.string.questionReturn);
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton(R.string.returnMenu, new DialogInterface.OnClickListener() {
                    /**
                     * @param dialogo1
                     * @param id
                     */
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(getContext(), MenuActivity.class);
                        startActivity(intent);
                    }
                });
                dialogo1.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    /**
                     * negative button
                     * @param dialogo1
                     * @param id
                     */
                    public void onClick(DialogInterface dialogo1, int id) {
                        dialogo1.dismiss();
                    }
                });
                dialogo1.show();
            }
        });
        imgBtDeleteArea.setOnClickListener(new View.OnClickListener() {
            /**
             * area delete method
             * @param v
             */
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle(R.string.warning);
                dialogo1.setMessage(R.string.delete);
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton(R.string.deleteArea, new DialogInterface.OnClickListener() {
                    /**
                     * positive button
                     * @param dialogo1
                     * @param id
                     */
                    public void onClick(DialogInterface dialogo1, int id) {
                        int areaId = AreaAdminFragment.getArea().getId();

                        AreaInterface areaInterface = new AreaAPIClient().getClient();
                        Call<Void> call = (Call<Void>) areaInterface.remove(areaId);
                        call.enqueue(new Callback<Void>() {
                            /**
                             * onResponse method of delete call
                             * @param call
                             * @param response
                             */
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.code()==204){
                                    Toast.makeText(getContext(),R.string.deletedArea,Toast.LENGTH_SHORT).show();
                                }else if(response.code()==200){
                                    Toast.makeText(getContext(),R.string.deletedArea,Toast.LENGTH_SHORT).show();
                                }
                            }

                            /**
                             * onFailure method
                             * @param call
                             * @param t
                             */
                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Log.d("error","Caused by: "+t.getMessage());
                            }
                        });

                        Toast.makeText(getContext(), R.string.deletedArea, Toast.LENGTH_SHORT).show();
                    }
                });
                dialogo1.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    /**
                     * negative button
                      * @param dialogo1
                     * @param id
                     */
                    public void onClick(DialogInterface dialogo1, int id) {
                        dialogo1.dismiss();
                    }
                });
                dialogo1.show();
            }
        });
        return root;
    }

    /**
     * This method upload the area name
     */
    private void uploadAreaName() {
        area = AreaAdminFragment.getArea();
        String newArea = etNameArea.getText().toString();
        area.setName(newArea);

        AreaInterface areaInterface = new AreaAPIClient().getClient();
        Call<Void> call = areaInterface.edit(area);
        call.enqueue(new Callback<Void>() {
            /**
             * if response is correct user get notified
             * @param call
             * @param response
             */
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code()==204){
                    Toast.makeText(getContext(),R.string.areaUpdated,Toast.LENGTH_SHORT).show();
                }else if(response.code()==200){
                    Toast.makeText(getContext(),R.string.areaUpdated,Toast.LENGTH_SHORT).show();
                }
            }

            /**
             * onFailure response
             * @param call
             * @param t
             */
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("error","caused by: "+t.getMessage());

            }
        });
    }

}
