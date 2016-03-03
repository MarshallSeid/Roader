package com.example.marchness.androidappskeleton;

/**
 * Created by Marchness on 3/2/16.
 */
import com.firebase.client.Firebase;

public class ExtendApplication extends android.app.Application {
        @Override
        public void onCreate() {
            super.onCreate();

            Firebase.setAndroidContext(this);
        }
}
