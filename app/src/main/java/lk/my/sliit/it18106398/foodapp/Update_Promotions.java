package lk.my.sliit.it18106398.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Update_Promotions extends AppCompatActivity {

    EditText data1;
    EditText data2;
    /*EditText data3;
    EditText data4;*/
    Button update;
    DatabaseReference dbf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__promotions);

        data1 = findViewById(R.id.txtdata1);
        data2 = findViewById(R.id.txtdata2);
        /*data3 = findViewById(R.id.txtdata3);
        data4 = findViewById(R.id.txtdata4);*/
        final ModelViewPromotion mView;
        update = findViewById(R.id.updateDataBtn);

        Intent intent = getIntent();
        final String x = intent.getStringExtra("pName");
        final String y = intent.getStringExtra("pDesc");
        //String z = intent.getStringExtra("pQty");
        //String descri = intent.getStringExtra("desc");
        data1.setText(x);
        data2.setText(y);
        //data3.setText(z);
        mView = new ModelViewPromotion();
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference dbf = FirebaseDatabase.getInstance().getReference().child("PromotionTable");
                dbf.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds: dataSnapshot.getChildren()){
                            String proFood = ds.child("foodName").getValue().toString();
                            String proDes = ds.child("description").getValue().toString();

                            if(proFood.equalsIgnoreCase(x) && proDes.equalsIgnoreCase(y)){
                                mView.setFoodName(x);
                                mView.setDescription(y);

                                ds.getRef().setValue(mView);
                                Toast.makeText(getApplicationContext(),"Data Updated Successfully.",Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(Update_Promotions.this,Resturent_Home.class);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
