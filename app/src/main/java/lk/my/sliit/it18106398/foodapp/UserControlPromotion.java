package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserControlPromotion extends AppCompatActivity {

    EditText t1,t2;
    Button b1;
    DatabaseReference bd1;
    Promotions pro1;

    private void clearControls(){
        t1.setText("");
        t2.setText("");
        /*txt2_form.setText("");
        txt3_form.setText("");
        txt4_form.setText("");*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_control_promotion);

        t1 = findViewById(R.id.et1);
        t2 = findViewById(R.id.et2);
        b1 = findViewById(R.id.btnadd);

        pro1 = new Promotions();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd1 = FirebaseDatabase.getInstance().getReference().child("Promotions");
                try {
                    if (TextUtils.isEmpty(t1.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please Create an ID for the Promotion.", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(t2.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Should add the promotion given quantity.", Toast.LENGTH_SHORT).show();
                    }else{
                        pro1.setPromoNo(t1.getText().toString().trim());
                        pro1.setItemNo(t2.getText().toString().trim());
//                        pro.setFoodName(txt2_form.getText().toString().trim());
//                        pro.setQty(Integer.parseInt(txt3_form.getText().toString().trim()));
//                        pro.setDescription(txt4_form.getText().toString().trim());

                        bd1.push().setValue(pro1);

                        Toast.makeText(getApplicationContext(),"Data added successfully.",Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                }catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalide data is there.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
