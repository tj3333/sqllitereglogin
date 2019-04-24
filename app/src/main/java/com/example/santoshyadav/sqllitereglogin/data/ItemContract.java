package com.example.santoshyadav.sqllitereglogin.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;


public class ItemContract {

    private ItemContract() {}

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.santoshyadav.sqllitereglogin";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);



    public static final String PATH_Item = "Item-path";

    public static final String PATH_CART= "cart-path";


    /**
     * Inner class that defines constant values for the Item database table.
     * Each entry in the table represents a single Item
     */
    public static final class ItemEntry implements BaseColumns {

        /**
         * The content URI to access the fragrance data in the provider
         */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_Item);

        public static final Uri CONTENT_URI_CART = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_CART);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of Item.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_Item;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single Item.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_Item;

        /**
         * Name of database table for Item
         */
        public final static String TABLE_NAME = "Items";

        //cart table name
        public final static String CART_TABLE = "cart";

        /**
         * Unique ID number for the Item (only for use in the database table).
         * <p>
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        public final static String _CARTID = BaseColumns._ID;

        /**
         * Name of the Item.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_NAME = "Itemname";
        public final static String COLUMN_DESCRIPTION = "description";
        public final static String COLUMN_IMAGE = "imageurl";
        public final static String COLUMN_PRICE = "price";
        public final static String COLUMN_USERRATING = "userrating";


        public final static String COLUMN_CART_NAME = "cartItemname";
        public final static String COLUMN_CART_IMAGE = "cartimageurl";
        public final static String COLUMN_CART_QUANTITY = "cartquantity";
        public final static String COLUMN_CART_TOTAL_PRICE = "carttotalprice";


    }}