package com.example.tolearn.fragments;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tolearn.R;
import com.example.tolearn.adapters.DocumentsAdapter;
import com.example.tolearn.interfaces.AreaInterface;
import com.example.tolearn.interfaces.DocumentInterface;
import com.example.tolearn.pojos.Document;
import com.example.tolearn.pojos.plural.Documents;
import com.example.tolearn.retrofit.AreaAPIClient;
import com.example.tolearn.retrofit.DocumentAPIClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Author Fran
 * This fragment get all documents and
 * it show them on a RecyclerView
 */
public class PdfFragment extends Fragment {



    private RecyclerView recycler;
    private DocumentsAdapter documentdapter;
    private RecyclerView.LayoutManager layoutManager;
    private View root;


    public PdfFragment() {
        // Required empty public constructor
    }

    /**
     * onCreate method of fragment_pdf controller
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_pdf, container, false);

        cargarListaDocumentos();
        return root;
    }

    /**
     * This method take care of gettin all the documents
     * and to show them on the RecyclerView
     */
    private void cargarListaDocumentos() {

        DocumentInterface documentInterface = DocumentAPIClient.getClient();
        //Retrofit call
        Call<Documents>documents = documentInterface.findAll();
        documents.enqueue(new Callback<Documents>() {
            @Override
            /**
             * onResponse evnet
             */
            public void onResponse(Call<Documents> call, Response<Documents> response) {
                if(response.isSuccessful()){
                    if(response.code()==200){
                        Set<Document> doc = new HashSet<Document>();
                        //Saving the response.body()
                        for (Document d : response.body().getDocuments()) {
                            doc.add(d);
                        }
                        Log.d("msg","tamaño  "+ doc.size());

                        Document[] docs = new Document[doc.size()];
                        //Converting from Set<> to Array
                        doc.toArray(docs);
                        //Convertinh from Array to ArrayList
                        ArrayList<Document> listDocs = new ArrayList<Document>(Arrays.asList(docs));
                        //RecyclerView configuration
                        layoutManager = new LinearLayoutManager(getContext());
                        recycler = (RecyclerView) root.findViewById(R.id.recyclerView);
                        recycler.setHasFixedSize(true);
                        recycler.setLayoutManager(layoutManager);
                        documentdapter = new DocumentsAdapter(listDocs);
                        recycler.setAdapter(documentdapter);

                        documentdapter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            /**
                             * Documetn onClick event, it try to download the
                             * document to the device
                             */
                            public void onClick(View v) {

                                File dir = Environment.getExternalStorageDirectory();
                                File assist = new File("/mnt/sdcard/"+listDocs.get(recycler.getChildAdapterPosition(v)).getName()+".pdf");
                                try {
                                    InputStream fis = new FileInputStream(assist);

                                    long length = assist.length();
                                    if (length > Integer.MAX_VALUE) {
                                        Log.e("MainActivity", "cannnottt   readddd");
                                    }
                                    byte[] bytes = listDocs.get(recycler.getChildAdapterPosition(v)).getDocumentContent();
                                    int offset = 0;
                                    int numRead = 0;
                                    while (offset < bytes.length && (numRead = fis.read(bytes, offset, bytes.length - offset)) >= 0) {
                                        offset += numRead;
                                    }

                                    File data = new File(dir, listDocs.get(recycler.getChildAdapterPosition(v)).getName()+".pdf");
                                    OutputStream op = new FileOutputStream(data);
                                    op.write(bytes);
                                    Toast.makeText(getContext(),R.string.documentDownloaded,Toast.LENGTH_LONG).show();
                                } catch (Exception ex) {
                                    Log.e("error", "caused by " + ex.getMessage());
                                }

                                /*
                                Toast.makeText(getContext(),"prueba",Toast.LENGTH_LONG).show();
                                try {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                                        //Verifica permisos para Android 6.0+
                                        int permissionCheck = ContextCompat.checkSelfPermission(
                                                getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
                                        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                                            Log.i("Mensaje", "No se tiene permiso para leer.");
                                            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 225);
                                        } else {
                                            Log.i("Mensaje", "Se tiene permiso para leer!");
                                        }
                                    }
                                    String path = "/data/data/"+listDocs.get(recycler.getChildAdapterPosition(v)).getName()+"txt";
                                    File file = new File(path);
                                    if (!file.exists()) {
                                        file.createNewFile();
                                    }
                                    FileOutputStream stream = new FileOutputStream(path);
                                    stream.write(listDocs.get(recycler.getChildAdapterPosition(v)).getDocumentContent());
                                    Toast.makeText(getContext(),R.string.toast1,Toast.LENGTH_LONG).show();
                                } catch (FileNotFoundException e1) {
                                    e1.printStackTrace();
                                    Toast.makeText(getContext(),R.string.toast1,Toast.LENGTH_LONG).show();
                                    Log.d("error","caused by: "+e1.getMessage());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    Log.d("error","caused by: "+e.getMessage());
                                }*/
                            }
                        });
                        Log.d("msg","Estamos en el 200");
                    }
                }
            }

            /**
             * onFailure event of the call
             * @param call
             * @param t
             */
            @Override
            public void onFailure(Call<Documents> call, Throwable t) {
                Log.d("msg","Estamos en el on failure  "+t.getMessage());
            }
        });
    }
}
