package com.example.tolearn.retrofit;
import com.example.tolearn.interfaces.AreaInterface;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import static retrofit2.converter.simplexml.SimpleXmlConverterFactory.create;

public class AreaAPIClient {
    private static String API_BASE_URL = "http://localhost:8080/grupo5_reto2/";
    public static AreaInterface getClient(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(
                        create()
                );
        Retrofit retrofit = builder.client(httpClient.build()).build();

        AreaInterface areaInterface = retrofit.create(AreaInterface.class);
        return areaInterface;
    }
}
