package com.imlz.sharecore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * 通过浏览器的分享功能实现分享
 * Created by linzenos on 2017/7/14.
 */

public class ShareByBroswer {


    private static ShareByBroswer shareByBroswer = null;

    public static ShareByBroswer getInstance() {
        if (shareByBroswer == null) {
            shareByBroswer = new ShareByBroswer();
        }
        return shareByBroswer;
    }


    /**
     * 分享到微信
     *
     * @param context
     * @param bean
     */
    public void ShareToWechat(Context context, ShareBean bean) {
        share(context, bean);
    }

    /**
     * 分享到朋友圈
     * @param context
     * @param bean
     */
    public void ShareToWechatMonment(Context context, ShareBean bean) {
        share(context, bean);
    }

    /**
     * 分享到QQ
     * @param context
     * @param bean
     */
    public void ShareToQQ(Context context, ShareBean bean) {
        share(context, bean);
    }

    /**
     * 分享到QQ空间
     * @param context
     * @param bean
     */
    public void ShareToQZone(Context context, ShareBean bean) {
        share(context, bean);
    }

    private void share(Context context, ShareBean bean) {
        Intent intent = new Intent();
        intent.setClassName(Constant.QQBROSER_PACKAGE_NAME, Constant.QQBROSER_ACTIVITY_NAME);
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("https://fa-ge.github.io/NativeShare/demo/index.html"));
        context.startActivity(intent);
    }

}
