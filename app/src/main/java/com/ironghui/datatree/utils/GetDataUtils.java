package com.ironghui.datatree.utils;

import com.ironghui.datatree.interfacen.GetData;
import com.ironghui.datatree.interfacen.GetSecondData;
import com.ironghui.datatree.interfacen.GetThirdData;

/**
 * Created by ZhangFangHan on 2018/3/5.
 */

public class GetDataUtils {
    private static GetData data;
    public static void setGetDate(GetData getDate) {
        data = getDate;
    }
    public static void returnData() {
        data.onEnd("回调内容传入onEnd");
        data.onStartde("回调内容传入onStartde");
    }


    private static GetSecondData getSecondData;
    public static void setGetSecondData(GetSecondData getSecondData1) {
        getSecondData = getSecondData1;
    }
    public static void returnSecondData() {
        getSecondData.secondMethord();
        getSecondData.thirdMethord();
    }

    private static GetThirdData getThirdData;
    public static void setGetThirdData(GetThirdData getThirdData1) {
        getThirdData = getThirdData1;
    }
    public static void returnThirdData(){
        getThirdData.getThirdData();
        getThirdData.setThirdData();
    }
}
