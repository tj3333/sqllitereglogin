package com.example.santoshyadav.sqllitereglogin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.santoshyadav.sqllitereglogin.Model.BookPlacesModelClass;
import com.example.santoshyadav.sqllitereglogin.R;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;

public class BookingActivity extends AppCompatActivity {

    private Integer vehicle_price=0;
    private Spinner spinner;
    ArrayList<BookPlacesModelClass> bookPlacesModelClasses;
    ArrayList<String> listPlaces;
    ArrayAdapter<String> dataAdapter;
    TextView distance_booking,price;
    Integer place_price=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        RadioGroup radioGroup =(RadioGroup)findViewById(R.id.radio_group);
        spinner=(Spinner)findViewById(R.id.spinner);
        distance_booking=(TextView)findViewById(R.id.distance_booking);
        price=(TextView)findViewById(R.id.price);
        setData();
        listPlaces=new ArrayList<>();
        for (int i=0;i<bookPlacesModelClasses.size();i++){

            listPlaces.add(bookPlacesModelClasses.get(i).getName());

        }

        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPlaces);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                distance_booking.setText("Distance : "+bookPlacesModelClasses.get(position).getDistance());
                place_price=Integer.valueOf(bookPlacesModelClasses.get(position).getPrice());

                Integer final_price=place_price+vehicle_price;

                price.setText("Price        : "+final_price);
//                ((TextView) parent.getChildAt(position)).setTextColor(getResources().getColor(android.R.color.holo_green_light));


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio1:
                        vehicle_price=2000;                  //bus price
                        price.setText(vehicle_price+place_price+"");
                    break;
                    case R.id.radio2:
                        vehicle_price=4000;                 //car price
                        price.setText(vehicle_price+place_price+"");
                        break;
                    case R.id.radio3:
                        vehicle_price=1000;                  //cycle price
                        price.setText(vehicle_price+place_price+"");
                    break;

                }
            }
        });
    }

    public void setData(){

        bookPlacesModelClasses=new ArrayList<>();
        BookPlacesModelClass b1,b2,b3,b4,b5,b6;
        b1=new BookPlacesModelClass("1","Matheran","87 Km ","1000");
        b2=new BookPlacesModelClass("2","Lohagad","66 Km ","900");
        b3=new BookPlacesModelClass("3","Raireshwar","17 Km ","300");
        b4=new BookPlacesModelClass("4","Rajmachi","82 Km ","900");
        b5=new BookPlacesModelClass("5","Sanjay Gandhi National park ","11 Km ","100");
        b6=new BookPlacesModelClass("6","Lonavala","82 Km ","950");

        bookPlacesModelClasses.add(b1);
        bookPlacesModelClasses.add(b2);
        bookPlacesModelClasses.add(b3);
        bookPlacesModelClasses.add(b4);
        bookPlacesModelClasses.add(b5);
        bookPlacesModelClasses.add(b6);




    }
}
