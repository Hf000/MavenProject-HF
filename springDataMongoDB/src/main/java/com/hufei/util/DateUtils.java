package com.hufei.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:hufei
 * @CreateTime:2020-09-29
 * @Description:日期工具类
 */
@Slf4j
public class DateUtils {

    public static String getCurrentTime() {
        String time = "";
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            time = sdf.format(date);
        } catch (Exception e) {
            log.error("生成当前日期出错，格式yyyy-MM-dd hh:mm:ss");
        }
        return time;
    }

}
