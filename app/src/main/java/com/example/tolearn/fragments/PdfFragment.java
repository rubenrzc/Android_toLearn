package com.example.tolearn.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.tolearn.R;
import com.example.tolearn.adapters.DocumentsAdapter;
import com.example.tolearn.interfaces.DocumentInterface;
import com.example.tolearn.pojos.Document;
import com.example.tolearn.pojos.plural.Documents;
import com.example.tolearn.retrofit.DocumentAPIClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PdfFragment extends Fragment {


    private ImageButton imgBtSearch;
    private EditText etSearchDoc;
    private RecyclerView recycler;
    private DocumentsAdapter documentdapter;
    private RecyclerView.LayoutManager layoutManager;
    private View root;


    public PdfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_pdf, container, false);

        imgBtSearch = (ImageButton)root.findViewById(R.id.imgBtSearch);
        etSearchDoc = (EditText) root.findViewById(R.id.etSearchDoc);

        cargarListaDocumentos();
        imgBtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etSearchDoc.getText()==null){
                    etSearchDoc.setError("Introduce document name");
                }
            }
        });

        return root;
    }

    private void cargarListaDocumentos() {
        ArrayList<Document>docs;
        docs = new ArrayList<Document>();


        DocumentInterface documentInterface = DocumentAPIClient.getClient();
        Set<Document>listDocuments = new HashSet<>();
        Call<Documents>documents = documentInterface.findAll();
        documents.enqueue(new Callback<Documents>() {
            @Override
            public void onResponse(Call<Documents> call, Response<Documents> response) {
                if(response.isSuccessful()){
                    if(response.code()==200){
                        Set<Document> doc = new HashSet<Document>();
                        for (Document d : response.body().getDocuments()) {
                            doc.add(d);
                        }
                        Log.d("msg","tamaño  "+ doc.size());

                        Document[] docs = new Document[doc.size()];
                        doc.toArray(docs);
                        ArrayList<Document> listDocs = new ArrayList<Document>(Arrays.asList(docs));
                        layoutManager = new LinearLayoutManager(getContext());
                        recycler = (RecyclerView) root.findViewById(R.id.recyclerView);
                        recycler.setHasFixedSize(true);
                        recycler.setLayoutManager(layoutManager);
                        documentdapter = new DocumentsAdapter(listDocs);
                        recycler.setAdapter(documentdapter);


                        Log.d("msg","Estamos en el 200");

                    }
                }

            }



            @Override
            public void onFailure(Call<Documents> call, Throwable t) {
                Log.d("msg","Estamos en el on failure  "+t.getMessage());
            }
        });


    }

    private void listDocuments(Documents documents) {


    }

}
