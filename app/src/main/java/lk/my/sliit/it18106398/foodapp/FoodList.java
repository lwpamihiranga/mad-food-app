package lk.my.sliit.it18106398.foodapp;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FoodList extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Food_Items>foodList;



    FirebaseDatabase database;
    DatabaseReference food_Items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods_list);

        //Init firebase

        database = FirebaseDatabase.getInstance();
        food_Items = database.getReference("Food_Items");


        //load menu
        recyclerView = findViewById(R.id.foodsRecycleView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        loadMenu();


        //foodList = new ArrayList<>();

        //foodList.add(new Food_Items(R.drawable.friderice, "Mix Rice"));
        //foodList.add(new Food_Items(R.drawable.cheeskottu, "Cheese Kottu"));
       // foodList.add(new Food_Items(R.drawable.hoppers, "Hoppers"));
        //foodList.add(new Food_Items(R.drawable.noodles, "Noodles"));
//
       // FoodAdapter adapter = new FoodAdapter(this,foodList);

       // recyclerView.setAdapter(adapter);
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void loadMenu() {

        FirebaseRecyclerOptions<Food_Items> options = new FirebaseRecyclerOptions.Builder<Food_Items>().setQuery(food_Items,Food_Items.class).build();

        FirebaseRecyclerAdapter<Food_Items,FoodViewHolder> adapter = new FirebaseRecyclerAdapter<Food_Items, FoodViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FoodViewHolder foodViewHolder, int i, @NonNull Food_Items food_items) {




            }

            @NonNull
            @Override
            public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }
        };
    }

}
