package com.kenjxli.multitypeadapter.items;

import com.kenjxli.mylibrary.Item;
import com.kenjxli.mylibrary.ItemDelegate;

/**
 * Created by kenjxli on 2017/11/5.
 */

public class HeaderItem implements Item {
    public int imageId;
    public String description;

    public HeaderItem(int imageId, String description) {
        this.imageId = imageId;
        this.description = description;
    }

    @Override
    public Class<? extends ItemDelegate> mapDelegate() {
        return HeaderDelegate.class;
    }
}
