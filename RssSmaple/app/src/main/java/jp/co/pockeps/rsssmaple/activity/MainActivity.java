package jp.co.pockeps.rsssmaple.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.Unbinder;
import jp.co.pockeps.rsssmaple.R;
import jp.co.pockeps.rsssmaple.adapter.UxMilkAdapter;
import jp.co.pockeps.rsssmaple.entity.uxmilk.Item;
import jp.co.pockeps.rsssmaple.presenter.UxMilkListPresenter;
import jp.co.pockeps.rsssmaple.view.UxMilkListView;

public class MainActivity extends AppCompatActivity implements UxMilkListView {

    @BindView(android.R.id.list) ListView list;
    private UxMilkListPresenter presenter;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);

        presenter = createPresenter();
        presenter.loadDate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void fetchData(List<Item> items) {
        //ListViewにデータセット
        list.setAdapter(new UxMilkAdapter(getApplicationContext(), items));
    }

    @Override
    public void loadError() {
        Toast.makeText(this, "読み込みに失敗しました。", Toast.LENGTH_SHORT).show();
    }

    protected UxMilkListPresenter createPresenter() {
        return new UxMilkListPresenter(this);
    }

    @OnItemClick(android.R.id.list)
    public void onListItemClick(int position) {
        Item item = (Item) list.getItemAtPosition(position);
        // Chromeの起動
        final CustomTabsIntent tabsIntent = getCustomTabsIntent(getApplicationContext());
        tabsIntent.launchUrl(this, Uri.parse(item.link));
    }

    /**
     * ChromeCustomTab起動用Intent取得
     * @param context 色取得用
     * @return 起動Intent
     */
    @NonNull
    protected CustomTabsIntent getCustomTabsIntent(Context context) {
        return new CustomTabsIntent.Builder()
                .setShowTitle(true)
                .setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .build();
    }
}
