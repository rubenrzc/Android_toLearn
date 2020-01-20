package com.example.tolearn.retrofit;
import com.example.tolearn.interfaces.DepartmentInterface;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import static retrofit2.converter.simplexml.SimpleXmlConverterFactory.create;

public class DepartmentAPIClient {
    private static String API_BASE_URL = "http://localhost:8080/grupo5_reto2/";
    public static DepartmentInterface getClient(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(
                        create()
                );
        Retrofit retrofit = builder.client(httpClient.build()).build();

        DepartmentInterface departmentInterface = retrofit.create(DepartmentInterface.class);
        return departmentInterface;
    }
}
