package com.example.alex.cruisingalong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class PlacesActivity extends AppCompatActivity {

    private String[] places = {"The Good Home" , "The Bank" , "BlueStone Steak House" , "Sal's Pizza"};
    private Double[] Lats = { 175.2847478, 175.28524459999994, 175.28512439999997, 175.2842581 };
    private Double[] Longs = {-37.7908424, -37.7899659, -37.7890267, -37.788939};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, places);

        final ListView listView = (ListView) findViewById(R.id.PlacesList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String location = places[position];
                Toast.makeText(getApplicationContext(), "Navigating to " + location, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putExtra("LONG", Lats[position]);
                intent.putExtra("LAT", Longs[position]);
                intent.putExtra("Name", location);

                startActivity(intent);
            }
        });
    }
}
