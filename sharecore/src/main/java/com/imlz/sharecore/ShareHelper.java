package com.imlz.sharecore;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.support.annotation.DrawableRes;

import java.util.List;

/**
 * Created by linzenos on 2017/7/13.
 */

public class ShareHelper {


    /**
     * 通过图片ID获取资源路径
     *
     * @param context
     * @param id
     * @return
     */
    public static String getResourcesUri(Context context, @DrawableRes int id) {
        Resources resources = context.getResources();
        String uriPath = ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                resources.getResourcePackageName(id) + "/" +
                resources.getResourceTypeName(id) + "/" +
                resources.getResourceEntryName(id);
        return uriPath;
    }

    /**
     * 根据平台获取包名
     *
     * @param platform
     * @return
     */
    public static String getPacketNameByPlat(String platform) {
        if (platform.equalsIgnoreCase(Constant.PLATFORM_WECHAT)) {
            return Constant.WECHAT_PACKAGE_NAME;
        } else if (platform.equalsIgnoreCase(Constant.PLATFORM_WECHAT_MONMENT)) {
            return Constant.WECHAT_MONMENT_PACKAGE_NAME;
        } else if (platform.equalsIgnoreCase(Constant.PLATFORM_QQ)) {
            return Constant.QQ_PACKAGE_NAME;
        } else if (platform.equalsIgnoreCase(Constant.PLATFORM_QZONE)) {
            return Constant.QZONE_PACKAGE_NAME;
        }
        return Constant.WECHAT_PACKAGE_NAME;
    }

    /**
     * 检测应用是否按照
     *
     * @param context
     * @param packageName
     * @param activityName
     * @return
     */
    public static boolean isInstalled(Context context, String packageName, String activityName) {
        Intent intent = new Intent();
        intent.setClassName(packageName, activityName);
        List<ResolveInfo> list = context.getPackageManager().queryIntentActivities(intent, 0);
        if (list.size() > 0) {
            return true;
        }
        return false;
    }

}
