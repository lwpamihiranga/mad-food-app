package lk.my.sliit.it18106398.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class MyBag extends AppCompatActivity implements OrderAdapter.onItemClickListener {

    RecyclerView recyclerView;
    //ArrayList<ModelOrder> orderList;
    ArrayList<OrderBag1> mUploads;
    ArrayList<String> description;
    ArrayList<Integer>qty;

    OrderAdapter adapter;
    DatabaseReference db;
    private FirebaseStorage mstorage;
    private ValueEventListener mDBListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bag);
        description = new ArrayList<>();
        qty = new ArrayList<>();
        mUploads = new ArrayList<>();

        mstorage = FirebaseStorage.getInstance();
        db = FirebaseDatabase.getInstance().getReference();
        mDBListener = db.child("OrderBag1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    for (DataSnapshot dss:dataSnapshot.getChildren())
                    {
                        //Toast.makeText(MyBag.this, "err", Toast.LENGTH_SHORT).show();
                        String desc = dss.child("description").getValue(String.class);
                        int quty = dss.child("qty").getValue(Integer.class);
                        description.add(desc);
                        qty.add(quty);

                        OrderBag1 upload = dss.getValue(OrderBag1.class);
                        upload.setKey(dss.getKey());
                        mUploads.add(upload);
                    }
                    adapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(MyBag.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        recyclerView = findViewById(R.id.foodsRecycleView);
        adapter = new OrderAdapter(getApplicationContext(),description,qty,mUploads);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(MyBag.this);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,"Normal click at position : "+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteClick(int position) {
        OrderBag1 selectedItem = mUploads.get(position);
        final String selectedKey = selectedItem.getKey();
        StorageReference imageRef = mstorage.getReference(selectedItem.getDescription());
        imageRef .delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                db.child(selectedKey).removeValue();
                Toast.makeText(MyBag.this,"Item deleted",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.removeEventListener(mDBListener);
    }
}
