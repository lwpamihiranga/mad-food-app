package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class promo_list extends AppCompatActivity {

    ArrayList<ModelPromotions> promotionsControl;
    DatabaseReference dbRef;
    RecyclerView recyclerControlView;
    ArrayList<Add_Promotions> promotion;
    ArrayList<String> PromoNo;
    ArrayList<String> food;
    ArrayList<String> Des;
    ResViewPromotionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_promo_list);

//        recyclerView = findViewById(R.id.controllerPromoList);

//        promotionsControl = new ArrayList<>();
//        PromotionsAdapter adapter = new PromotionsAdapter(this, promotionsControl);
//
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
