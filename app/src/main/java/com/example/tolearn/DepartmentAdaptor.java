package com.example.tolearn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DepartmentAdaptor extends RecyclerView.Adapter<DepartmentAdaptor.ViewHolderDatos> {

    ArrayList<String>listDepart;

    public DepartmentAdaptor(ArrayList<String> listDepart) {
        this.listDepart = listDepart;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.department_item_list
                        , parent,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatosDepart(listDepart.get(position));
    }

    @Override
    public int getItemCount() {
        return listDepart.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView idDepartName;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            idDepartName = (TextView) itemView.findViewById(R.id.idDepartName);
        }

        public void asignarDatosDepart(String datos) {
            idDepartName.setText(datos);
        }
    }
}
