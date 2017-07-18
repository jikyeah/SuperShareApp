package com.imlz.sharecore;

import android.content.Context;

import com.google.gson.Gson;

/**
 * Created by linzenos on 2017/7/14.
 */

public class ShareManager {


    public static void startShare(Context context, String share_way, String share_to_platform, String share_data) {

        ShareBean bean = new Gson().fromJson(share_data, ShareBean.class);


        if (share_way.equals(Constant.SHARE_WAY_FROM_SYSTEM)) {
            if (share_to_platform.equals(Constant.PLATFORM_QQ)) {
                ShareBySys.getInstance(Constant.PLATFORM_QQ).ShareText(context, bean);
            } else if (share_to_platform.equals(Constant.PLATFORM_QZONE)) {
                ShareBySys.getInstance(Constant.PLATFORM_QZONE).ShareText(context, bean);
            } else if (share_to_platform.equals(Constant.PLATFORM_WECHAT)) {
                ShareBySys.getInstance(Constant.PLATFORM_WECHAT).ShareText(context, bean);
            } else if (share_to_platform.equals(Constant.PLATFORM_WECHAT_MONMENT)) {
                ShareBySys.getInstance(Constant.PLATFORM_WECHAT_MONMENT).ShareText(context, bean);
            }
        } else if (share_way.equals(Constant.SHARE_WAY_FROM_APP)) {
            if (share_to_platform.equals(Constant.PLATFORM_QQ)) {
                ShareByApp.getInstance().ShareToQQ(context, bean);
            } else if (share_to_platform.equals(Constant.PLATFORM_QZONE)) {
                ShareByApp.getInstance().ShareToQZone(context, bean);
            } else if (share_to_platform.equals(Constant.PLATFORM_WECHAT)) {
                ShareByApp.getInstance().ShareToWechat(context, bean);
            } else if (share_to_platform.equals(Constant.PLATFORM_WECHAT_MONMENT)) {
                ShareByApp.getInstance().ShareToWechatMonment(context, bean);
            }
        } else if (share_way.equals(Constant.SHARE_WAY_FROM_BROSWER)) {
            if (share_to_platform.equals(Constant.PLATFORM_QQ)) {
                ShareByBroswer.getInstance().ShareToQQ(context, bean);
            } else if (share_to_platform.equals(Constant.PLATFORM_QZONE)) {
                ShareByBroswer.getInstance().ShareToQZone(context, bean);
            } else if (share_to_platform.equals(Constant.PLATFORM_WECHAT)) {
                ShareByBroswer.getInstance().ShareToWechat(context, bean);
            } else if (share_to_platform.equals(Constant.PLATFORM_WECHAT_MONMENT)) {
                ShareByBroswer.getInstance().ShareToWechatMonment(context, bean);
            }
        } else if (share_way.equals(Constant.SHARE_WAY_FROM_ASSISTANT)) {
            if (share_to_platform.equals(Constant.PLATFORM_QQ)) {

            } else if (share_to_platform.equals(Constant.PLATFORM_QZONE)) {

            } else if (share_to_platform.equals(Constant.PLATFORM_WECHAT)) {
                ShareByAssistant.getInstance().ShareToWechat(context, bean);
            } else if (share_to_platform.equals(Constant.PLATFORM_WECHAT_MONMENT)) {
                ShareByAssistant.getInstance().ShareToWechatMonment(context, bean);
            }
        } else if (share_way.equals(Constant.SHARE_WAY_FROM_SUPPER)) {
            if (share_to_platform.equals(Constant.PLATFORM_QQ)) {
                ShareBySupper.getInstance().ShareToQQ(context, bean);
            } else if (share_to_platform.equals(Constant.PLATFORM_QZONE)) {
                ShareBySupper.getInstance().ShareToQZone(context, bean);
            } else if (share_to_platform.equals(Constant.PLATFORM_WECHAT)) {
                ShareBySupper.getInstance().ShareToWechat(context, bean);
            } else if (share_to_platform.equals(Constant.PLATFORM_WECHAT_MONMENT)) {
                ShareBySupper.getInstance().ShareToWechatMonment(context, bean);
            }
        }

    }


}
