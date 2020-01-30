package com.example.tolearn.fragments;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;


import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;


import com.airbnb.lottie.LottieAnimationView;
import com.example.tolearn.MenuActivity;
import com.example.tolearn.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExitFragment extends Fragment {

    private boolean exit = false;
    private View root;

    public ExitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root= inflater.inflate(R.layout.fragment_exit, container, false);

        final LottieAnimationView animationView = (LottieAnimationView)root.findViewById(R.id.exitAnimation);
        animationView.setVisibility(View.GONE);

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("¿ Estas seguro que desea salir del programa ?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                dialogo1.dismiss();
                MediaPlayer ring = MediaPlayer.create(getContext(),R.raw.apagando);
                ring.start();
                final LottieAnimationView animationView = (LottieAnimationView)root.findViewById(R.id.exitAnimation);
                animationView.setVisibility(View.VISIBLE);
                animationView.playAnimation();

            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                //TODO
            }
        });
        dialogo1.show();

        return root;
    }
}