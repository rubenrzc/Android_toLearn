package com.example.tolearn.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tolearn.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PdfFragment extends Fragment {



    public PdfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pdf, container, false);

        // Inflate the layout for this fragment
        return root;
    }

}
