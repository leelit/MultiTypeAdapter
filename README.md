# MultiTypeAdapter

multi type adapter for RecyclerView

## Usage

Three steps to make your RecyclerView support multi types easily

0. prepare

  - copy the library src to your module

  - add dependcy to your module, like `compile 'com.android.support:recyclerview-v7:24.0.0-alpha2'`

1. define your data model like MyItem which implements `Item`
```
public class MyItem implements Item {
  
  // define your fields
  public String value;
  // ...
  
  @Override
    public Class<? extends ItemDelegate> mapDelegate() {
        return MyItemDelegate.class; // step2
    }
}
```

2. define the delegate which implements `ItemDelegate` for MyItem
```
public class MyDelegate implements ItemDelegate<MyItem, MyDelegate.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        // create view holder for MyItem model
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_my_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, MyItem item) {
        // bind view holder for MyItem model
        holder.tv.setImageResource(item.value);
    }
    
    // define real view holder for MyItem
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }

}
```

3. put data to MultiTypeAdapter
```
List<Item> adapterItems = new ArrayList<>();
// add any counts of MyItem
adapterItems.add(new MyItem(value));
adapterItems.add(new MyItem(value));
adapterItems.add(new MyItem(value));
// add other different types of Item...

// set MultiTypeAdapter with different Items for RecyclerView
recyclerView.setAdapter(new MultiTypeAdapter(adapterItems));
```


## ScreenShot
![screenshot](https://github.com/leelit/MultiTypeAdapter/blob/master/art.png?raw=true)

## License
MIT
