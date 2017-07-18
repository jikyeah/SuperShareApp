package com.imlz.supershare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.imlz.sharecore.Constant;
import com.imlz.sharecore.ShareManager;

public class MainActivity extends AppCompatActivity {


    private String shareData = "";
    private String shareDataLocal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        shareDataLocal = "{\"url\":\"http://www.baidu.com\",\"title\":\"this is title\",\"content\":\"test content\",\"imgurl\":\"/storage/emulated/0/test.jpg\",\"imgPaths\":[\"/storage/emulated/0/test.jpg\",\"/storage/emulated/0/test.jpg\"]}";

        shareData = "{\"url\":\"http://www.baidu.com\",\"title\":\"this is title\",\"content\":\"test content\",\"imgurl\":\"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png\",\"imgPaths\":[\"/storage/emulated/0/test.jpg\",\"/storage/emulated/0/test.jpg\"]}";

    }


    /**
     * 系统分享--------
     */

    public void shareToQQBySys(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_SYSTEM, Constant.PLATFORM_QQ, shareDataLocal);
    }

    public void shareToQZoneBySys(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_SYSTEM, Constant.PLATFORM_QZONE, shareData);
    }

    public void shareToWechatBySys(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_SYSTEM, Constant.PLATFORM_WECHAT, shareDataLocal);
    }

    public void shareToWechatMonmentBySys(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_SYSTEM, Constant.PLATFORM_WECHAT_MONMENT, shareData);
    }

    /**
     * 指定APP分享--------
     */

    public void shareToQQByAPP(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_APP, Constant.PLATFORM_QQ, shareDataLocal);
    }

    public void shareToQZoneByAPP(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_APP, Constant.PLATFORM_QZONE, shareDataLocal);
    }

    public void shareToWechatByAPP(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_APP, Constant.PLATFORM_WECHAT, shareDataLocal);
    }

    public void shareToWechatMonmentByAPP(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_APP, Constant.PLATFORM_WECHAT_MONMENT, shareDataLocal);
    }

    /**
     * 通过浏览器分享--------
     */

    public void shareToQQByBroswer(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_BROSWER, Constant.PLATFORM_QQ, shareData);
    }

    public void shareToQQZoneByBroswer(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_BROSWER, Constant.PLATFORM_QZONE, shareData);
    }

    public void shareToWechatByBroswer(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_BROSWER, Constant.PLATFORM_WECHAT, shareData);
    }

    public void shareToWechatMonmentByBroswer(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_BROSWER, Constant.PLATFORM_WECHAT_MONMENT, shareData);
    }

    /**
     * 通过Schema、插件分享--------
     */

    public void shareToQQByAssistant(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_ASSISTANT, Constant.PLATFORM_QQ, shareData);
    }

    public void shareToQQZoneByAssistant(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_ASSISTANT, Constant.PLATFORM_QZONE, shareData);
    }

    public void shareToWechatByAssistant(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_ASSISTANT, Constant.PLATFORM_WECHAT, shareData);
    }

    public void shareToWechatMonmentByAssistant(View view) {
        ShareManager.startShare(MainActivity.this, Constant.SHARE_WAY_FROM_ASSISTANT, Constant.PLATFORM_WECHAT_MONMENT, shareData);
    }

    /**
     * 终极分享--------
     *
     */

    /**
     * 由于涉及到某些人的利益，无法直接提供，若有需要请联系作者，效果看截屏
     */

}
