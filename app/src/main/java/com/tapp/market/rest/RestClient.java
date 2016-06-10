package com.tapp.market.rest;

import android.content.Context;

import com.tapp.market.api.TappMarketService;
import com.tapp.market.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by John Robert Dichoso on 6/9/2016.
 */
public class RestClient {

    private static final String TAG = RestClient.class.getName();

    private static RestClient sRestClient;
    private static TappMarketService sTappMarketService;

    public static void init(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        sTappMarketService = retrofit.create(TappMarketService.class);
    }

    public static TappMarketService getTappMarketService() {
        return sTappMarketService;
    }

}
