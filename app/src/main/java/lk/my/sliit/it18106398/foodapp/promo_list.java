package lk.my.sliit.it18106398.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class promo_list extends AppCompatActivity {

    RecyclerView recyclerView2;

    ArrayList<String> proNo;
    ArrayList<String> name;
    ArrayList<String> descriptions;
    ArrayList<ModelViewPromotion> PromoList2;
    ArrayList<Add_Promotions> promotions;
    DatabaseReference dbref;

    ResViewPromotionAdapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo_list);

        proNo = new ArrayList<>();
        name = new ArrayList<>();
        descriptions = new ArrayList<>();

        dbref = FirebaseDatabase.getInstance().getReference();
        dbref.child("PromotionTable").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot dss:dataSnapshot.getChildren()){
                        Toast.makeText(promo_list.this, "loaded",Toast.LENGTH_SHORT).show();
                        String number = dss.child("promoNo").getValue(String.class);
                        String namePromo = dss.child("foodName").getValue(String.class);
                        String describe = dss.child("description").getValue(String.class);

                        proNo.add(number);
                        name.add(namePromo);
                        descriptions.add(describe);

                        adapt.notifyDataSetChanged();
                    }
                }else{
                    Toast.makeText(promo_list.this,"No data found.",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        recyclerView2 = findViewById(R.id.controllerPromoList);
        adapt = new ResViewPromotionAdapter(getApplicationContext(),proNo,name,descriptions);

        recyclerView2.setAdapter(adapt);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
    }
}
