package lk.my.sliit.it18106398.foodapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewFood extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelViewFoods> resViewfoods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food);



        recyclerView = findViewById(R.id.foodRecyclerView2);

        resViewfoods = new ArrayList<>();

        resViewfoods.add(new ModelViewFoods(R.drawable.friderice, "Mix Rice        Rs.250.00"));
        resViewfoods.add(new ModelViewFoods(R.drawable.cheeskottu, "Cheese Kottu   Rs.350.00"));
        resViewfoods.add(new ModelViewFoods(R.drawable.hoppers, "Hoppers        R.20.00"));
        resViewfoods.add(new ModelViewFoods(R.drawable.noodles, "Noodles     Rs.200.00"));
        //resViewfoods.add(new ModelViewFoods(R.drawable.img11, "Box-O-Noodles"));

        RestViewFoodAdapter adapter = new RestViewFoodAdapter(this,resViewfoods);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}


