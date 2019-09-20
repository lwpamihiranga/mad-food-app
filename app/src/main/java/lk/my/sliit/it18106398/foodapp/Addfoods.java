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
import com.google.firebase.storage.StorageReference;

public class Addfoods extends AppCompatActivity {

    EditText edittext1,edittext2,edittext4;
    Button add_button1;
    DatabaseReference dRef;
    FoodTable foodstable;

    //StorageReference foodfolder;

    private void clear(){
        edittext1.setText("");
        edittext2.setText("");
        edittext4.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfoods);

        edittext1 = findViewById(R.id.editTxt1);
        edittext2 = findViewById(R.id.editText2);
        edittext4 = findViewById(R.id.editText4);
        //Button add_button;

        add_button1= (Button) findViewById(R.id.add_button);

        add_button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              //Intent intent = new Intent(Addfoods.this,Promotion_ACTIVITY1.class);

                dRef = FirebaseDatabase.getInstance().getReference().child("FoodTable");
               try {
                   if (TextUtils.isEmpty(edittext1.getText().toString())) {
                       Toast.makeText(getApplicationContext(), "Please Create food Item Number.", Toast.LENGTH_SHORT).show();
                   }else if(TextUtils.isEmpty(edittext2.getText().toString())){
                       Toast.makeText(getApplicationContext(),"Enter food name hear.",Toast.LENGTH_SHORT).show();
                   }else{
                       foodstable.setItemNo(edittext1.getText().toString().trim());
                       foodstable.setFoodname(edittext2.getText().toString().trim());
                       foodstable.setDiscription(edittext4.getText().toString().trim());

                       dRef.push().setValue(foodstable);

                       Toast.makeText(getApplicationContext(),"Data added successfully",Toast.LENGTH_SHORT).show();
                       clear();
                   }
               }catch (Exception ex){
                   Toast.makeText(getApplicationContext(),"Data should valide.",Toast.LENGTH_SHORT).show();
               }
           }
        });

    }
}
