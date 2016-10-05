package jp.co.pockeps.rsssmaple.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import jp.co.pockeps.rsssmaple.R;
import jp.co.pockeps.rsssmaple.entity.uxmilk.Item;

public class UxMilkAdapter extends ArrayAdapter<Item> {

    public UxMilkAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
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

        Item item = getItem(position);
        if (item != null) {
            viewHolder.title.setText(item.title);
            viewHolder.pubDate.setText(item.formatPubDate());
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
