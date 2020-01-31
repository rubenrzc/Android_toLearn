package com.example.tolearn.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.tolearn.MenuActivity;
import com.example.tolearn.R;
import com.example.tolearn.interfaces.DocumentInterface;
import com.example.tolearn.pojos.Document;
import com.example.tolearn.pojos.DocumentStatus;
import com.example.tolearn.retrofit.DocumentAPIClient;

import java.util.ArrayList;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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


        //llenarSpinnerArea();


        imgBtnAdd.setOnClickListener(new View.OnClickListener() {
            /**
             * This onClick call addNewDocument() method
             * @param v
             */
            @Override
            public void onClick(View v) {
                FilePickerBuilder.getInstance().setMaxCount(1)
                        .setActivityTheme(R.style.LibAppTheme)
                        .pickFile(getActivity());
            }
        });


        bntUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * This onClick add a new document
             */
            public void onClick(View v) {

                boolean correct = true;
                correct = comprobarDatosDoc();

                if(correct==true){
                    addNewDocument();
                    //Upload animation
                    final LottieAnimationView animationView = (LottieAnimationView)root.findViewById(R.id.animationLoadingNewDoc);
                    animationView.setVisibility(View.VISIBLE);
                    animationView.playAnimation();
                }

                //comprobarDatosDocumento();
                //generarNuevoDocumento();
            }
        });
        return root;
    }

    private boolean comprobarDatosDoc() {
        boolean correct = true;

        if(etTittle.getText().toString().isEmpty()){
            etTittle.setError(getText(R.string.titleError));
        }if(multilineEtDesc.getText().toString().isEmpty()){
            etTittle.setError(getText(R.string.descError));
        }

        return correct;
    }

    /**
     * Not finished
     */
    private void addNewDocument() {
        newDoc.setName(etTittle.getText().toString());
        newDoc.setDescription(multilineEtDesc.getText().toString());
        if(rButtonVisible.isChecked()){
            newDoc.setVisibility(true);
        }else{
            newDoc.setVisibility(false);
        }
        newDoc.setStatus(DocumentStatus.DISABLED);
        newDoc.setUser(MenuActivity.getUser());

        DocumentInterface documentInterface = new DocumentAPIClient().getClient();
        Call<Void>call = documentInterface.createNewDocument(newDoc);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    if(response.code()==200){
                        Toast.makeText(getContext(),"Documento añadido",Toast.LENGTH_SHORT).show();
                    }if(response.code()==204){
                        Toast.makeText(getContext(),"Documento añadido",Toast.LENGTH_SHORT).show();

                    }
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("error","caused by: "+t.getMessage());
            }
        });

    }

    /**
     *  Not implementet yet
     */
    private void comprobarDatosDocumento() {

    }
}