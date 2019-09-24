package lk.my.sliit.it18106398.foodapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FoodList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Food_Items>foodList;

    FirebaseDatabase database;
    DatabaseReference food_Items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods_list);

        //Init firebase

        database = FirebaseDatabase.getInstance();
        food_Items = database.getReference("Food_");

        recyclerView = findViewById(R.id.foodsRecycleView);

        foodList = new ArrayList<>();

        foodList.add(new Food_Items(R.drawable.friderice, "Mix Rice"));
        foodList.add(new Food_Items(R.drawable.cheeskottu, "Cheese Kottu"));
        foodList.add(new Food_Items(R.drawable.hoppers, "Hoppers"));
        foodList.add(new Food_Items(R.drawable.noodles, "Noodles"));

        FoodAdapter adapter = new FoodAdapter(this,foodList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}
