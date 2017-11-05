package com.kenjxli.multitypeadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kenjxli.multitypeadapter.items.HeaderItem;
import com.kenjxli.multitypeadapter.items.ProfileEntryItem;
import com.kenjxli.multitypeadapter.items.SimpleTextItem;
import com.kenjxli.mylibrary.Item;
import com.kenjxli.mylibrary.MultiTypeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(getMultiTypeAdapter());
    }

    private RecyclerView.Adapter getMultiTypeAdapter() {
        List<Item> adapterItems = new ArrayList<>();
        HeaderItem headerItem = new HeaderItem(R.mipmap.jumpman_logo, "This is Header Title");
        adapterItems.add(headerItem);

        String headValue = "A";
        adapterItems.add(new SimpleTextItem(headValue));
        for (int i = 1; i <= 5; i++) {
            if (i == 5) {
                adapterItems.add(new ProfileEntryItem(R.mipmap.ic_launcher, headValue + i, false));
            } else {
                adapterItems.add(new ProfileEntryItem(R.mipmap.ic_launcher, headValue + i));
            }
        }

        headValue = "B";
        adapterItems.add(new SimpleTextItem(headValue));
        for (int i = 1; i <= 8; i++) {
            if (i == 8) {
                adapterItems.add(new ProfileEntryItem(R.mipmap.ic_launcher, headValue + i, false));
            } else {
                adapterItems.add(new ProfileEntryItem(R.mipmap.ic_launcher, headValue + i));
            }
        }
        return new MultiTypeAdapter(adapterItems);
    }


}
