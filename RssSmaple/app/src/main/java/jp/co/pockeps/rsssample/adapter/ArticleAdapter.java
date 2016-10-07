package jp.co.pockeps.rsssample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import butterknife.BindView;
import jp.co.pockeps.rsssample.R;
import jp.co.pockeps.rsssample.entity.Article;
import jp.co.pockeps.rsssample.entity.Articles;

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(Context context, Articles articles) {
        super(context, 0, articles.getArticles());
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.adater_item, null);

            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Article item = getItem(position);
        if (item != null) {
            viewHolder.title.setText(item.title);
            viewHolder.pubDate.setText(item.getPubDateFormatString());
            viewHolder.description.setText(item.description);
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.pub_date) TextView pubDate;
        @BindView(R.id.title) TextView title;
        @BindView(R.id.description) TextView description;

        ViewHolder(View view) {
            butterknife.ButterKnife.bind(this, view);
        }
    }
}
