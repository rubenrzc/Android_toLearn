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
import com.example.tolearn.MainActivity;
import com.example.tolearn.MenuActivity;
import com.example.tolearn.R;

/**
 * @Author Yeray
 * fragment_exit fragment controller
 */
public class ExitFragment extends Fragment {

    private boolean exit = false;
    private View root;

    public ExitFragment() {
        // Required empty public constructor
    }

    /**
     * onCreate method of exit_fragment
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root= inflater.inflate(R.layout.fragment_exit, container, false);

        //Lotie Animation
        final LottieAnimationView animationView = (LottieAnimationView)root.findViewById(R.id.exitAnimation);
        animationView.setVisibility(View.GONE);

        //Custom alertDialog
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
        dialogo1.setTitle(R.string.dialog1Title);
        dialogo1.setMessage(R.string.dialog1Question);
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton(R.string.btnpositive, new DialogInterface.OnClickListener() {
            /**
             * positive button onClick event
             * @param dialogo1
             * @param id
             */
            public void onClick(DialogInterface dialogo1, int id) {
                //Close dialog
                dialogo1.dismiss();
                //Start playing apagando.mp3
                MediaPlayer ring = MediaPlayer.create(getContext(),R.raw.apagando);
                ring.start();
                //Exit animation
                final LottieAnimationView animationView = (LottieAnimationView)root.findViewById(R.id.exitAnimation);
                animationView.setVisibility(View.VISIBLE);
                animationView.playAnimation();

                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        dialogo1.setNegativeButton(R.string.btnnegative, new DialogInterface.OnClickListener() {
            /**
             * negative button onClick event
             * @param dialogo1
             * @param id
             */
            public void onClick(DialogInterface dialogo1, int id) {
                Intent intent = new Intent(getContext(), MenuActivity.class);
                startActivity(intent);
                dialogo1.dismiss();
            }
        });
        dialogo1.show();

        return root;
    }
}