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

import java.util.ArrayList;

public class DocumentsAdapter extends RecyclerView.Adapter<DocumentsAdapter.ViewHolderDocuments> {

    ArrayList<Document>listaDocumentos;

    public DocumentsAdapter(ArrayList<Document> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    @Override
    public ViewHolderDocuments onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_pdf,null,false);

        return new ViewHolderDocuments(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDocuments holder, int position) {
        holder.idTittle.setText(listaDocumentos.get(position).getName());
        holder.idDesc.setText(listaDocumentos.get(position).getDescription());
        holder.idImage.setImageResource(R.drawable.user);
    }

    @Override
    public int getItemCount() {
        return listaDocumentos.size();
    }

    public class ViewHolderDocuments extends RecyclerView.ViewHolder {

        TextView idTittle,idDesc;
        ImageView idImage;

        public ViewHolderDocuments(@NonNull View itemView) {
            super(itemView);
            idTittle = (TextView)itemView.findViewById(R.id.idTittle);
            idDesc = (TextView)itemView.findViewById(R.id.idDesc);
            idImage = (ImageView) itemView.findViewById(R.id.idImage);
        }
    }
}