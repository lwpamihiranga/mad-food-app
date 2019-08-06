package lk.my.sliit.it18106398.foodapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodMain extends AppCompatActivity {

    private  static  final  String TAG = "FoodMain";

    //vari

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_main);

        Log.d(TAG,"onCreate: started.");

        initImageBitmaps();


    }
    private  void initImageBitmaps(){
        Log.d(TAG,"initImageBitmaps: preparing bitmaps.");

        mImages.add("sandwitch.jpg");
        mNames.add("Sandwitches");

        mImages.add("cheeskottu.jpg");
        mNames.add("Chees Kottu");

        mImages.add("friedrice.jpg");
        mNames.add("Friedrice");


        //mImages.add("");
        //mNames.add("");


       // mImages.add("");
        //mNames.add("");

        //mImages.add("");
        //mNames.add("");

        initRecycleView();

    }

    private  void initRecycleView(){
        Log.d(TAG, "initRecycleView: init recycleview.");
        RecyclerView recyclerView =findViewById(R.id.recycler_view);
        FoodAdapter adapter = new FoodAdapter(this,mNames,mImages);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
