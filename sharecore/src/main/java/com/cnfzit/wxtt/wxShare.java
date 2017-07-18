package com.cnfzit.wxtt;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by linzenos on 2017/7/11.
 */

public class wxShare {

    static {
        System.loadLibrary("cnshare");
    }

    public static native void shareToTimeLine(Bundle paramBundle, Activity paramActivity, String paramString1, String paramString2);

}
