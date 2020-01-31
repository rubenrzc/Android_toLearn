package com.example.tolearn.retrofit;

import com.example.tolearn.R;
import com.example.tolearn.interfaces.UserInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * @Author Fran
 */
public class UserAPIClient {
    private static String API_BASE_URL = "http://192.168.20.183:8080/grupo5_reto2_server-development_SERVER_Fran/webresources/user/";
    /**
     * This method convert the XML
     * @return a UserInterface
     */
    public static UserInterface getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create()).client(httpClient).build();

        UserInterface userInterface = builder.create(UserInterface.class);
        return userInterface;
    }
    public static UserInterface getClientText(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(ScalarsConverterFactory.create()).client(client).build();

        UserInterface userInterface =  builder.create(UserInterface.class);
        return userInterface;
    }

}
