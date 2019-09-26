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

public class LoginActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    Button btnLogin;

    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView textView = findViewById(R.id.textView10);
        Button loginButton = findViewById(R.id.btnLogin);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Sign Up Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Login Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, NavigationDrawerActivity.class);
                startActivity(intent);
            }
        });

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dbRef = FirebaseDatabase.getInstance().getReference().child("User").child(editTextUsername.getText().toString().trim());
//
//                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        if(dataSnapshot.hasChildren()) {
//                            String username = dataSnapshot.child("username").getValue().toString();
//                            String password = dataSnapshot.child("password").getValue().toString();
//                            String type = dataSnapshot.child("type").getValue().toString();
//
//                            if(type.equalsIgnoreCase("Customer")) {
//                                Intent intent = new Intent(getApplicationContext(), FoodList.class);
//                                startActivity(intent);
//                                Toast.makeText(getApplicationContext(), "Singing in as a Customer", Toast.LENGTH_SHORT).show();
//                            } else if(type.equalsIgnoreCase("Restaurant")) {
//                                Toast.makeText(getApplicationContext(), "Singing in as a Restaurant", Toast.LENGTH_SHORT).show();
//                            } else if(type.equalsIgnoreCase("Delivery")) {
//                                Toast.makeText(getApplicationContext(), "Singing in as a Delivery Driver", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
//            }
//        });
    }
}
