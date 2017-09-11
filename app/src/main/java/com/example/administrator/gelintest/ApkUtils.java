package com.example.administrator.gelintest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * Created by Administrator on 2017/9/11.
 */

public class ApkUtils {
    /**
     * 打开格林的分类
     * @param mContext 上下文
     * @param categoryId 分类id
     */
    public static void openGreenCategory(Context mContext, String categoryId){
        String mac=getMac();
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        String packageName = "com.geling.view.tp.gelingtv_yueman";
        String className = "com.geling.view.gelingtv.PrimarySchoolActivity";
        intent.setComponent(new ComponentName(packageName,className));
        intent.putExtra("mac",mac);
        intent.putExtra("categoryId",categoryId);
        mContext.startActivity(intent);
    }
    public static String getMac() {
        String macSerial = null;
        String str = "";
        try {
            Process pp = Runtime.getRuntime().exec(
                    "cat /sys/class/net/wlan0/address ");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);


            for (; null != str;) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();// 去空格
                    break;
                }
            }
        } catch (IOException ex) {
            // 赋予默认值
            macSerial="123456";
            ex.printStackTrace();
        }
        return macSerial;
    }
}
