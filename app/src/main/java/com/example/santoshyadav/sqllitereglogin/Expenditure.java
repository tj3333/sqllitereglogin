package com.example.santoshyadav.sqllitereglogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.santoshyadav.sqllitereglogin.Model.BookPlacesModelClass;
import com.example.santoshyadav.sqllitereglogin.Model.ExpenditurePlacesModelClass;

import java.util.ArrayList;


public class Expenditure extends AppCompatActivity {

    TextView final_price_expenditure,time_expenditure,last_yr_cost;
    Spinner spinner;
    ArrayList<ExpenditurePlacesModelClass> expenditurePlacesModelClasses;

    ArrayList<String> listPlaces;
    ArrayAdapter<String> dataAdapter;
    private Integer temp_price=0;
    RadioGroup radio_group;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenditure);



        final_price_expenditure=(TextView)findViewById(R.id.final_price_expenditure);
        time_expenditure=(TextView)findViewById(R.id.time_expenditure);
        last_yr_cost=(TextView)findViewById(R.id.last_yr_cost);
        spinner=(Spinner)findViewById(R.id.spinner);
        radio_group=(RadioGroup)findViewById(R.id.radio_group);

        setData();
        listPlaces=new ArrayList<>();
        for (int i=0;i<expenditurePlacesModelClasses.size();i++){

            listPlaces.add(expenditurePlacesModelClasses.get(i).getName());

        }
        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPlaces);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                last_yr_cost.setText("Last year cost :  "+expenditurePlacesModelClasses.get(position).getLast_yr_cost());
                time_expenditure.setText("Time                 :  "+expenditurePlacesModelClasses.get(position).getTime());

                temp_price=Integer.valueOf(expenditurePlacesModelClasses.get(position).getLast_yr_cost());

//                ((TextView) parent.getChildAt(position)).setTextColor(getResources().getColor(android.R.color.holo_green_light));


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio1:
                        final_price_expenditure.setText("Cost  : "+(temp_price+1000)+"/-");
                    break;
                    case R.id.radio2:
                        final_price_expenditure.setText("Cost  : "+(temp_price+3000)+"/-");
                    break;
                }
            }
        });


    }

    public void setData(){

        expenditurePlacesModelClasses=new ArrayList<>();
        ExpenditurePlacesModelClass e1,e2,e3,e4,e5,e6;

        e1=new ExpenditurePlacesModelClass("1","Matheran","1000","10:00AM-10:00PM");
        e2=new ExpenditurePlacesModelClass("2","Lohagad","900","12:00PM-10:00PM");
        e3=new ExpenditurePlacesModelClass("3","Raireshwar","300","12:00PM-08:00PM");
        e4=new ExpenditurePlacesModelClass("4","Rajmachi","900","11:00AM-06:30PM");
        e5=new ExpenditurePlacesModelClass("5","Sanjay Gandhi National park ","100","10:30AM-05:00");
        e6=new ExpenditurePlacesModelClass("6","Lonavala","950","11:30AM-06:30PM");

        expenditurePlacesModelClasses.add(e1);
        expenditurePlacesModelClasses.add(e2);
        expenditurePlacesModelClasses.add(e3);
        expenditurePlacesModelClasses.add(e4);
        expenditurePlacesModelClasses.add(e5);
        expenditurePlacesModelClasses.add(e6);
    }
}
