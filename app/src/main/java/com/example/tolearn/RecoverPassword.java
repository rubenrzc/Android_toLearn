package com.example.tolearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.tolearn.interfaces.UserInterface;
import com.example.tolearn.pojos.User;
import com.example.tolearn.retrofit.UserAPIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecoverPassword extends AppCompatActivity {

    private EditText etEmail;
    private TextView tvRecover;
    private Button btnRecover;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);

        stopAnimation();

        etEmail = (EditText) findViewById(R.id.etEmail);
        tvRecover = (TextView) findViewById(R.id.tvRecover);
        btnRecover = (Button) findViewById(R.id.btnRecover);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LottieAnimationView animationView = (LottieAnimationView)findViewById(R.id.animationLoadingRecover);
                animationView.setVisibility(View.VISIBLE);
                animationView.playAnimation();

                checkEmailExist();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void checkEmailExist() {
        String email = etEmail.getText().toString();
        User user = new User();
        user.setEmail(email);

        UserInterface userInterface = UserAPIClient.getClient();

        Call<Void> call = (Call<Void>) userInterface.recoverPassword(user);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 200){
                    Toast.makeText(getApplicationContext(),"Recover password has been send to :"+email+" ",Toast.LENGTH_LONG).show();
                    stopAnimation();
                } else if (response.code() == 204){
                    etEmail.setError("That email does not exist ");
                    stopAnimation();
                } else if (response.code() == 400){
                    Toast.makeText(getApplicationContext(),"Email not found",Toast.LENGTH_LONG).show();
                } else if (response.code() == 401){
                    etEmail.setError("That email does not exist ");
                    stopAnimation();

                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                final LottieAnimationView animationView = (LottieAnimationView)findViewById(R.id.animationLoadingRecover);
                animationView.setVisibility(View.GONE);
            }
        });
    }

    private void stopAnimation() {
        final LottieAnimationView animationView = (LottieAnimationView)findViewById(R.id.animationLoadingRecover);
        animationView.pauseAnimation();
        animationView.setVisibility(View.GONE);
    }

}
