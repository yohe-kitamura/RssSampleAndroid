package jp.co.pockeps.rsssmaple.entity.uxmilk;

import android.text.format.DateFormat;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Root(strict = false)
public class Item {

    @Element(required=false)
    public String title;

    @Element(required=false)
    public String link;

    @Element(required=false)
    public String pubDate;

    @Element(required=false)
    public String description;

    public boolean isFavorite;

    public String formatPubDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
        try {
            Date date = simpleDateFormat.parse(pubDate);
            return String.valueOf(DateFormat.format("yyyy/MM/dd", date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
