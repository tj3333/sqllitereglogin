package com.example.santoshyadav.sqllitereglogin;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Button;
import android.widget.TextView;

import com.example.santoshyadav.sqllitereglogin.data.ItemContract;

import java.text.NumberFormat;


@SuppressWarnings("deprecation")
public class CartActivity extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<Cursor>
{


    private static final int CART_LOADER = 0;

    /** Adapter for the ListView */
    CartAdapter cartAdapter;
    RecyclerView mRecyclerView;
    Double totalPrice;
    Button paymentButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        // Set the RecyclerView to its corresponding view
        mRecyclerView = (RecyclerView) findViewById(R.id.cart_recycler);

        // Set the layout for the RecyclerView to be a linear layout, which measures and
        // positions items within a RecyclerView into a linear list
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the adapter and attach it to the RecyclerView
        cartAdapter = new CartAdapter(this);
        mRecyclerView.setAdapter(cartAdapter);
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            // Called when a user swipes left or right on a ViewHolder
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                // Here is where you'll implement swipe to delete

                // COMPLETED (1) Construct the URI for the item to delete
                //[Hint] Use getTag (from the adapter code) to get the id of the swiped item
                // Retrieve the id of the task to delete
                int id = (int) viewHolder.itemView.getTag();

                // Build appropriate uri with String row id appended
                String stringId = Integer.toString(id);
                Uri uri = ItemContract.ItemEntry.CONTENT_URI_CART;
                uri = uri.buildUpon().appendPath(stringId).build();

                // COMPLETED (2) Delete a single row of data using a ContentResolver
                getContentResolver().delete(uri, null, null);
                // COMPLETED (3) Restart the loader to re-query for all tasks after a deletion
                getLoaderManager().restartLoader(CART_LOADER, null, CartActivity.this);

            }
        }).attachToRecyclerView(mRecyclerView);

        getLoaderManager().initLoader(CART_LOADER, null, this);
    }
    @Override
    public Loader<Cursor> onCreateLoader ( int i, Bundle bundle){
        // Define a projection that specifies the columns from the table we care about.
        String[] projection = {
                ItemContract.ItemEntry._CARTID,
                ItemContract.ItemEntry.COLUMN_CART_NAME,
                ItemContract.ItemEntry.COLUMN_CART_IMAGE,
                ItemContract.ItemEntry.COLUMN_CART_QUANTITY,
                ItemContract.ItemEntry.COLUMN_CART_TOTAL_PRICE,
        };

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                ItemContract.ItemEntry.CONTENT_URI_CART,   // Provider content URI to query
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order
    }


    @Override
    public void onLoadFinished (Loader< Cursor > loader, Cursor cursor){

        cartAdapter.swapCursor(cursor);
        calculateTotal(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onResume () {
        super.onResume();
        getLoaderManager().restartLoader(CART_LOADER, null, CartActivity.this);
    }

    public double calculateTotal (Cursor cursor){
        totalPrice = 0.00;
        for (int i = 0; i < cursor.getCount(); i++) {
            int price = cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_CART_TOTAL_PRICE);

            cursor.moveToPosition(i);
            Double ItemPrice = cursor.getDouble(price);
            totalPrice += ItemPrice;

        }

        TextView totalCost = (TextView) findViewById(R.id.totalPrice);
        String convertPrice = NumberFormat.getCurrencyInstance().format(totalPrice);
        totalCost.setText(convertPrice);
        return totalPrice;
    }



}

