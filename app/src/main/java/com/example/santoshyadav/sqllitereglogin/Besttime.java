package com.example.santoshyadav.sqllitereglogin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.santoshyadav.sqllitereglogin.Adapter.BestTimeRecyclerAdapter;
import com.example.santoshyadav.sqllitereglogin.Model.PlacesListModelClass;

import java.util.ArrayList;

@SuppressWarnings("deprecation")
public class Besttime extends AppCompatActivity {


    RecyclerView recyclerView;
    BestTimeRecyclerAdapter adapter;
    ArrayList<PlacesListModelClass> placesListModelClasses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_besttime);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview_places_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Besttime.this);
        recyclerView.setLayoutManager(layoutManager);

        setData();

        adapter=new BestTimeRecyclerAdapter(placesListModelClasses,Besttime.this);
        recyclerView.setAdapter(adapter);
        runLayoutAnimation(recyclerView);
        adapter.notifyDataSetChanged();

    }

    private void setData(){


        //todo adding image and data
        placesListModelClasses=new ArrayList<>();

        PlacesListModelClass placesListModelClass1=new PlacesListModelClass("Matheran","https://image3.mouthshut.com/images/Restaurant/Photo/-87561_6870.jpg");
        placesListModelClasses.add(placesListModelClass1);
        PlacesListModelClass placesListModelClass2=new PlacesListModelClass("Lohagad","https://media-cdn.tripadvisor.com/media/photo-s/10/e3/ce/8a/lohagadh-fort-sanju-49.jpg");
        placesListModelClasses.add(placesListModelClass2);
        PlacesListModelClass placesListModelClass3=new PlacesListModelClass("Raireshwar","https://static2.tripoto.com/media/filter/nl/img/181992/TripDocument/1440636179_20150816_121603.jpg");
        placesListModelClasses.add(placesListModelClass3);
        PlacesListModelClass placesListModelClass4=new PlacesListModelClass("Rajmachi","https://img.theculturetrip.com/768x432/wp-content/uploads/2018/01/rajmachi-fort.jpg");
        placesListModelClasses.add(placesListModelClass4);
        PlacesListModelClass placesListModelClass5=new PlacesListModelClass("Lonavala","");
        placesListModelClasses.add(placesListModelClass5);
        PlacesListModelClass placesListModelClass6=new PlacesListModelClass("Sanjay Gandhi National Park","");
        placesListModelClasses.add(placesListModelClass6);
        PlacesListModelClass placesListModelClass7=new PlacesListModelClass("Matheran","");
        placesListModelClasses.add(placesListModelClass7);
        PlacesListModelClass placesListModelClass8=new PlacesListModelClass("Matheran","");
        placesListModelClasses.add(placesListModelClass8);
        PlacesListModelClass placesListModelClass9=new PlacesListModelClass("Matheran","");
        placesListModelClasses.add(placesListModelClass9);

    }
    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_down_to_up);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}