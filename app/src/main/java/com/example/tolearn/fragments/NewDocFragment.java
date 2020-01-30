package com.example.tolearn.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.airbnb.lottie.LottieAnimationView;
import com.example.tolearn.R;
import com.example.tolearn.pojos.Document;
import com.example.tolearn.pojos.DocumentStatus;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewDocFragment extends Fragment {

    private EditText etTittle;
    private EditText multilineEtDesc;
    private ImageButton imgBtnAdd;
    private Button bntUpload;
    private Button btnDiscard;
    private RadioButton rButtonVisible;
    private Spinner spinnerArea;

    private Document newDoc;



    public NewDocFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_new_doc, container, false);

        final LottieAnimationView animationView = (LottieAnimationView)root.findViewById(R.id.animationLoadingNewDoc);
        animationView.setVisibility(View.GONE);


        etTittle = (EditText)root.findViewById(R.id.etTittle);
        multilineEtDesc = (EditText)root.findViewById(R.id.multilineEtDesc);
        imgBtnAdd = (ImageButton)root.findViewById(R.id.imgBtnAdd);
        bntUpload = (Button)root.findViewById(R.id.bntUpload);
        btnDiscard = (Button)root.findViewById(R.id.btnDiscardDep);
        rButtonVisible = (RadioButton)root.findViewById(R.id.rButtonVisible);
        spinnerArea = (Spinner)root.findViewById(R.id.spinnerArea);

        //llenarSpinnerArea();


        imgBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewDocument();
            }
        });

        bntUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LottieAnimationView animationView = (LottieAnimationView)root.findViewById(R.id.animationLoadingNewDoc);
                animationView.setVisibility(View.VISIBLE);
                animationView.playAnimation();
                //comprobarDatosDocumento();
                //generarNuevoDocumento();
            }
        });
        return root;
    }

    private void addNewDocument() {

    }

    private void comprobarDatosDocumento() {
        if(etTittle.getText()==null){
            etTittle.setError("Not data found");
        }if(multilineEtDesc.getText()==null){
            multilineEtDesc.setError("Not data found");
        }
    }








}