package lk.my.sliit.it18106398.foodapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestuarantsList extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<ModelRestaurant> restuarantsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restuarants_list);



        recyclerView = findViewById(R.id.restuarantRecycleView);

        restuarantsList = new ArrayList<>();

        restuarantsList.add(new ModelRestaurant(R.drawable.res1, "Olive Garden"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res2, "Dilanka Foods"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res3, "Monasha Hotel"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res4, "Lounge 171"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res5, "Lanka Food Corner"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res6, "Matara Bath Kade"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res7, "Hawai Restuarant"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res8, "Palle Kade"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res9, "Antige Kade"));

        RestuarantsAdapter adapter = new RestuarantsAdapter(this, restuarantsList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    }

