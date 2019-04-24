package com.example.santoshyadav.sqllitereglogin.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.santoshyadav.sqllitereglogin.Model.PlacesDataModelClass;
import com.example.santoshyadav.sqllitereglogin.R;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomPlacesAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<PlacesDataModelClass> placesDataModelClasses;
    private LayoutInflater mLayoutInflater;
    private AppCompatActivity activity;


    public CustomPlacesAdapter(Context context, ArrayList<PlacesDataModelClass> placesDataModelClasses,
                               AppCompatActivity activity) {
        this.context = context;
        this.placesDataModelClasses = placesDataModelClasses;
        this.activity=activity;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view=mLayoutInflater.inflate(R.layout.custom_places_view,container,false);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewPlaces);
        TextView textViewName=(TextView) view.findViewById(R.id.place_name);
        ImageView imageView1=(ImageView)view.findViewById(R.id.desc_icon);

        Picasso.Builder builder=new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context))
                .build().load(placesDataModelClasses.get(position).getImage())
                .placeholder(R.drawable.matheran)
                .error(R.drawable.matheran)
                .into(imageView);

        textViewName.setText(placesDataModelClasses.get(position).getName());

        final String description=placesDataModelClasses.get(position).getDescription();

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final android.app.AlertDialog.Builder alertadd;
                alertadd = new android.app.AlertDialog.Builder(
                        context);
                alertadd.setTitle(placesDataModelClasses.get(position).getName());
                alertadd.setMessage(description);
                alertadd.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertadd.show();

            }
        });

        container.addView(view);
        return view;

    }

    @Override
    public int getCount() {
        return placesDataModelClasses.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view == ((View) o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
