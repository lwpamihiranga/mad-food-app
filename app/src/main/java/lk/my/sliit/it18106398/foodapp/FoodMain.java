package lk.my.sliit.it18106398.foodapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodMain extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelFood> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_main);

//        Log.d(TAG,"onCreate: started.");

        recyclerView = findViewById(R.id.recycler_view);

        foods = new ArrayList<>();

        foods.add(new ModelFood(R.drawable.sandwitch, "SandWitch"));
        foods.add(new ModelFood(R.drawable.kottu, "Kottu"));
        foods.add(new ModelFood(R.drawable.stringhoppers, "Chukki"));

        FoodAdapter adapter = new FoodAdapter(this, foods);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
