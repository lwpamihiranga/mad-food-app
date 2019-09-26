package lk.my.sliit.it18106398.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Addfoods extends AppCompatActivity {



    DatabaseReference databaseReference;
    Button add_button1;
    EditText editFoodName,editPrice,editFoodDescription,editFoodNo;
    FoodTable fdt;


    private void clearControls(){
        editFoodName.setText("");
        editFoodNo.setText("");
        editPrice.setText("");
        editFoodDescription.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfoods);

        add_button1= (Button) findViewById(R.id.BtnAddFoods);
        editFoodName = (EditText)findViewById(R.id.editFoodName);
        editFoodNo = (EditText)findViewById(R.id.editFoodNo);
        editFoodDescription = (EditText)findViewById(R.id.editFoodDescription);
        editPrice = (EditText)findViewById(R.id.editPrice);

       fdt = new FoodTable();

        add_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference = FirebaseDatabase.getInstance().getReference().child("FoodTable");

                try {
                    if (TextUtils.isEmpty(editFoodName.getText().toString()))
                        Toast.makeText(getApplicationContext(),"please enter food name..!",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editFoodNo.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter food no..!",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editFoodDescription.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter food description..!",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(editPrice.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter food price..!",Toast.LENGTH_SHORT).show();

                    else{
                        fdt.setItemNo(editFoodNo.getText().toString().trim());
                        fdt.setName(editFoodName.getText().toString().trim());
                        fdt.setPrice(editPrice.getText().toString().trim());
                        fdt.setDescription(editFoodDescription.getText().toString().trim());

//                        databaseReference.child("fdt2").setValue(fdt);
                        databaseReference.push().setValue(fdt);
//                        databaseReference.child(fdt.getItemNo()).setValue(fdt);
                        Toast.makeText(getApplicationContext(),"Food Item Saved Successfully!..",Toast.LENGTH_SHORT).show();
//                        clearControls();

                    }


                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalid Data!!!",Toast.LENGTH_SHORT).show();




                    //add_button1.setOnClickListener(new View.OnClickListener() {
                    //  @Override
                    //  public void onClick(View view) {
                    //    Intent intent = new Intent(Addfoods.this, Promotion_ACTIVITY1.class);


                    //  }
                    //});

                }


            }
        });


    }
}
