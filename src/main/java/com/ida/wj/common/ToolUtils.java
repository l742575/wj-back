package com.ida.wj.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lh
 * @date 2020/5/19
 * @description
 */
public class  ToolUtils {

    public static String dateString(String date) {
        String d2=null;
        try{
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date d = simpleDateFormat1.parse(date);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            d2 = simpleDateFormat2.format(d);

        }catch (Exception e){
            e.printStackTrace();
        }
        return d2;

    }


}
