package com.example.tolearn.fragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tolearn.MainActivity;
import com.example.tolearn.MenuActivity;
import com.example.tolearn.R;
import com.example.tolearn.interfaces.UserInterface;
import com.example.tolearn.pojos.User;
import com.example.tolearn.retrofit.UserAPIClient;

import java.io.ByteArrayOutputStream;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private ImageView ivHeader;
    private CircleImageView CircleImageUser;
    private TextView etUsernameProf;
    private EditText etEmail;
    private EditText etFullName;
    private EditText etBirthDate;
    private TextView tvCompProf;
    private ImageButton imgBtEdit;
    private ImageButton imgBtPhoto;
    private User user;
    private int progress=0;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_profile, container, false);

        ivHeader = (ImageView)root.findViewById(R.id.ivHeader);
        etUsernameProf = (TextView) root.findViewById(R.id.etUsernameProf);
        etEmail = (EditText)root.findViewById(R.id.etEmail);
        etFullName = (EditText)root.findViewById(R.id.etFullName);
        tvCompProf = (TextView) root.findViewById(R.id.tvCompProf);
        imgBtEdit = (ImageButton)root.findViewById(R.id.imgBtEdit);
        imgBtPhoto = (ImageButton)root.findViewById(R.id.imgBtPhoto);
        CircleImageUser = (CircleImageView)root.findViewById(R.id.CircleImageUser);

        etUsernameProf.setEnabled(false);
        etEmail.setEnabled(false);
        etFullName.setEnabled(false);
        imgBtPhoto.setEnabled(false);

        imgBtPhoto.setVisibility(View.GONE);

        user=MenuActivity.getUser();

        etUsernameProf.setText(user.getLogin());
        etEmail.setText(user.getEmail());
        etFullName.setText(user.getFullname());
        tvCompProf.setText(user.getCompany().getName());

        Bitmap bitmap = BitmapFactory.decodeByteArray(user.getPhoto() , 0, user.getPhoto() .length);

        CircleImageUser.setImageBitmap(bitmap);

        imgBtEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtEdit.setImageResource(R.drawable.ic_save_black_24dp);

                imgBtPhoto.setEnabled(true);

                etUsernameProf.setEnabled(true);
                etEmail.setEnabled(true);
                etFullName.setEnabled(true);
                imgBtPhoto.setEnabled(true);
                imgBtPhoto.setVisibility(View.VISIBLE);

                imgBtPhoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent,0);
                    }
                });

                imgBtEdit.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        user.setLogin(etUsernameProf.getText().toString());

                        UserInterface userInterface = UserAPIClient.getClient();

                        Call<Void>call=userInterface.edit(user);
                        call.enqueue(new Callback<Void>() {
                            ProgressBar simpleProgressBar = (ProgressBar)root.findViewById(R.id.progressBar);

                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.code()==204){
                                    Log.d("mensaje","todo ok");

                                    simpleProgressBar.setVisibility(View.VISIBLE);
                                    simpleProgressBar.setProgress(1);

                                    Toast.makeText(getContext(), "Usuario modificado correctamente", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {

                            }
                        });
                    }

                });
            }
        });

        return root;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        CircleImageUser.setImageBitmap(bitmap);

       /* Bitmap bmp = intent.getExtras().get("data");
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        bmp.recycle();*/

    }

}
