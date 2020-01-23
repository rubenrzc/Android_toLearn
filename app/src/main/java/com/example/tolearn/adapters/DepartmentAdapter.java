package com.example.tolearn.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tolearn.R;

import java.util.ArrayList;

public class DepartmentAdapter
        extends RecyclerView.Adapter<DepartmentAdapter.ViewHolderDatos>
        implements  View.OnClickListener{

    ArrayList<String>listDepart;
    private View.OnClickListener listener;

    public DepartmentAdapter(ArrayList<String> listDepart) {
        this.listDepart = listDepart;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_department
                        , parent,false);

        view.setOnClickListener(this);

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

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
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
