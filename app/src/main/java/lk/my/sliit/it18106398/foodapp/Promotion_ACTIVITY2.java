package lk.my.sliit.it18106398.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.Instant;
import java.util.ArrayList;

public class Promotion_ACTIVITY2 extends AppCompatActivity {

   /* RecyclerView recyclerView;
    //ArrayList<ModelViewPromotion> resViewpromotions;
    ArrayList<ModelViewPromotion> promotional;
    ArrayList<String> proNo;
    ArrayList<String> name;
    ArrayList<String> descriptions;
    //Button btn_promo_update;

    ResViewPromotionAdapter adapt;
    Button update;
    Button delete;
    DatabaseReference db;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion__activity2);

        /*proNo = new ArrayList<>();
        name = new ArrayList<>();
        descriptions = new ArrayList<>();

        db = FirebaseDatabase.getInstance().getReference();
        db.child("PromotionTable").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot dss:dataSnapshot.getChildren()){
                        Toast.makeText(Promotion_ACTIVITY2.this, "err",Toast.LENGTH_SHORT).show();
                        String number = dss.child("promoNo").getValue(String.class);
                        String namePromo = dss.child("foodName").getValue(String.class);
                        String describe = dss.child("description").getValue(String.class);

                        proNo.add(number);
                        name.add(namePromo);
                        descriptions.add(describe);

                        adapt.notifyDataSetChanged();

                    }
                }else{
                    Toast.makeText(Promotion_ACTIVITY2.this,"No data founded.Try again.",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        recyclerView = findViewById(R.id.promoRecyclerView);
        adapt = new ResViewPromotionAdapter(getApplicationContext(),proNo,name,descriptions);

        recyclerView.setAdapter(adapt);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
*/
    }
}
