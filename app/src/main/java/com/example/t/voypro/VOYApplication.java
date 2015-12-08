package com.example.t.voypro;

import android.app.Application;
import android.content.Context;

public class VOYApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
