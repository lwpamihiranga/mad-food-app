package lk.my.sliit.it18106398.foodapp;

import android.app.Application;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class FireLearnForPromo extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //FirebaseDatabase.setAndroidContext(this);

        if(FirebaseApp.getApps(this).isEmpty()){
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
    }
}
