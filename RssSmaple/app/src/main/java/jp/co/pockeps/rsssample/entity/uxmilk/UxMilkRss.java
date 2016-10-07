package jp.co.pockeps.rsssample.entity.uxmilk;

import android.support.annotation.NonNull;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

import jp.co.pockeps.rsssample.entity.Article;

@Root(name = "rss", strict = false)
public class UxMilkRss {
    @Element
    public Channel channel;

    public List<Item> getItems() {
        if (channel == null) {
            return new ArrayList<>();
        }

        return channel.items;
    }

    @NonNull
    public List<Article> getArticles() {
        List<Article> list = new ArrayList<>();

        for (Item item : getItems()) {
            list.add(item.createArticle());
        }
        return list;
    }
}
