package lk.my.sliit.it18106398.foodapp;

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

    EditText edittext1,edittext2,edittext3,edittext4;
    Button add_button;
    DatabaseReference dRef;
    FoodsTable food;

    //StorageReference foodfolder;

    private void clearControls(){
        edittext1.setText("");
        edittext2.setText("");
        edittext4.setText("");
        edittext3.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfoods);

        edittext1 = findViewById(R.id.editTxt1);
        edittext2 = findViewById(R.id.editTxt2);
        edittext3 = findViewById(R.id.editTxt2);
        edittext4 = findViewById(R.id.editText4);


        add_button= (Button) findViewById(R.id.button3);

        add_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              //Intent intent = new Intent(Addfoods.this,Promotion_ACTIVITY1.class);

                dRef = FirebaseDatabase.getInstance().getReference().child("FoodsTable");

                try {
                   if (TextUtils.isEmpty(edittext1.getText().toString())) {
                       Toast.makeText(getApplicationContext(), "Please Create food Item Number.", Toast.LENGTH_SHORT).show();
                   }else if(TextUtils.isEmpty(edittext2.getText().toString())){
                       Toast.makeText(getApplicationContext(),"enter food name",Toast.LENGTH_SHORT).show();
                  /* }else if(TextUtils.isEmpty(Integer.parseInt(edittext3.getText().toString())){
                       Toast.makeText(getApplicationContext(),"Enter price.",Toast.LENGTH_SHORT).show();*/
                   }else if(TextUtils.isEmpty(edittext4.getText().toString())){
                       Toast.makeText(getApplicationContext(),"Enter description hear.",Toast.LENGTH_SHORT).show();
                   }else{
                       food.setItemNo(edittext1.getText().toString().trim());
                       food.setFoodname(edittext2.getText().toString().trim());
                       food.setPrice(Integer.parseInt(edittext3.getText().toString().trim()));
                       food.setDiscription(edittext4.getText().toString().trim());

                       dRef.child("food1").setValue(food);

                       Toast.makeText(getApplicationContext(),"Data added successfully",Toast.LENGTH_SHORT).show();
                       clearControls();
                   }
               }catch (NumberFormatException ex){
                   Toast.makeText(getApplicationContext(),"Data should valide.",Toast.LENGTH_SHORT).show();
               }
           }
        });


    }
}
