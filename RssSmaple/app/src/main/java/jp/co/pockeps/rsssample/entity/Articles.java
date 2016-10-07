package jp.co.pockeps.rsssample.entity;

import java.util.ArrayList;
import java.util.List;

public class Articles {
    private List<Article> articles;

    /**
     * 外部からは変更できないようにコピーを渡す
     * @return
     */
    public List<Article> getArticles() {
        return new ArrayList<>(articles);
    }

    public Articles(List<Article> articles) {
        this.articles = articles;
    }
}
