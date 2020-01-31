package com.example.tolearn.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tolearn.R;
import com.example.tolearn.pojos.Document;
import com.example.tolearn.pojos.plural.Documents;

import java.util.ArrayList;
import java.util.Set;

/**
 * @Author Ruben
 * Document Recycler view adapter
 */
public class DocumentsAdapter extends RecyclerView.Adapter<DocumentsAdapter.ViewHolderDocuments>
        implements View.OnClickListener{

    ArrayList<Document>listaDocumentos;
    private View.OnClickListener listener;

    public DocumentsAdapter(ArrayList<Document> listaDocumentos) {
        this.listaDocumentos=listaDocumentos;
    }

    /**
     * DocumentAdapter ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolderDocuments onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_document,null,false);

        view.setOnClickListener(this);

        return new ViewHolderDocuments(view);
    }

    /**
     * Load the data into the textViews
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolderDocuments holder, int position) {
        holder.idTittle.setText(listaDocumentos.get(position).getName());
        holder.idDesc.setText(listaDocumentos.get(position).getDescription());
    }

    /**
     * @return position
     */
    @Override
    public int getItemCount() {
        return listaDocumentos.size();
    }

    /**
     * This method is to make the recycles an
     * onClickListener
     * @param listener
     */
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    /**
     * @param v
     */
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    /**
     * ViewHolderDocument class
     */
    public class ViewHolderDocuments extends RecyclerView.ViewHolder {

        TextView idTittle,idDesc;

        /**
         * @param itemView
         */
        public ViewHolderDocuments(@NonNull View itemView) {
            super(itemView);
            idTittle = (TextView)itemView.findViewById(R.id.idTittleDoc);
            idDesc = (TextView)itemView.findViewById(R.id.idDescDoc);

        }
    }
}