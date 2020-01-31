package com.example.tolearn.retrofit;
import com.example.tolearn.R;
import com.example.tolearn.interfaces.AreaInterface;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static retrofit2.converter.simplexml.SimpleXmlConverterFactory.create;

/**
 * @Author Andoni
 */
public class AreaAPIClient {
    private static String API_BASE_URL = "http://192.168.29.1:8080/servidorFinalizado/webresources/area/";
    /**
     * This method convert the XML
     * @return a AreaInterface
     */
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
