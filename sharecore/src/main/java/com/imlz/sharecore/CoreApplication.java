package com.imlz.sharecore;

import android.app.Application;

/**
 * Created by linzenos on 2017/7/17.
 */

public class CoreApplication extends Application {

    public static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
