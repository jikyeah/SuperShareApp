package com.imlz.sharecore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.util.ArrayList;

/**
 * 通过指定APP的包名实现分享
 * Created by linzenos on 2017/7/14.
 */

public class ShareByApp {

    private static ShareByApp shareByApp = null;

    public static ShareByApp getInstance() {
        if (shareByApp == null) {
            shareByApp = new ShareByApp();
        }
        return shareByApp;
    }


    /**
     * 分享到微信
     *
     * @param context
     * @param bean
     */
    public void ShareToWechat(Context context, ShareBean bean) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, bean.content);
        intent.setType("text/*");
        intent.setClassName(Constant.WECHAT_PACKAGE_NAME, Constant.WECHAT_ACTIVITY_NAME);
        context.startActivity(intent);
    }

    /**
     * 分享到微信朋友圈
     *
     * @param context
     * @param bean
     */
    public void ShareToWechatMonment(Context context, ShareBean bean) {
        ArrayList<Uri> images = new ArrayList<>();
        File file = new File(bean.imgurl);
        Uri uri = FileProvider.getUriForFile(context, "com.imlz.sharecore.fileprovider", file);
        images.add(uri);

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent.putExtra("Kdescription", bean.content);
        intent.setType("image/*");
        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, images);
        intent.setClassName(Constant.WECHAT_MONMENT_PACKAGE_NAME, Constant.WECHAT_MONMENT_ACTIVITY_NAME);
        context.startActivity(intent);
    }


    /**
     * 分享到QQ
     *
     * @param context
     * @param bean
     */
    public void ShareToQQ(Context context, ShareBean bean) {
        ArrayList<Uri> images = new ArrayList<>();
        File file = new File(bean.imgurl);
        Uri uri = FileProvider.getUriForFile(context, "com.imlz.sharecore.fileprovider", file);
        images.add(uri);

        ShareUtil shareUtil = new ShareUtil(context, images);
        Intent baseIntent = shareUtil.getBaseIntent(Constant.QQ_ACTIVITY_NAME);
        baseIntent.putExtra("summary", bean.content);
        context.startActivity(baseIntent);
    }

    /**
     * 分享到QZonen
     *
     * @param context
     * @param bean
     */
    public void ShareToQZone(Context context, ShareBean bean) {
        ArrayList<Uri> images = new ArrayList<>();
        File file = new File(bean.imgurl);
        Uri uri = FileProvider.getUriForFile(context, "com.imlz.sharecore.fileprovider", file);
        images.add(uri);

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent.putExtra(Intent.EXTRA_TEXT, bean.content);
        intent.setType("image/jpeg");
        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, images);
        intent.setClassName(Constant.QZONE_PACKAGE_NAME, Constant.QZONE_ACTIVITY_NAME);
        context.startActivity(intent);
    }


}
