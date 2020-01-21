package com.example.tolearn;

import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
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

public class MainActivity extends AppCompatActivity {

    private Button btnLogIn;
    private Button btnRecover;
    private EditText etUsername;
    private EditText etPwd;
    private TextView tvPwd;
    private TextView tvTittle;
    private boolean network;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogIn = (Button) findViewById(R.id.btnLogIn);
        btnRecover = (Button) findViewById(R.id.btnRecover);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPwd = (EditText) findViewById(R.id.etPwd);
        tvPwd = (TextView) findViewById(R.id.tvPwd);
        tvTittle = (TextView) findViewById(R.id.tvTittle);

        network = isInternet();

        if(network == false){
            Toast.makeText(getApplicationContext(),"NOT INTERNETEN CONECTION",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"INTERNETEN CONECTION",Toast.LENGTH_SHORT).show();
        }



        menuLauncher();

    }

    private boolean isInternet() {
        boolean ret = false;
        ConnectivityManager connectivityManager;
        try{
            connectivityManager = (ConnectivityManager) getApplicationContext()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if((networkInfo != null) && (networkInfo.isAvailable()) && networkInfo.isConnected()){
                ret = true;
            }
        } catch (Exception e){
            Toast.makeText(getApplicationContext(),"Connectivity Exception", Toast.LENGTH_SHORT).show();
        }
        return ret;
    }

    private void menuLauncher() {
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLoginData();
            }

            private void checkLoginData() {
                final String pwd ;
                String loginName;

                loginName = etUsername.getText().toString();
                pwd = etPwd.getText().toString();

                UserInterface userInterface = UserAPIClient.getClient();

                Call<User> call = (Call<User>) userInterface.login(loginName, pwd);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.d("TRap",response.code()+" Adrian chico guapo");
                        if (response.code() == 200){
                            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                            intent.putExtra("user",response.body());
                            startActivity(intent);
                        }

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d("TRap","TRapatoni");
                        Toast.makeText(MainActivity.this, "MALAMENTE TRaP TRAP", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}