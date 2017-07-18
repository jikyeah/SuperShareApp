package com.imlz.sharecore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;
import java.util.ArrayList;

/**
 * 调用系统自带分享功能
 * Created by linzenos on 2017/7/14.
 */

public class ShareBySys {


    private static String mPlatform = Constant.PLATFORM_WECHAT;
    private static ShareBySys shareBySys = null;

    public static ShareBySys getInstance(String platform) {
        if (shareBySys == null) {
            shareBySys = new ShareBySys();
        }
        mPlatform = platform;

        return shareBySys;
    }


    /**
     * 分享文字
     *
     * @param context
     */
    public void ShareText(Context context, ShareBean bean) {
        Intent textIntent = new Intent(Intent.ACTION_SEND);
        textIntent.setType("text/plain");
        textIntent.setPackage(ShareHelper.getPacketNameByPlat(mPlatform));
        textIntent.putExtra(Intent.EXTRA_TEXT, bean.content);
        context.startActivity(Intent.createChooser(textIntent, "分享"));
    }

    /**
     * 单图片分享
     *
     * @param context
     */
    public void ShareImage(Context context, ShareBean bean) {
        //String path = ShareHelper.getResourcesUri(context, R.drawable.share);
        Intent imageIntent = new Intent(Intent.ACTION_SEND);
        imageIntent.setType("image/jpeg");
        imageIntent.setPackage(ShareHelper.getPacketNameByPlat(mPlatform));
        imageIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(bean.imgurl)));
        context.startActivity(Intent.createChooser(imageIntent, "分享"));

    }

    /**
     * 多图片分享
     *
     * @param context
     */
    public void ShareMultiImage(Context context, ShareBean bean) {
        ArrayList<Uri> imageUris = new ArrayList<>();
        Uri uri = null;
        for (int i = 0; i < bean.imgPaths.size(); i++) {
            uri = Uri.fromFile(new File(bean.imgPaths.get(i)));
            imageUris.add(uri);
        }
        Intent mulIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
        mulIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
        mulIntent.setType("image/jpeg");
        mulIntent.setPackage(ShareHelper.getPacketNameByPlat(mPlatform));
        context.startActivity(Intent.createChooser(mulIntent, "多文件分享"));

    }


}
