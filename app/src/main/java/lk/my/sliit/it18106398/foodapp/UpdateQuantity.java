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
    Button btnUpdate;
    DatabaseReference dbRef;
    OrderBag1 orderBag1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_qty);

        des = (TextView) findViewById(R.id.des);
        qty = (EditText) findViewById(R.id.editqty);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        Intent intent = getIntent();
        String d = intent.getStringExtra("des");
        des.setText(d);

        orderBag1 = new OrderBag1();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child(" OrderBag1");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("s1")) {
                            try {
                                orderBag1.setQty(Integer.parseInt(qty.getText().toString().trim()));
                                dbRef = FirebaseDatabase.getInstance().getReference().child(" OrderBag1").child("s1");
                                dbRef.setValue(orderBag1);

                                Toast.makeText(getApplicationContext(), "Data updated successfully", Toast.LENGTH_SHORT).show();
                            } catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(), "Invalid quantity", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "No source to found", Toast.LENGTH_SHORT).show();
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
