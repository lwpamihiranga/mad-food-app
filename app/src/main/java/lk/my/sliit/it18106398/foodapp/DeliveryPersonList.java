package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class DeliveryPersonList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelDeliverPerson> deliverPeople;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_person_list);

        recyclerView = findViewById(R.id.personListRecycleView);
    }
}
