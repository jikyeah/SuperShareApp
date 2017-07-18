package com.imlz.sharecore;

import android.content.Context;

/**
 * 通过安装分享助手的方式进行分享
 * Created by linzenos on 2017/7/14.
 */

public class ShareByAssistant {


    private static ShareByAssistant shareByAssistant = null;

    public static ShareByAssistant getInstance() {
        if (shareByAssistant == null) {
            shareByAssistant = new ShareByAssistant();
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
        pluginShareToWechat(0, context, bean);
    }

    /**
     * 分享到朋友圈
     *
     * @param context
     * @param bean
     */
    public void ShareToWechatMonment(Context context, ShareBean bean) {

        pluginShareToWechat(1, context, bean);
    }


    private void pluginShareToWechat(int type, Context context, ShareBean bean) {
        /**
         * 由于涉及到"别人的利益"，无法直接提供，若有需要请联系作者
         */

    }

}
