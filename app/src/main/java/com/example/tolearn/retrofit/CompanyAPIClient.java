package com.example.tolearn.retrofit;
import com.example.tolearn.interfaces.CompanyInterface;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static retrofit2.converter.simplexml.SimpleXmlConverterFactory.create;

/**
 * @Author Andoni
 */
public class CompanyAPIClient {
    private static String API_BASE_URL = "http://192.168.0.17:8080/grupo5_reto2_server/webresources/company/";
    /**
     * This method convert the XML
     * @return a CompanyInterface
     */
    public static CompanyInterface getClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create()).client(httpClient).build();


        CompanyInterface companyInterface = builder.create(CompanyInterface.class);
        return companyInterface;
    }
}
