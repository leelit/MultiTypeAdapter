package com.kenjxli.multitypeadapter.items;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kenjxli.multitypeadapter.R;
import com.kenjxli.mylibrary.ItemDelegate;

/**
 * Created by kenjxli on 2017/11/5.
 */

public class SimpleTextDelegate implements ItemDelegate<SimpleTextItem, SimpleTextDelegate.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_simple_text, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, SimpleTextItem item) {
        holder.tv.setText(item.text);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.headerTv);
        }
    }

}
