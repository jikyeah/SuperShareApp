package com.imlz.sharecore;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.List;

/**
 * 通过应用内直接进行分享
 * Created by linzenos on 2017/7/14.
 */

public class ShareBySupper {


    private static ShareBySupper shareByAssistant = null;

    public static ShareBySupper getInstance() {
        if (shareByAssistant == null) {
            shareByAssistant = new ShareBySupper();
        }
        return shareByAssistant;
    }


    /**
     * 分享到微信
     *
     * @param context
     * @param bean
     */
    public void ShareToWechat(Context context, ShareBean bean) {
        supperShareToWechat(1, context, bean);
    }

    /**
     * 分享到朋友圈
     *
     * @param context
     * @param bean
     */
    public void ShareToWechatMonment(Context context, ShareBean bean) {

        supperShareToWechat(2, context, bean);
    }


    private void supperShareToWechat(int type, Context context, ShareBean bean) {
        /**
         * 由于涉及到"别人的利益"，无法直接提供，若有需要请联系作者
         */

    }


    /**
     * 分享到QQ
     * 内容为base64加密
     *
     * @param context
     * @param bean
     */
    public void ShareToQQ(Context context, ShareBean bean) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqapi://share/to_fri?src_type=web&version=1&file_type=news&share_id=1101685683&title=5Lmg6L+R5bmz5a+55Lit5aSu5pS/5rK75bGA5oiQ5ZGY55qE5Y2B5pa56Z2i6KaB5rGCLeaWsOmXu+mikemBky3miYvmnLrmkJzni5A=&thirdAppDisplayName=5omL5py65pCc54uQ&url=aHR0cHM6Ly9tLnNvaHUuY29tL24vNDc3NzA2NzAwLz9fdHJhbnNfPTAwMDExNV8zdyYmJiYmX29uY2VfPTAwMDAyMl9zaGFyZWJhY2tfcXE="));
        List<ResolveInfo> activities = context.getPackageManager().queryIntentActivities(intent, 0);
        boolean isValid = !activities.isEmpty();
        if (isValid) {
            context.startActivity(intent);
        }
    }

    /**
     * 分享到QQ空间
     * 内容为base64加密
     *
     * @param context
     * @param bean
     */
    public void ShareToQZone(Context context, ShareBean bean) {
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity");
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("mqqapi://share/to_qzone?src_type=web&version=1&file_type=news&share_id=1101685683&req_type=1&image_url=aHR0cHM6Ly9zczAuYmRzdGF0aWMuY29tLzVhVjFianFoX1EyM29kQ2Yvc3RhdGljL3N1cGVybWFuL2ltZy9sb2dvL2JkX2xvZ28xXzMxYmRjNzY1LnBuZw==&title=5Lmg6L+R5bmz5a+55Lit5aSu5pS/5rK75bGA5oiQ5ZGY55qE5Y2B5pa56Z2i6KaB5rGCLeaWsOmXu+mikemBky3miYvmnLrmkJzni5A=&description=57ud5a+555yf5a6e6YWS5bqX5aWz5pyN5Yqh5ZGY6YaJ6YWS5ZCO6KKr5by66KGM5bim5b6A5oi/6Ze0&url=aHR0cDovL25ld3MueGluaHVhbmV0LmNvbS9wb2xpdGljcy8yMDE3LTA2LzI5L2NfMTEyMTIzNjQ5Ny5odG0="));
        List<ResolveInfo> activities = context.getPackageManager().queryIntentActivities(intent, 0);
        boolean isValid = !activities.isEmpty();
        if (isValid) {
            context.startActivity(intent);
        }
    }

}
