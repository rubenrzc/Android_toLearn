package com.example.tolearn.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tolearn.R;
import com.example.tolearn.pojos.Document;
import com.example.tolearn.pojos.DocumentStatus;

import java.util.Arrays;
import java.util.List;

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

        View root= inflater.inflate(R.layout.fragment_profile, container, false);

        etTittle = (EditText)root.findViewById(R.id.etTittle);
        multilineEtDesc = (EditText)root.findViewById(R.id.multilineEtDesc);
        imgBtnAdd = (ImageButton)root.findViewById(R.id.imgBtnAdd);
        bntUpload = (Button)root.findViewById(R.id.bntUpload);
        btnDiscard = (Button)root.findViewById(R.id.btnDiscard);
        rButtonVisible = (RadioButton)root.findViewById(R.id.rButtonVisible);
        spinnerArea = (Spinner)root.findViewById(R.id.spinnerArea);

        llenarSpinnerArea();


        imgBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewDocument();
            }
        });

        bntUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarDatosDocumento();
                generarNuevoDocumento();
            }
        });
        return inflater.inflate(R.layout.fragment_new_doc, container, false);
    }

    private void comprobarDatosDocumento() {
        if(etTittle.getText()==null){
            etTittle.setError("Not data found");
        }if(multilineEtDesc.getText()==null){
            multilineEtDesc.setError("Not data found");
        }
    }

    private void generarNuevoDocumento() {
        Byte[] doc;
        newDoc = new Document();
        newDoc.setName(etTittle.getText().toString());
        newDoc.setDescription(multilineEtDesc.getText().toString());
        if(rButtonVisible.isChecked()){
            newDoc.setVisibility(true);
        }else{
            newDoc.setVisibility(false);
        }
        newDoc.setStatus(DocumentStatus.DISABLED);
        doc = addNewDocument();
        newDoc.setDocumentContent(doc);

    }

    private Byte[] addNewDocument() {
        Byte[] doc = new Byte[0];
        //TODO

        return doc;
    }

    private void llenarSpinnerArea() {//TODO

        /*List<String>listSpinner = Arrays.asList("item1","item2");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext()
                ,android.R.layout.simple_spinner_item,listSpinner);
        spinnerArea.setAdapter(adapter);*/
    }



}