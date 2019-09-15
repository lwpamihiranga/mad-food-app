package lk.my.sliit.it18106398.foodapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Add_Promotions extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    //String s1, s2;
    EditText txt0_form, txt1_form, txt2_form, txt3_form, txt4_form;
    Button btn, btnDate;
    ImageButton imageBtn;
    DatabaseReference dbRef;
    PromotionTable pro;

    private static final int GALLERY_REQUEST = 1;

    private void clearControls(){
        txt0_form.setText("");
        txt1_form.setText("");
        txt2_form.setText("");
        txt3_form.setText("");
        txt4_form.setText("");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_promotions);

        //Context context = getApplicationContext();

        txt0_form = (EditText) findViewById(R.id.editTxt0);
        txt1_form = (EditText) findViewById(R.id.editTxt1);
        txt2_form = (EditText) findViewById(R.id.editTxt2);
        txt3_form = (EditText) findViewById(R.id.editTxt3);
        txt4_form = (EditText) findViewById(R.id.editTxt4);

        imageBtn = (ImageButton) findViewById(R.id.imageButton2);
        btn = (Button) findViewById(R.id.add_button);

        pro = new PromotionTable();

        btnDate = (Button) findViewById(R.id.tvDate);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new date_picker_fragment();
                datePicker.show(getSupportFragmentManager(),"Date Picker");
                ;
            }
        });

        imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,GALLERY_REQUEST);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Add_Promotions.this, Promotion_ACTIVITY1.class);
                //Toast.makeText(Add_Promotions.this, "Added New Promotion Successfully.", Toast.LENGTH_SHORT).show();
                dbRef = FirebaseDatabase.getInstance().getReference().child("PromotionTable");
                try {
                    if (TextUtils.isEmpty(txt0_form.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please Create an ID for the Promotion.", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(txt1_form.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Should add the promotion given quantity.", Toast.LENGTH_SHORT).show();
                    }else{
                        pro.setPromoNo(txt0_form.getText().toString().trim());
                        pro.setItemNo(txt1_form.getText().toString().trim());

                        pro.setFoodName(txt2_form.getText().toString().trim());
                        pro.setQty(Integer.parseInt(txt3_form.getText().toString().trim()));
                        pro.setDescription(txt4_form.getText().toString().trim());


                        //dbRef.push().setValue(pro);
                        dbRef.child("promotion2").setValue(pro);

                        Toast.makeText(getApplicationContext(),"Data added successfully.",Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                }catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalide data is there.",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DAY_OF_MONTH,day);

        //String date = DateFormat.getDateInstant().format(cal.getTime());

        TextView txtView = (TextView) findViewById(R.id.tvDate);
        //txtView.setText(date);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK) {
            Uri imageUri = data.getData();

            imageBtn.setImageURI(imageUri);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();


    }
}
