package com.example.tolearn;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DocumentsAdapter extends RecyclerView.Adapter<DocumentsAdapter.ViewHolderDocuments> {
    @NonNull
    @Override
    public ViewHolderDocuments onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDocuments holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderDocuments extends RecyclerView.ViewHolder {
        public ViewHolderDocuments(@NonNull View itemView) {
            super(itemView);
        }
    }
}
