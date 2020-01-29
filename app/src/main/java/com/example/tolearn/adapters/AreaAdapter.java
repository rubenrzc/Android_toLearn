package com.example.tolearn.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.tolearn.R;
import com.example.tolearn.pojos.Area;

import java.util.ArrayList;
import java.util.Set;

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolderDatos>
                            implements View.OnClickListener{

    ArrayList<Area>listAreas;



    private View.OnClickListener listener;

    public AreaAdapter(Set<Area> listAreas) {
        this.listAreas.addAll(listAreas);
    }

    @NonNull
    @Override
    public AreaAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_area
                        , parent,false);

        view.setOnClickListener(this);
        return new AreaAdapter.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AreaAdapter.ViewHolderDatos holder, int position) {
        holder.asignarDatos(listAreas.get(position));
    }

    @Override
    public int getItemCount() {
        return listAreas.size();
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
        TextView idAreaName;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            idAreaName = (TextView)itemView.findViewById(R.id.idAreaName);
        }

        public void asignarDatos(Area area) {
            idAreaName.setText(area.getName());
        }
    }
}
