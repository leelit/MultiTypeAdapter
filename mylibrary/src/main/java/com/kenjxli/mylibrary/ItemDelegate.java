package com.kenjxli.mylibrary;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by kenjxli on 2017/11/4.
 */

public interface ItemDelegate<ITEM extends Item, VH extends RecyclerView.ViewHolder>{

    VH onCreateViewHolder(ViewGroup parent);

    void onBindViewHolder(VH holder, ITEM item);

}
