package com.example.tolearn.fragments;


import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tolearn.R;
import com.example.tolearn.pojos.Area;

/**
 * @Andoni
 * This fragment show the area
 * info and takes care of update and delete
 */
public class AreaProfile extends Fragment {

    private EditText etNameArea;
    private Button btnSaveArea;
    private Button btnDiscardArea;
    private Button btnUploadArea;
    private ImageButton imgBtDeleteArea;
    private Area area;

    public AreaProfile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_area_profile, container, false);

        Area area = AreaAdminFragment.getArea();


        etNameArea = (EditText)root.findViewById(R.id.etNameArea);
        btnSaveArea = (Button)root.findViewById(R.id.btnSaveArea);
        btnDiscardArea = (Button)root.findViewById(R.id.btnDiscardDep);
        btnUploadArea = (Button)root.findViewById(R.id.btnUploadArea);
        imgBtDeleteArea = (ImageButton) root.findViewById(R.id.imgBtDeleteArea);

        etNameArea.setText(area.getName());

        btnSaveArea.setVisibility(View.GONE);
        btnSaveArea.setEnabled(false);

        btnUploadArea.setOnClickListener(new View.OnClickListener() {
            /**
             * enable upadte
             * @param v
             */
            @Override
            public void onClick(View v) {
                btnSaveArea.setVisibility(View.VISIBLE);
                btnSaveArea.setEnabled(true);

                btnUploadArea.setVisibility(View.GONE);
                btnUploadArea.setEnabled(false);

                //TODO
            }
        });
        btnDiscardArea.setOnClickListener(new View.OnClickListener() {
            /**
             * Go back method
             * @param v
             */
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle(R.string.warning);
                dialogo1.setMessage(R.string.areYouSure);
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    /**
                     * @param dialogo1
                     * @param id
                     */
                    public void onClick(DialogInterface dialogo1, int id) {

                    }
                });
                dialogo1.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    /**
                     * negative button
                     * @param dialogo1
                     * @param id
                     */
                    public void onClick(DialogInterface dialogo1, int id) {
                        System.exit(0);
                    }
                });
                dialogo1.show();
            }
        });
        imgBtDeleteArea.setOnClickListener(new View.OnClickListener() {
            /**
             * Delete method
             * @param v
             */
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle(R.string.warning);
                dialogo1.setMessage(R.string.delete);
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    /**
                     * positive button
                     * @param dialogo1
                     * @param id
                     */
                    public void onClick(DialogInterface dialogo1, int id) {
                        //TODO
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

                    }
                });
                dialogo1.show();
            }
        });
        return root;
    }

}
