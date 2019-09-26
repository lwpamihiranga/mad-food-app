package lk.my.sliit.it18106398.foodapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
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

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

//have to add image to database

public class Add_Promotions extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    //StorageReference imageRef;
    EditText txt0_form, txt1_form, txt2_form, txt3_form, txt4_form;
    Button btn, btnDate;
    //ImageButton imageBtn;
    DatabaseReference dbRef;
    PromotionTable pro;
    Button upload;
    String savedate;
    private String downloadImgURL;

    SimpleDateFormat dform = new SimpleDateFormat("dd:mm:yy");
    private StorageReference folder;
    private static final int ImageBack = 1;

    private ProgressDialog mProgressDialog;
    /*public Add_Promotions(String number, String namePromo, String describe) {

    }*/

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

        folder = FirebaseStorage.getInstance().getReference();
        dbRef = FirebaseDatabase.getInstance().getReference();

        mProgressDialog = new ProgressDialog(this);

        txt0_form = (EditText) findViewById(R.id.editTxt0);
        txt1_form = (EditText) findViewById(R.id.editTxt1);
        txt2_form = (EditText) findViewById(R.id.editTxt2);
        txt3_form = (EditText) findViewById(R.id.editTxt3);
        txt4_form = (EditText) findViewById(R.id.editTxt4);

        //imageBtn = (ImageButton) findViewById(R.id.imageButton2);
        btn = (Button) findViewById(R.id.add_button);

        upload = findViewById(R.id.btnUploadImg);
        pro = new PromotionTable();

        btnDate = (Button) findViewById(R.id.tvDate);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new date_picker_fragment();
                datePicker.show(getSupportFragmentManager(),"Date Picker");

            }
        });

        /*imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,GALLERY_REQUEST);
            }
        });*/

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent = new Intent(Add_Promotions.this, Promotion_ACTIVITY1.class);
                //Toast.makeText(Add_Promotions.this, "Added New Promotion Successfully.", Toast.LENGTH_SHORT).show();
                dbRef = FirebaseDatabase.getInstance().getReference().child("PromotionTable");
                //folder = FirebaseStorage.getInstance().getReference().child("ImageFolder");
    //long x = new Date().getTime();
                try {
                    if (TextUtils.isEmpty(txt0_form.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please Create an ID for the Promotion.", Toast.LENGTH_SHORT).show();
                    }else if(TextUtils.isEmpty(txt1_form.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please Add the item number.", Toast.LENGTH_SHORT).show();
                    }else if(TextUtils.isEmpty(txt4_form.getText().toString())){
                        Toast.makeText(getApplicationContext(),"You should apply small description to this promotion.",Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(txt3_form.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Should add the promotion given quantity.", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        pro.setPromoNo(txt0_form.getText().toString().trim());
                        pro.setItemNo(txt1_form.getText().toString().trim());

                        pro.setFoodName(txt2_form.getText().toString().trim());
                        pro.setQty(Integer.parseInt(txt3_form.getText().toString().trim()));
                        pro.setDescription(txt4_form.getText().toString().trim());
                        //pro.setDeadlineDate(Integer.parseInt(btnDate.getText().toString()));

                        //dbRef.push().setValue(pro);
                        dbRef.child("Promotion 08").setValue(pro);

                        Toast.makeText(getApplicationContext(),"Data added successfully.",Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                }catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalid data is there.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,ImageBack);
            }
        });
    }

    /*private void store(){
        Calender calender = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("mmm dd yyyy");
        savedate = currentDate.format(calender.getTime());

    }*/
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
    /*public void update(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,ImageBack);
    }*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ImageBack && resultCode == RESULT_OK) {

            mProgressDialog.setMessage("Uploading....");
            mProgressDialog.show();
            Uri imageUri = data.getData();

            //StorageReference imgName = folder.child("image"+imageUri.getLastPathSegment());
            final StorageReference imgName = folder.child("Photos").child(imageUri.getLastPathSegment());
            imgName.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(Add_Promotions.this,"Uploaded",Toast.LENGTH_LONG ).show();
                    mProgressDialog.dismiss();
                    imgName.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            DatabaseReference imageStrore = FirebaseDatabase.getInstance().getReference().child("image");
                            HashMap<String,String> map = new HashMap<>();
                            map.put("imageurl",String.valueOf(uri));

                            imageStrore.setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Add_Promotions.this,"Finally Compleated",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                }
            });

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
