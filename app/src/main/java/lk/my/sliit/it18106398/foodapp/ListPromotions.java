package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ListPromotions extends AppCompatActivity {

    DatabaseReference dRef;
    RecyclerView recyclerView;
    ArrayList<ModelPromotions> promotions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_promotions);

        dRef = FirebaseDatabase.getInstance().getReference();
        recyclerView = findViewById(R.id.promoRecyclerView);

        promotions = new ArrayList<>();

        promotions.add(new ModelPromotions(R.drawable.pic12, "Bangladesh Cuisine"));
        promotions.add(new ModelPromotions(R.drawable.img6, "Beef Stroganoff"));
        promotions.add(new ModelPromotions(R.drawable.img10, "Sausage mix rice"));
        promotions.add(new ModelPromotions(R.drawable.img10, "Indean Kottu"));
        promotions.add(new ModelPromotions(R.drawable.img11, "Box-O-Noodles"));


        PromotionsAdapter adapter = new PromotionsAdapter(this, promotions);
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, promotions);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}