package com.kenjxli.multitypeadapter.items;

import com.kenjxli.mylibrary.Item;
import com.kenjxli.mylibrary.ItemDelegate;

/**
 * Created by kenjxli on 2017/11/5.
 */

public class ProfileEntryItem implements Item {

    public int avatarId;
    public String nickName;
    public boolean isShowLine;

    public ProfileEntryItem(int avatarId, String nickName) {
        this(avatarId, nickName, true);
    }

    public ProfileEntryItem(int avatarId, String nickName, boolean isShowLine) {
        this.avatarId = avatarId;
        this.nickName = nickName;
        this.isShowLine = isShowLine;
    }

    @Override
    public Class<? extends ItemDelegate> mapDelegate() {
        return ProfileEntryDelegate.class;
    }
}
