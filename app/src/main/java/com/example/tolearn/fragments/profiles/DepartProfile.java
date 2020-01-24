package com.example.tolearn.fragments.profiles;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class DepartProfile extends Fragment {

    private EditText etNameDep;
    private Button btnSaveDep;
    private Button btnDiscardDep;
    private Button btnUpload;
    private ImageButton imgBtDelete;

    public DepartProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_depart_profile, container, false);

        etNameDep = (EditText)root.findViewById(R.id.etNameArea);
        btnSaveDep = (Button)root.findViewById(R.id.btnSaveArea);
        btnDiscardDep = (Button)root.findViewById(R.id.btnDiscardDep);
        btnUpload = (Button)root.findViewById(R.id.btnUploadArea);
        imgBtDelete = (ImageButton) root.findViewById(R.id.imgBtDeleteArea);

        btnSaveDep.setVisibility(View.GONE);
        btnSaveDep.setEnabled(false);

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSaveDep.setVisibility(View.VISIBLE);
                btnSaveDep.setEnabled(true);

                btnUpload.setVisibility(View.GONE);
                btnUpload.setEnabled(false);

                //TODO
            }
        });
        btnDiscardDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle(R.string.warning);
                dialogo1.setMessage(R.string.areYouSure);
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {

                    }
                });
                dialogo1.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        System.exit(0);
                    }
                });
                dialogo1.show();
            }
        });
        imgBtDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle(R.string.warning);
                dialogo1.setMessage(R.string.delete);
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        //TODO
                        Toast.makeText(getContext(), R.string.deleted, Toast.LENGTH_SHORT).show();
                    }
                });
                dialogo1.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {

                    }
                });
                dialogo1.show();
            }
        });

        return root;
    }

}
