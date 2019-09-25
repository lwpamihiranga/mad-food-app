package lk.my.sliit.it18106398.foodapp;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class DisplayFoodsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView description;
    EditText qty;
    private Uri mImageUri;

    Button b1;
    private StorageReference mStorageRef;
    DatabaseReference dbRef;
    OrderBag1 o;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_foods);

        description = findViewById(R.id.foodNameTxtView);
        qty = findViewById(R.id.qty);

        b1 = findViewById(R.id.btn1);

        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");
        dbRef = FirebaseDatabase.getInstance().getReference("uploads");

        o = new OrderBag1();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DisplayFoodsActivity.this, MyBag.class);
                startActivity(intent1);

                uploadFile();

                dbRef = FirebaseDatabase.getInstance().getReference().child("OrderBag1");
                try {
                    o.setQty(Integer.parseInt(qty.getText().toString().trim()));
                    o.setDescription(description.getText().toString().trim());

                     dbRef.push().setValue(o);
                    //dbRef.child("s1").setValue(o);

                    Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                    qty.setText("");
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid quantity", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imageView = findViewById(R.id.imageTop);

        imageView.setImageResource(getIntent().getIntExtra("image_id", 00));
        description.setText(getIntent().getStringExtra("res_name"));

        Intent i1 = getIntent();
        String name = i1.getStringExtra("fName");
        description.setText(name);
    }

    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return  mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile(){
        if (mImageUri != null) {
            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()+"."+getFileExtension(mImageUri));
            fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(DisplayFoodsActivity.this,"upload successfull",Toast.LENGTH_LONG).show();
                            OrderBag1 upload = new OrderBag1();
                            String uploadId = dbRef.push().getKey();
                            dbRef.child(uploadId).setValue(o);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(DisplayFoodsActivity.this, e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else{
            Toast.makeText(this,"No file selected", Toast.LENGTH_SHORT).show();
        }
    }
}
