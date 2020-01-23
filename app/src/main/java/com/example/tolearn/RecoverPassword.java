package com.example.tolearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        etEmail = (EditText) findViewById(R.id.etEmail);
        tvRecover = (TextView) findViewById(R.id.tvRecover);
        btnRecover = (Button) findViewById(R.id.btnRecover);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                } else if (response.code() == 204){
                    etEmail.setError("That email does not exist ");
                } else if (response.code() == 400){
                    Toast.makeText(getApplicationContext(),"Email not found",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

}
