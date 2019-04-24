package com.example.santoshyadav.sqllitereglogin;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.santoshyadav.sqllitereglogin.data.ItemContract;

import java.text.DecimalFormat;


@SuppressWarnings("deprecation")
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    // Class variables for the Cursor that holds task data and the Context
    private Cursor mCursor;
    private Context mContext;


    /**
     * Constructor for the CustomCursorAdapter that initializes the Context.
     *
     * @param mContext the current Context
     */
    public CartAdapter(Context mContext) {
        this.mContext = mContext;
    }



    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {

        // Indices for the _id, description, and priority columns
        int idIndex = mCursor.getColumnIndex(ItemContract.ItemEntry._CARTID);
        int Name = mCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_CART_NAME);
        int image = mCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_CART_IMAGE);
        int quantity = mCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_CART_QUANTITY);
        int price = mCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_CART_TOTAL_PRICE);


        mCursor.moveToPosition(position); // get to the right location in the cursor

        // Determine the values of the wanted data
        final int id = mCursor.getInt(idIndex);
        String ItemName = mCursor.getString(Name);
        String ItemImage = mCursor.getString(image);
        int ItemQuantity = mCursor.getInt(quantity);
        Double ItemPrice = mCursor.getDouble(price);

        DecimalFormat precision = new DecimalFormat("0.00");



        //Set values
        holder.itemView.setTag(id);
        holder.iName.setText(ItemName);
        holder.iQuantity.setText("Quantity ordering: " + String.valueOf(ItemQuantity));
        holder.iPrice.setText("Rs." + precision.format(ItemPrice));

        String poster = "https://photos.google.com/u/1/album/AF1QipPhKQ9Ro2LLoxYfprBMRP56Xi081qAynaEO9s6T" + ItemImage;

        Glide.with(mContext)
                .load(poster)
                .placeholder(R.drawable.load)
                .into(holder.image);

    }


    @Override
    public int getItemCount() {
        if (mCursor == null) {
            return 0;
        }
        return mCursor.getCount();
    }

    public Cursor swapCursor(Cursor c) {
        // check if this cursor is the same as the previous cursor (mCursor)
        if (mCursor == c) {
            return null; // bc nothing has changed
        }
        Cursor temp = mCursor;
        this.mCursor = c; // new cursor value assigned

        //check if this is a valid cursor, then update the cursor
        if (c != null) {
            this.notifyDataSetChanged();
        }
        return temp;
    }

    @SuppressWarnings("deprecation")
    public class CartViewHolder extends RecyclerView.ViewHolder {
        TextView iName, iQuantity, iPrice;
        ImageView image;
        public CartViewHolder(View itemView) {
            super(itemView);

            iName = (TextView) itemView.findViewById(R.id.ItemName);
            iQuantity = (TextView) itemView.findViewById(R.id.quantity);
            iPrice = (TextView) itemView.findViewById(R.id.price);
            image = (ImageView) itemView.findViewById(R.id.cartImage);
        }

    }
}




