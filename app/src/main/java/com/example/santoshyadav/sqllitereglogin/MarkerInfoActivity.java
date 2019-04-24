package com.example.santoshyadav.sqllitereglogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MarkerInfoActivity extends AppCompatActivity {

    TextView _info_marker_name;
    Button _button_route_path, _button_expenditure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker_info);

        String markerTitleInfo = getIntent().getStringExtra("MARKER_NAME");


        _info_marker_name = findViewById(R.id.info_marker_name);
        _button_route_path = findViewById(R.id.button_route_path);
        _button_expenditure = findViewById(R.id.button_expenditure);
        _info_marker_name.setText(markerTitleInfo);

        _button_route_path.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MarkerInfoActivity.this,RouteMapActivity.class);
                intent.putExtra("MARKER_NAME",_info_marker_name.getText());
                startActivity(intent);
            }
        });

        _button_expenditure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarkerInfoActivity.this , Expenditure.class);
                intent.putExtra("MARKER_NAME",_info_marker_name.getText());
                startActivity(intent);
            }
        });


    }
}
