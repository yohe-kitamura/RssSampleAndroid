package jp.co.pockeps.rsssample.entity;

import android.support.annotation.Nullable;
import android.text.format.DateFormat;

import java.util.Date;

public class Article {
    public String title;

    public String link;

    public String description;

    @Nullable
    public Date pubDate;

    public String imageUrl;

    public boolean isBookmark;

    public Article(String title, String link, String description, @Nullable Date pubDate, String imageUrl) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
        this.imageUrl = imageUrl;
    }

    public String getPubDateFormatString(){
        return pubDate != null ? (String) DateFormat.format("yyyy/MM/dd", pubDate) : "";
    }

}
