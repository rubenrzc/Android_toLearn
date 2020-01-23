package com.example.tolearn.retrofit;
import com.example.tolearn.interfaces.CompanyInterface;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import static retrofit2.converter.simplexml.SimpleXmlConverterFactory.create;

public class CompanyAPIClient {
    private static String API_BASE_URL = "http://192.168.21.137:8080/grupo5_reto2_server/webresources/company/";
    public static CompanyInterface getClient(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(
                        create()
                );
        Retrofit retrofit = builder.client(httpClient.build()).build();

        CompanyInterface companyInterface = retrofit.create(CompanyInterface.class);
        return companyInterface;
    }
}
