package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
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

        deliverPeople = new ArrayList<>();

        deliverPeople.add(new ModelDeliverPerson(R.drawable.pro1, "Anjalie Jolly"));
        deliverPeople.add(new ModelDeliverPerson(R.drawable.pro2, "Andrew Michel"));
        deliverPeople.add(new ModelDeliverPerson(R.drawable.pro3, "Sadun Sathsara"));
        deliverPeople.add(new ModelDeliverPerson(R.drawable.pro4, "Kate Perry"));
        deliverPeople.add(new ModelDeliverPerson(R.drawable.pro5, "Emma Watson"));
        deliverPeople.add(new ModelDeliverPerson(R.drawable.pro6, "Ellen Dengerous"));
        deliverPeople.add(new ModelDeliverPerson(R.drawable.pro7, "Eric Chen"));
        deliverPeople.add(new ModelDeliverPerson(R.drawable.pro8, "Shawn Mendis"));

        ListDeliveryPersonAdapter adapter = new ListDeliveryPersonAdapter(this, deliverPeople);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
