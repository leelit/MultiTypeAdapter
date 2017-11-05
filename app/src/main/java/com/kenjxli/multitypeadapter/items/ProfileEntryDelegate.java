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

public class ProfileEntryDelegate implements ItemDelegate<ProfileEntryItem, ProfileEntryDelegate.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_profile_entry, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, ProfileEntryItem item) {
        holder.avatar.setImageResource(item.avatarId);
        holder.nickName.setText(item.nickName);
        holder.line.setVisibility(item.isShowLine ? View.VISIBLE : View.GONE);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView avatar;
        TextView nickName;
        View line;

        public ViewHolder(View itemView) {
            super(itemView);
            avatar = (ImageView) itemView.findViewById(R.id.avatar);
            nickName = (TextView) itemView.findViewById(R.id.nickName);
            line = itemView.findViewById(R.id.line);
        }
    }
}

