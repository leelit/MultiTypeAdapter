package com.kenjxli.multitypeadapter.items;

import com.kenjxli.mylibrary.Item;
import com.kenjxli.mylibrary.ItemDelegate;

/**
 * Created by kenjxli on 2017/11/5.
 */

public class SimpleTextItem implements Item {

    public String text = "";

    public SimpleTextItem(String text) {
        this.text = text;
    }

    @Override
    public Class<? extends ItemDelegate> mapDelegate() {
        return SimpleTextDelegate.class;
    }
}
