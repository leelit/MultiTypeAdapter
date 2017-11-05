package com.kenjxli.mylibrary;

/**
 * Created by kenjxli on 2017/11/4.
 */

public interface Item {
    Class<? extends ItemDelegate> mapDelegate();
}
