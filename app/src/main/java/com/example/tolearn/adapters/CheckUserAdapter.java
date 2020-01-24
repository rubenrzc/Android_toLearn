package com.example.tolearn.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tolearn.R;
import com.example.tolearn.pojos.User;

import java.util.ArrayList;

public class CheckUserAdapter extends RecyclerView.Adapter<CheckUserAdapter.ViewHolderDatos>
                                implements View.OnClickListener{
    ArrayList<User>listUsers;
    private View.OnClickListener listener;

    public CheckUserAdapter(ArrayList<User> listUsers) {
        this.listUsers = listUsers;
    }

    @NonNull
    @Override
    public CheckUserAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_users
                    ,parent,false);

        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckUserAdapter.ViewHolderDatos holder, int position) {
       holder.idNameUser.setText(listUsers.get(position).getFullname());
       holder.idCompanyUser.setText(listUsers.get(position).getCompany().getName());
    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }

    public  void setOnClickLister(View.OnClickListener listener){
        this.listener = listener;

    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView idNameUser, idCompanyUser;
        ImageView idImage;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            idNameUser = (TextView) itemView.findViewById(R.id.idNameUser);
            idCompanyUser = (TextView) itemView.findViewById(R.id.idCompanyUser);
            idImage = (ImageView) itemView.findViewById(R.id.idImage);
        }
    }
}
