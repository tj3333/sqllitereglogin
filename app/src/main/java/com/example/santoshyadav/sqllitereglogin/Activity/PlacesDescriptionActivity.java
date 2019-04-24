package com.example.santoshyadav.sqllitereglogin.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.santoshyadav.sqllitereglogin.Adapter.CustomPlacesAdapter;
import com.example.santoshyadav.sqllitereglogin.Model.PlacesDataModelClass;
import com.example.santoshyadav.sqllitereglogin.Model.PlacesListModelClass;
import com.example.santoshyadav.sqllitereglogin.R;

import java.util.ArrayList;

public class PlacesDescriptionActivity extends AppCompatActivity {


    ViewPager viewPager;
    ArrayList<PlacesDataModelClass> placesDataModelClasses;
    CustomPlacesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_description);

        viewPager=(ViewPager)findViewById(R.id.viewPager_places);
        setData();
        adapter=new CustomPlacesAdapter(PlacesDescriptionActivity.this,placesDataModelClasses,PlacesDescriptionActivity.this);
        viewPager.setAdapter(adapter);

        Intent intent=getIntent();
        Integer position=intent.getIntExtra("place_position",1);
        viewPager.setCurrentItem(position);

    }

    //todo add data here images and all others data
    public void setData(){
        placesDataModelClasses=new ArrayList<>();

        PlacesDataModelClass p1,p2,p3,p4,p5,p6;

        p1=new PlacesDataModelClass("1","https://image3.mouthshut.com/images/Restaurant/Photo/-87561_6870.jpg",
                "Matheran","dsd2222222222222222222222222222s");
        placesDataModelClasses.add(p1);

        p2=new PlacesDataModelClass("2","https://media-cdn.tripadvisor.com/media/photo-s/10/e3/ce/8a/lohagadh-fort-sanju-49.jpg",
                "Lohagad","dsd2222222222222222222222222222222222222222s");


        p3=new PlacesDataModelClass("3","https://static2.tripoto.com/media/filter/nl/img/181992/TripDocument/1440636179_20150816_121603.jpg",
                "Raireshwar","dsd22222222222222222222222222222222222222222222s");

        p4=new PlacesDataModelClass("4","https://img.theculturetrip.com/768x432/wp-content/uploads/2018/01/rajmachi-fort.jpg",
                "Rajmachi","sd2222222222222222222222222222222222222222222222sd");

        p5=new PlacesDataModelClass("5","https://img.theculturetrip.com/768x432/wp-content/uploads/2018/01/rajmachi-fort.jpg","Lonavala","dsds");
        p6=new PlacesDataModelClass("6","https://img.theculturetrip.com/768x432/wp-content/uploads/2018/01/rajmachi-fort.jpg","Sanjay Gandhi National Park","dsds");

        placesDataModelClasses.add(p2);
        placesDataModelClasses.add(p3);
        placesDataModelClasses.add(p4);
        placesDataModelClasses.add(p5);
        placesDataModelClasses.add(p6);


    }
}
