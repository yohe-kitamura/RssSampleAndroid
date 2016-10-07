package jp.co.pockeps.rsssample;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    /**
     * 日付文字列を指定されたformat形式でフォーマットする
     * @param format　format形式
     * @param target　日付文字列
     * @return 日付
     */
    @Nullable
    public static Date convertDateFromStr(String format, String target) {
        if(TextUtils.isEmpty(format)|| TextUtils.isEmpty(target)){
            return null;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);
        try {
            return simpleDateFormat.parse(target);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

}
