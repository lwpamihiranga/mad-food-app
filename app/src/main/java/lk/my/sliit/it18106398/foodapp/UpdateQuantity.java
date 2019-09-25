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

public class UpdateQuantity extends AppCompatActivity {

    TextView des;
    EditText qty;
    Button btnUpdate, btnDelete;
    DatabaseReference dbRef;
    OrderBag1 orderBag1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_qty);

        des = (TextView) findViewById(R.id.des);
        qty = (EditText) findViewById(R.id.editqty);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        Intent intent = getIntent();
        final String d = intent.getStringExtra("des");

        final String pos = intent.getExtras().get("position").toString();
        des.setText(d);
        qty.setText(pos);

        orderBag1 = new OrderBag1();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("OrderBag1");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds : dataSnapshot.getChildren()){
                            String sauDis = ds.child("description").getValue().toString();
                            String sauAmo = ds.child("qty").getValue().toString();

                            if(sauDis.equalsIgnoreCase(d) && sauAmo.equalsIgnoreCase(pos)){
                                orderBag1.setDescription(d);
                                orderBag1.setQty(Integer.parseInt(qty.getText().toString().trim()));

                                ds.getRef().setValue(orderBag1);
                                Toast.makeText(getApplicationContext(), "Data updated successfully", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(UpdateQuantity.this, MyBag.class);
                                startActivity(intent);

                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UpdateQuantity.this, "Delete clicked", Toast.LENGTH_SHORT).show();
                final DatabaseReference DelRef = FirebaseDatabase.getInstance().getReference().child("OrderBag1");
                DelRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds : dataSnapshot.getChildren()){
                            String sauDis = ds.child("description").getValue().toString();
                            String sauAmo = ds.child("qty").getValue().toString();

                            if(sauDis.equalsIgnoreCase(d) && sauAmo.equalsIgnoreCase(pos)){
                                ds.getRef().removeValue();

                                ds.getRef().setValue(orderBag1);
                                Toast.makeText(getApplicationContext(), "Data deleted successfully", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(UpdateQuantity.this, MyBag.class);
                                startActivity(intent);

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
