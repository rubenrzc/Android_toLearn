package com.example.tolearn.retrofit;
import com.example.tolearn.interfaces.AreaInterface;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static retrofit2.converter.simplexml.SimpleXmlConverterFactory.create;

public class AreaAPIClient {
    private static String API_BASE_URL = "http://192.168.20.153:8080/grupo5_reto2_server/webresources/area/";
    public static AreaInterface getClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create()).client(httpClient).build();

        AreaInterface areaInterface = builder.create(AreaInterface.class);
        return areaInterface;
    }
}
