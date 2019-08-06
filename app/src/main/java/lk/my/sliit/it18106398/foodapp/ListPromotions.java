package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListPromotions extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelPromotions> promotions;
    //Button btn_promo1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_promotions);

        recyclerView = findViewById(R.id.promoRecyclerView);

        promotions = new ArrayList<>();

        promotions.add(new ModelPromotions(R.drawable.pic11, "Promo 1"));
        promotions.add(new ModelPromotions(R.drawable.img6, "Promo 2"));
        promotions.add(new ModelPromotions(R.drawable.img9, "Promo 3"));
        promotions.add(new ModelPromotions(R.drawable.img10, "Promo 4"));
        promotions.add(new ModelPromotions(R.drawable.img11, "Promo 5"));

        PromotionsAdapter adapter = new PromotionsAdapter(this, promotions);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}