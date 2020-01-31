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

/**
 * @Author Andoni
 * Area recyclerView adapter
 */
public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolderDatos>
        implements View.OnClickListener{

    ArrayList<Area>listAreas;

    private View.OnClickListener listener;

    public AreaAdapter(ArrayList<Area> listAreas) {
        this.listAreas = listAreas;
    }

    /**
     * AreaAdapter viewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public AreaAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_area
                        , parent,false);

        view.setOnClickListener(this);
        return new AreaAdapter.ViewHolderDatos(view);
    }

    /**
     * Load the data into the textViews
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull AreaAdapter.ViewHolderDatos holder, int position) {
        holder.asignarDatos(listAreas.get(position));
    }

    /**
     * @return position
     */
    @Override
    public int getItemCount() {
        return listAreas.size();
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
     * ViewHolderDatos class
     */
    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView idAreaName;

        /**
         * @param itemView
         */
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            idAreaName = (TextView)itemView.findViewById(R.id.idAreaName);
        }

        /**
         * @param area
         */
        public void asignarDatos(Area area) {
            idAreaName.setText(area.getName());
        }
    }
}
