package lk.my.sliit.it18106398.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewFood extends AppCompatActivity {


    public static final String FOOD_NAME = "name";
    RecyclerView recyclerView;
    ArrayList<FoodItem> list;
    DatabaseReference reference;
    RestViewFoodAdapter adapter;
    FoodTable foodTable;
    Button btndelete;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food);

        btndelete = (Button)findViewById(R.id.btnfood_delete);
        recyclerView = findViewById(R.id.foodRecyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<FoodItem>();

        reference = FirebaseDatabase.getInstance().getReference().child("FoodTable");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    FoodItem F = dataSnapshot1.getValue(FoodItem.class);
                    list.add(F);
                }

                adapter = new RestViewFoodAdapter(ViewFood.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


      // recyclerView.setOnLongClickListener(new AdapterView.OnItemLongClickListener() {


       //     @Override
        //   public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
             // foodTable.setItemNo();




        //       return false;
       //    }
     //  });
       // recyclerView.setOnLongClickListener(new AdapterView.OnItemLongClickListener() {


        //    @Override
        //    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//
                //FoodTable foodTable = FoodTable.class.getName();

         //       showUpdateDialog(foodTable.getName());

         //       return false;
         //   }
       // });
   // }





      //  resViewfoods = new ArrayList<>();

      //  resViewfoods.add(new ModelViewFoods(R.drawable.friderice, "Mix Rice        Rs.250.00"));
       // resViewfoods.add(new ModelViewFoods(R.drawable.cheeskottu, "Cheese Kottu   Rs.350.00"));
       // resViewfoods.add(new ModelViewFoods(R.drawable.hoppers, "Hoppers        R.20.00"));
      //  resViewfoods.add(new ModelViewFoods(R.drawable.noodles, "Noodles     Rs.200.00"));
        //resViewfoods.add(new ModelViewFoods(R.drawable.img11, "Box-O-Noodles"));

       // RestViewFoodAdapter adapter = new RestViewFoodAdapter(this,resViewfoods);

        recyclerView.setAdapter(adapter);


      // recyclerView.setOnLongClickListener(new AdapterView.OnItemLongClickListener(){

         //  @Override
          // public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
          //    Intent updateDelete = new Intent(startService(),startActivity());

          //     return false;
          // }
     //  });


    }



    @Override
    protected void onResume() {
        super.onResume();

    }
}


