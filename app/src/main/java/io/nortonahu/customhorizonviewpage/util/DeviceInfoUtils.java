package io.nortonahu.customhorizonviewpage.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;

import io.nortonahu.customhorizonviewpage.AppContext;
import io.nortonahu.customhorizonviewpage.log.LogUtils;

/**
 * Created by hongyu on 2015/9/21.
 */
public class DeviceInfoUtils {
    /**
     * 返回屏幕密度跟dpi有关系但不是dpi
     */
    public static void getDensity() {

        DisplayMetrics displayMetrics = AppContext.getContext().getResources().getDisplayMetrics();
        LogUtils.e("yhtest", "Density is " + displayMetrics.density + " densityDpi is " + displayMetrics.densityDpi + " height: " + displayMetrics.heightPixels +
                " width: " + displayMetrics.widthPixels);
    }

    /**
     * 获取屏幕的实际物理尺寸大小
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void getScreenSize(Activity act) {
        // point
        Point point = new Point();
        act.getWindowManager().getDefaultDisplay().getRealSize(point);
        DisplayMetrics dm = AppContext.getContext().getResources().getDisplayMetrics();
        double x = Math.pow(point.x / dm.xdpi, 2);
        double y = Math.pow(point.y / dm.ydpi, 2);
        double screenInches = Math.sqrt(x + y);
        LogUtils.e("yhtest","Point:" + point.x + "|" +point.y + " dm:"
        + dm.xdpi + "|" + dm.ydpi + "screenInches:" + screenInches);
    }
}
