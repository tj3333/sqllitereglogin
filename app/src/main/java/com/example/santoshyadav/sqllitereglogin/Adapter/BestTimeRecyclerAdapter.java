package com.example.santoshyadav.sqllitereglogin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.santoshyadav.sqllitereglogin.Activity.PlacesDescriptionActivity;
import com.example.santoshyadav.sqllitereglogin.Model.PlacesListModelClass;
import com.example.santoshyadav.sqllitereglogin.R;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BestTimeRecyclerAdapter extends RecyclerView.Adapter<BestTimeRecyclerAdapter.ViewHolder> {

    private ArrayList<PlacesListModelClass> placesListModelClasses;
    private Context context;

    public BestTimeRecyclerAdapter(ArrayList<PlacesListModelClass> placesListModelClasses, Context context) {
        this.placesListModelClasses = placesListModelClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_best_time_place_list,viewGroup,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        viewHolder.textView.setText(placesListModelClasses.get(i).getName());

        Picasso.Builder builder=new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context))
                .build().load(placesListModelClasses.get(i).getImage())
                .placeholder(R.drawable.load)
                .error(R.drawable.load)
                .into(viewHolder.imageView);

        viewHolder.cardViewBEstTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,PlacesDescriptionActivity.class);
                intent.putExtra("place_position",i);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return placesListModelClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        CardView cardViewBEstTime;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=(ImageView)itemView.findViewById(R.id.custom_img_best_time);
            textView=(TextView)itemView.findViewById(R.id.custom_text_best_time);
            cardViewBEstTime=(CardView) itemView.findViewById(R.id.cardViewBEstTime);

        }
    }
}
