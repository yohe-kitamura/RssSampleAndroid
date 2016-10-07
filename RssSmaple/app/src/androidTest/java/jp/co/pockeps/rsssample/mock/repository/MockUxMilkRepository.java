package jp.co.pockeps.rsssample.mock.repository;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import jp.co.pockeps.rsssample.entity.Article;
import jp.co.pockeps.rsssample.entity.Articles;
import jp.co.pockeps.rsssample.entity.uxmilk.Item;
import jp.co.pockeps.rsssample.repository.NetworkListener;
import jp.co.pockeps.rsssample.repository.UxMilkRepository;

public abstract class MockUxMilkRepository extends UxMilkRepository {

    private Articles articles;

    public MockUxMilkRepository() {
    }

    protected MockUxMilkRepository(Articles articles) {
        this.articles = articles;
    }

    protected MockUxMilkRepository(List<Item> articles) {
        List<Article> list = new ArrayList<>();
        for (Item item : articles) {
            list.add(item.createArticle());
        }
        this.articles = new Articles(list);
    }

    /**
     * UxMilkRssを取得
     * @param listener コールバック用リスナー
     */
    public abstract void getUxMilkRss(@NonNull final NetworkListener<Articles> listener);

    protected void SuccessCase(NetworkListener<Articles> listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener should not null ");
        }

        listener.onSuccess(articles);
    }

    protected void failureCase(NetworkListener<Articles> listener){
        listener.onFailure();
    }
}
