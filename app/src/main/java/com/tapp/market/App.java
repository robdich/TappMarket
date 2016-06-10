package com.tapp.market;

import android.app.Application;

import com.tapp.market.rest.RestClient;

/**
 * Created by John Robert Dichoso on 6/9/2016.
 */
public class App extends Application {

    private static final String TAG = App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        RestClient.init(this);
    }
}
