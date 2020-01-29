package com.example.tolearn;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Context;
import android.content.Intent;
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

import com.airbnb.lottie.LottieAnimationView;
import com.example.tolearn.interfaces.UserInterface;
import com.example.tolearn.pojos.User;
import com.example.tolearn.retrofit.UserAPIClient;
import com.example.tolearn.sqlite.ConexionSQLiteHelper;
import com.example.tolearn.sqlite.LocalUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @Author Andoni
 * Main activity of the aplication,
 * it takes care of login
 */
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
        final LottieAnimationView animationView = (LottieAnimationView)findViewById(R.id.animationLoadingMain);

        animationView.setVisibility(View.GONE);


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

    /**
     * this method launch the RecoverPassword activity
     */
    private void recoverPassword() {
        btnRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RecoverPassword.class);
                startActivity(intent);
            }
        });
    }

    /**
     * it checks if the device have internet conexion
     * @return true if the user have internet conexion
     */
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

    /**
     * this method launch the menu activity
     */
    private void menuLauncher() {
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LottieAnimationView animationView = (LottieAnimationView)findViewById(R.id.animationLoadingMain);
                animationView.setVisibility(View.VISIBLE);
                animationView.playAnimation();
                animationView.loop(true);
                checkLoginData();
            }

            /**
             * This method takes care of login
             * the user on the aplication
             */
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
                            //stopAnimation();
                        }
                        if (response.code() == 404){
                            etPwd.setError("User not found");
                            sonidoError();
                            //stopAnimation();
                        }

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                        Log.d("TRap","TRapatoni "+t.getMessage());
                        Toast.makeText(MainActivity.this, "MALAMENTE TRaP TRAP", Toast.LENGTH_SHORT).show();
                        //stopAnimation();
                    }
                });
            }
        });
    }

    /**
     * This method launch a sound
     */
    private void sonidoEncendido() {
        MediaPlayer ring = MediaPlayer.create(MainActivity.this,R.raw.powersound);
        ring.start();
    }

    /**
     * This method launch a sound
     */
    private void sonidoError() {
        MediaPlayer ring = MediaPlayer.create(MainActivity.this,R.raw.errorsound);
        ring.start();
    }

    /**
     * This method chech the status of the
     * Switch switchRemember, if it is checked its
     * save the user in the SQLite database
     */
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

    /**
     * This method takes care of remember the last
     * user that have made login in his smartphonme
     */
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
    /*private void stopAnimation() {
        final LottieAnimationView animationView = (LottieAnimationView)findViewById(R.id.animationLoadingRecover);
        animationView.setVisibility(View.GONE);
    }*/
}