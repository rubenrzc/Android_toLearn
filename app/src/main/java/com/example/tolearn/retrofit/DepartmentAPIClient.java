package com.example.tolearn.retrofit;
import com.example.tolearn.interfaces.DepartmentInterface;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static retrofit2.converter.simplexml.SimpleXmlConverterFactory.create;

/**
 * @Author Yeray
 */
public class DepartmentAPIClient {

    private static String API_BASE_URL = "http://192.168.0.17:8080/grupo5_reto2_server/webresources/department/";
    /**
     * This method convert the XML
     * @return a DepartmentInterface
     */
    public static DepartmentInterface getClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create()).client(httpClient).build();


        DepartmentInterface departmentInterface = builder.create(DepartmentInterface.class);
        return departmentInterface;
    }
}
