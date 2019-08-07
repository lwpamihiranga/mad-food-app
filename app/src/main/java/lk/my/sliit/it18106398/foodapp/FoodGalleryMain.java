package lk.my.sliit.it18106398.foodapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class FoodGalleryMain extends AppCompatActivity {

    private static final String TAG = "FoodGalleryMain";
    Button b1;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_foodgallery);
        Log.d(TAG, "onCreate: started.");







    getIncomingIntent();

    }

    private void getIncomingIntent() {

        if (getIntent().hasExtra("images_m") && getIntent().hasExtra("imageNames_m")) {
        Log.d(TAG,"getIncomingIntent: found intent extras.");

            String mImages = getIntent().getStringExtra("images_m");
            String mNames = getIntent().getStringExtra("imageNames_m");

            setImage(mImages,mNames);
        }
    }

    private void setImage(String mImages, String mNames){
        Log.d(TAG,"setImage: setting to image and name widgets.");

        TextView name = findViewById(R.id.image_description);
        name.setText(mNames);


        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load (mImages)
                .into(image);

    }


    }
