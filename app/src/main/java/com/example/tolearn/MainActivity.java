package com.example.tolearn;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tolearn.interfaces.UserInterface;
import com.example.tolearn.pojos.User;
import com.example.tolearn.retrofit.UserAPIClient;
import com.example.tolearn.sqlite.ConexionSQLiteHelper;
import com.example.tolearn.sqlite.LocalUser;

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
    private Switch switchRemember;
    private ConexionSQLiteHelper conn;

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
        switchRemember = (Switch) findViewById(R.id.switchRemember);
        network = isInternet();

        Animation animation= AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_in);
        btnLogIn.startAnimation(animation);
        btnRecover.startAnimation(animation);
        etUsername.startAnimation(animation);
        etPwd.startAnimation(animation);
        tvPwd.startAnimation(animation);
        tvTittle.startAnimation(animation);
        switchRemember.startAnimation(animation);




        if(network == false){
            Toast.makeText(getApplicationContext(),"NOT INTERNETEN CONECTION",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"INTERNETEN CONECTION",Toast.LENGTH_SHORT).show();
        }


        consultarUltimoUser();
        menuLauncher();
        recoverPassword();
    }

    private void recoverPassword() {
        btnRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RecoverPassword.class);
                startActivity(intent);
            }
        });
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
                            registrarUserEnSQLite();
                            Animation animation= AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_out);
                            btnLogIn.startAnimation(animation);
                            btnRecover.startAnimation(animation);
                            etUsername.startAnimation(animation);
                            etPwd.startAnimation(animation);
                            tvPwd.startAnimation(animation);
                            tvTittle.startAnimation(animation);
                            switchRemember.startAnimation(animation);
                            sonidoEncendido();
                            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                            intent.putExtra("user",response.body());
                            startActivity(intent);
                        }
                        if (response.code() == 401){
                            etPwd.setError("User not found");
                            sonidoError();
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

    private void sonidoEncendido() {
        MediaPlayer ring = MediaPlayer.create(MainActivity.this,R.raw.powersound);
        ring.start();
    }

    private void sonidoError() {
        MediaPlayer ring = MediaPlayer.create(MainActivity.this,R.raw.errorsound);
        ring.start();
    }

    private void registrarUserEnSQLite() {
        ConexionSQLiteHelper conexionSQLiteHelper = new ConexionSQLiteHelper(getApplicationContext());
        if (switchRemember.isChecked()) {
            LocalUser user = new LocalUser();
            user.setUsername(etUsername.getText().toString());
            user.setPwd(etPwd.getText().toString());
            user.setRemember(1);
            conexionSQLiteHelper.insertUser(user);

        } else {
            conexionSQLiteHelper.changeToNoRemember();
        }
        conexionSQLiteHelper.close();

    }
    private void consultarUltimoUser() {
        ConexionSQLiteHelper manager = new ConexionSQLiteHelper(this);
        LocalUser localUser = manager.getUser();
        manager.close();
        if (localUser != null) {
            if (localUser.getRemember() == 1) {
                switchRemember.setChecked(true);
                etUsername.setText(localUser.getUsername());
                etPwd.setText(localUser.getPwd());
            }
        }

    }
}