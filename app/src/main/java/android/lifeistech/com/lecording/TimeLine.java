package android.lifeistech.com.lecording;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.realm.Realm;

import static android.lifeistech.com.lecording.R.id.container;

public class TimeLine extends AppCompatActivity {
    public Realm realm;
    int height;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
        WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();

        realm =Realm.getDefaultInstance();

    }

    public void addTime() {

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);

        View view  = new View(this);



        layout.addView(view);




    }

    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
