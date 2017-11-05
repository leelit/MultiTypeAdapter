package com.kenjxli.multitypeadapter.items;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kenjxli.multitypeadapter.R;
import com.kenjxli.mylibrary.ItemDelegate;

/**
 * Created by kenjxli on 2017/11/5.
 */

public class HeaderDelegate implements ItemDelegate<HeaderItem, HeaderDelegate.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_header, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, HeaderItem item) {
        holder.headerIv.setImageResource(item.imageId);
        holder.headerTv.setText(item.description);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView headerIv;
        TextView headerTv;

        public ViewHolder(View itemView) {
            super(itemView);
            headerIv = (ImageView) itemView.findViewById(R.id.headerIv);
            headerTv = (TextView) itemView.findViewById(R.id.headerTv);
        }
    }

}
