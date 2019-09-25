package lk.my.sliit.it18106398.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class promo_list extends AppCompatActivity /*implements ResViewPromotionAdapter.OnPromoClickListener*/ {

    RecyclerView recyclerView2;

    ArrayList<String> proNo;
    ArrayList<String> name;
    ArrayList<String> descriptions;
    ArrayList<Add_Promotions> PromoList2;
    ArrayList<Add_Promotions> promotions;
    DatabaseReference dbref;
    private FirebaseStorage stor;
    //private RequestQueue mRequestQueue;
    ArrayList<ModelViewPromotion> M2List;
    ResViewPromotionAdapter adapt;
    private ValueEventListener DBListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo_list);

        proNo = new ArrayList<>();
        name = new ArrayList<>();
        descriptions = new ArrayList<>();
        //PromoList2 = new ArrayList<Add_Promotions>();

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

                        //PromoList2.add(new Add_Promotions(number,namePromo,describe));
                        /*ModelViewPromotion up = dss.getValue(ModelViewPromotion.class);
                        up.setKey(dss.getKey());
                        M2List.add(up);*/
                    }
                    adapt.notifyDataSetChanged();
                    /*adapt = new ResViewPromotionAdapter(promo_list.this,PromoList2);
                    recyclerView2.setAdapter(adapt);
                    adapt.setOnPromoClickListener(promo_list.this);*/
                }else{
                    Toast.makeText(promo_list.this,"No data found.",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        recyclerView2 = findViewById(R.id.controllerPromoList);
        //recyclerView2.setHasFixedSize(true);
        adapt = new ResViewPromotionAdapter(getApplicationContext(),proNo,name,descriptions);

        recyclerView2.setAdapter(adapt);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

    }

    public void onPromoClick(int position) {
        //Intent detailIntent = new Intent(this, Add_Promotions.class);
         Toast.makeText(this,"Normal click at position : "+position,Toast.LENGTH_SHORT).show();

    }


    /*public void onDeleteClick(int position) {
        ModelViewPromotion selectedItem = M2List.get(position);
        final String selectedKey = selectedItem.getKey();
        StorageReference imageRef = stor.getReference(selectedItem.getDescription());
        imageRef .delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dbref.child(selectedKey).removeValue();
                Toast.makeText(promo_list.this,"Item deleted",Toast.LENGTH_SHORT).show();
            }
        });
    }*/
/*
    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbref.removeEventListener(DBListner);
    }*/
}
