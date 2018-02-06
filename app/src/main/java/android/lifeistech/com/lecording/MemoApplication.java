package android.lifeistech.com.lecording;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by s on 2018/01/19.
 */

public class MemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
    }
}
