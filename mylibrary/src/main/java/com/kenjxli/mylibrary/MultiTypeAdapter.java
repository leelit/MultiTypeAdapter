package com.kenjxli.mylibrary;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenjxli on 2017/11/4.
 */

public class MultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> items;
    private List<Class<? extends ItemDelegate>> delegateTypes;
    private List<ItemDelegate> delegateInstances;

    public MultiTypeAdapter(List<Item> items) {
        if (items != null && items.size() > 0) {
            this.items = items;
            delegateTypes = new ArrayList<>();
            delegateInstances = new ArrayList<>();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemDelegate delegate = delegateInstances.get(viewType);
        return delegate.onCreateViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Class<? extends ItemDelegate> type = items.get(position).mapDelegate();
        ItemDelegate instance = delegateInstances.get(delegateTypes.indexOf(type));
        instance.onBindViewHolder(holder, items.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        Class<? extends ItemDelegate> delegateType = items.get(position).mapDelegate();
        if (!delegateTypes.contains(delegateType)) {
            try {
                delegateTypes.add(delegateType);
                ItemDelegate instance = delegateType.newInstance();
                delegateInstances.add(instance);
            } catch (Exception e) {
                throw new RuntimeException("please check if " + delegateType.getSimpleName() + " is public class\n" + e);
            }
            return delegateTypes.size() - 1;
        } else {
            return delegateTypes.indexOf(delegateType);
        }
    }

    @Override
    public int getItemCount() {
        if (items != null) {
            return items.size();
        } else {
            return 0;
        }
    }
}
