package jp.co.pockeps.rsssample.entity.uxmilk;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import jp.co.pockeps.rsssample.util.DateUtil;
import jp.co.pockeps.rsssample.entity.Article;

@Root(strict = false)
public class Item {

    private static final String DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss Z";

    @Element(required = false)
    private String title;

    @Element(required = false)
    private String link;

    @Element(required = false)
    private String description;

    @Element(required = false)
    private String pubDate;

    @SuppressWarnings("unused")
    public Item() {
    }

    public Item(String title, String link, String pubDate, String description) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.description = description;
    }

    public Article createArticle() {
        return new Article(title, link, description, DateUtil.convertDateFromStr(DATE_FORMAT, pubDate), null);
    }
}
