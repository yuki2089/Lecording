package android.lifeistech.com.lecording;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.realm.Realm;

public class TimeLine extends AppCompatActivity {
    public Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
    }

    public void addTime(Time time) {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);

        TextView scheduleNameTv = new TextView(this);
        scheduleNameTv.setText(time.schedule);

        TextView timeTv = new TextView(this);
        timeTv.setText(time.time);

        ImageView length = new ImageView(this);

    }
}
