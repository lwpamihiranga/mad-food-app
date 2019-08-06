package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RestuarantsList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelRestuarant> restuarantsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restuarants_list);

        recyclerView = findViewById(R.id.restuarantRecycleView);

        restuarantsList = new ArrayList<>();

        restuarantsList.add(new ModelRestuarant(R.drawable.res1, "Olive Garden"));
        restuarantsList.add(new ModelRestuarant(R.drawable.res2, "Dilanka Foods"));
        restuarantsList.add(new ModelRestuarant(R.drawable.res3, "Monasha Hotel"));
        restuarantsList.add(new ModelRestuarant(R.drawable.res4, "Lounge 171"));
        restuarantsList.add(new ModelRestuarant(R.drawable.res5, "Lanka Food Corner"));
        restuarantsList.add(new ModelRestuarant(R.drawable.res6, "Matara Bath Kade"));
        restuarantsList.add(new ModelRestuarant(R.drawable.res7, "Hawai Restuarant"));
        restuarantsList.add(new ModelRestuarant(R.drawable.res8, "Palle Kade"));
        restuarantsList.add(new ModelRestuarant(R.drawable.res9, "Antige Kade"));

        RestuarantsAdapter adapter = new RestuarantsAdapter(this, restuarantsList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager layoutManager1 = layoutManager;

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager1);
    }
}
