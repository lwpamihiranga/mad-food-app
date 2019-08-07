package lk.my.sliit.it18106398.foodapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ModelFood>foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods_list);


        recyclerView = findViewById(R.id.foodsRecycleView);

        foodList = new ArrayList<>();

        foodList.add(new ModelFood(R.drawable.friderice, "Mix Rice        Rs.250.00"));
        foodList.add(new ModelFood(R.drawable.cheeskottu, "Cheese Kottu   Rs.350.00"));
        foodList.add(new ModelFood(R.drawable.hoppers, "Hoppers"));
        foodList.add(new ModelFood(R.drawable.noodles, "Noodles"));
        //foodList.add(new ModelRestuarant(R.drawable.res5, "Lanka Food Corner"));
        //foodList.add(new ModelRestuarant(R.drawable.res6, "Matara Bath Kade"));
        //foodList.add(new ModelRestuarant(R.drawable.res7, "Hawai Restuarant"));
        //foodList.add(new ModelRestuarant(R.drawable.res8, "Palle Kade"));
        //foodList.add(new ModelRestuarant(R.drawable.res9, "Antige Kade"));

        FoodAdapter adapter = new FoodAdapter(this,foodList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}
