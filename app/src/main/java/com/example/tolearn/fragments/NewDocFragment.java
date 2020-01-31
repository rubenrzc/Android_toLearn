package com.example.tolearn.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

/**
 * @Author Andoni
 * this fragment takes care of adding
 * a new document
 *
 * not finished yet
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

    /**
     * onCreate method of newDocFragment
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_new_doc, container, false);
        //Upload animation
        final LottieAnimationView animationView = (LottieAnimationView)root.findViewById(R.id.animationLoadingNewDoc);
        animationView.setVisibility(View.GONE);


        etTittle = (EditText)root.findViewById(R.id.etTittle);
        multilineEtDesc = (EditText)root.findViewById(R.id.multilineEtDesc);
        imgBtnAdd = (ImageButton)root.findViewById(R.id.imgBtnAdd);
        bntUpload = (Button)root.findViewById(R.id.bntUpload);
        btnDiscard = (Button)root.findViewById(R.id.btnReturn);
        rButtonVisible = (RadioButton)root.findViewById(R.id.rButtonVisible);
        spinnerArea = (Spinner)root.findViewById(R.id.spinnerArea);

        //llenarSpinnerArea();


        imgBtnAdd.setOnClickListener(new View.OnClickListener() {
            /**
             * This onClick call addNewDocument() method
             * @param v
             */
            @Override
            public void onClick(View v) {
                addNewDocument();
            }
        });

        bntUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * This onClick add a new document
             */
            public void onClick(View v) {
                //Upload animation
                final LottieAnimationView animationView = (LottieAnimationView)root.findViewById(R.id.animationLoadingNewDoc);
                animationView.setVisibility(View.VISIBLE);
                animationView.playAnimation();
                //comprobarDatosDocumento();
                //generarNuevoDocumento();
            }
        });
        return root;
    }

    /**
     * Not implementet yet
     */
    private void addNewDocument() {

    }

    /**
     *  Not implementet yet
     */
    private void comprobarDatosDocumento() {
    }








}