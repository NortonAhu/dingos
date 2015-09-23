package io.nortonahu.customhorizonviewpage.base;

import android.app.Application;

/**
 * Created by hongyu on 2015/9/21.
 */
public class BaseApplication extends Application{

    private static  BaseApplication _Context;

    @Override
    public void onCreate() {
        super.onCreate();
        _Context = (BaseApplication)getApplicationContext();
    }

    public static BaseApplication getContext() {
        return _Context;
    }

}
