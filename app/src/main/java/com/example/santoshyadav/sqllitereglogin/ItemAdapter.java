package com.example.santoshyadav.sqllitereglogin;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.santoshyadav.sqllitereglogin.data.Item;
import com.example.santoshyadav.sqllitereglogin.data.ItemContract;

import static com.example.santoshyadav.sqllitereglogin.DetailActivity.Item_DESCRIPTION;
import static com.example.santoshyadav.sqllitereglogin.DetailActivity.Item_IMAGE;
import static com.example.santoshyadav.sqllitereglogin.DetailActivity.Item_NAME;
import static com.example.santoshyadav.sqllitereglogin.DetailActivity.Item_PRICE;
import static com.example.santoshyadav.sqllitereglogin.DetailActivity.Item_RATING;


@SuppressWarnings("deprecation")
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    Cursor dataCursor;
    Context context;
    int id;

    @SuppressWarnings("deprecation")
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, userrating, description, price;
        public ImageView thumbnail;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.title);
            //  userrating = (TextView) itemView.findViewById(R.id.userrating);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra(Item_NAME, getItem(pos).name);
                        intent.putExtra(Item_DESCRIPTION, getItem(pos).description);
                        intent.putExtra(Item_PRICE, getItem(pos).price);
                        intent.putExtra(Item_IMAGE, getItem(pos).imageUrl);
                        intent.putExtra(Item_RATING, getItem(pos).userRating);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }

    public ItemAdapter(Shopping mContext, Cursor cursor) {
        dataCursor = cursor;
        context = mContext;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cardview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new ViewHolder(cardview);
    }


    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {


        dataCursor.moveToPosition(position);

        id = dataCursor.getInt(dataCursor.getColumnIndex(ItemContract.ItemEntry._ID));
        String mName = dataCursor.getString(dataCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_NAME));
        String mDescription = dataCursor.getString(dataCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_DESCRIPTION));
        String mImageUrl = dataCursor.getString(dataCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_IMAGE));
        int mPrice = dataCursor.getInt(dataCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_PRICE));
        int mUserrating = dataCursor.getInt(dataCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_USERRATING));


        holder.name.setText(mName);

        String poster = "https://photos.google.com/u/1/album/AF1QipPhKQ9Ro2LLoxYfprBMRP56Xi081qAynaEO9s6T" + mImageUrl;

        Glide.with(context)
                .load(poster)
                .placeholder(R.drawable.load)
                .into(holder.thumbnail);



    }

    public Cursor swapCursor(Cursor cursor) {
        if (dataCursor == cursor) {
            return null;
        }
        Cursor oldCursor = dataCursor;
        this.dataCursor = cursor;
        if (cursor != null) {
            this.notifyDataSetChanged();
        }
        return oldCursor;
    }

    @Override
    public int getItemCount() {
        return (dataCursor == null) ? 0 : dataCursor.getCount();
    }

    public Item getItem(int position) {
        if (position < 0 || position >= getItemCount()) {
            throw new IllegalArgumentException("Item position is out of adapter's range");
        } else if (dataCursor.moveToPosition(position)) {
            return new Item(dataCursor);
        }
        return null;


    }}