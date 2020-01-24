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
public class AreaProfile extends Fragment {

    private EditText etNameArea;
    private Button btnSaveArea;
    private Button btnDiscardArea;
    private Button btnUploadArea;
    private ImageButton imgBtDeleteArea;

    public AreaProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_area_profile, container, false);

        etNameArea = (EditText)root.findViewById(R.id.etNameArea);
        btnSaveArea = (Button)root.findViewById(R.id.btnSaveArea);
        btnDiscardArea = (Button)root.findViewById(R.id.btnDiscardDep);
        btnUploadArea = (Button)root.findViewById(R.id.btnUploadArea);
        imgBtDeleteArea = (ImageButton) root.findViewById(R.id.imgBtDeleteArea);

        btnSaveArea.setVisibility(View.GONE);
        btnSaveArea.setEnabled(false);

        btnUploadArea.setOnClickListener(new View.OnClickListener() {
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
        imgBtDeleteArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                dialogo1.setTitle(R.string.warning);
                dialogo1.setMessage(R.string.delete);
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        //TODO
                        Toast.makeText(getContext(), R.string.deletedArea, Toast.LENGTH_SHORT).show();
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
