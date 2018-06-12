package com.thanggun99.baithi;

import android.app.Application;
import android.content.Context;

/**
 * Created by Thanggun99 on 25/03/2017.
 */

public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        this.context = this;
        super.onCreate();
    }

    public static Context getContext() {
        return context;
    }
}
