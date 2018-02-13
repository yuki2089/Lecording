package android.lifeistech.com.lecording;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmResults;

import static android.R.attr.endY;
import static android.R.attr.startYear;

public class MainActivity extends AppCompatActivity {
    public Realm realm;
    int startYear;
    int startMonth;
    int startDay;
    int startHour;
    int startMinute;
    int endYear;
    int endMonth;
    int endDay;
    int endHour;
    int endMinute;
    String subject;
    long length;

    boolean isCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
    }

    public void save(final int startYear, final int startMonth, final int startDay, final int startHour, final int startMinute, final int endYear, final int endMonth, final int endDay, final int endHour, final int endMinute,final String subject, final long length) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm beRealm) {
                TimeRecord timeRecord = realm.createObject(TimeRecord.class);
                timeRecord.startYear = startYear;
                timeRecord.startMonth = startMonth;
                timeRecord.startDay = startDay;
                timeRecord.startHour = startHour;
                timeRecord.startMinute = startMinute;
                timeRecord.endYear = endYear;
                timeRecord.endMonth =endMonth;
                timeRecord.endDay = endDay;
                timeRecord.endHour = endHour;
                timeRecord.endMinute = endMinute;
                timeRecord.subject = subject;
                timeRecord.length=length;

            }
        });
    }


    public void getUp(View v) {
        isCheck = !isCheck;
        Date date  = new Date();
        Calendar calendar1 = new GregorianCalendar();
        Calendar calendar2 = new GregorianCalendar();

        if(isCheck = true){
            subject = "sleeping";
            startYear = getYear(date);
            startMonth = getMonth(date);
            startDay = getDay(date);
            startHour = getHour(date);
            startMinute = getMinute(date);
            calendar1 = new GregorianCalendar(startYear, startMonth, startDay,startHour, startMinute);

        }else {
            endYear = getYear(date);
            endMonth = getMonth(date);
            endDay = getDay(date);
            endHour = getHour(date);
            endMinute = getMinute(date);
            calendar2 = new GregorianCalendar(endYear, endMonth,endDay,endHour,endMinute);


            long time1 = calendar1.getTimeInMillis();
            long time2 = calendar2.getTimeInMillis();
            length = (time2 - time1) / 1000 * 60;

            save(startYear, startMonth, startDay, startHour, startMinute,endYear,endMonth,endDay,endHour,endMinute, subject,length);
            finish();


        }

    }





    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    public int getYear(Date date){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy", Locale.JAPANESE);
        int year = Integer.parseInt(sdf.format(date));

        return year;
    }

    public int getMonth(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM", Locale.JAPANESE);
        int month = Integer.parseInt(sdf.format(date));
        return month;
    }

    public int getDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd", Locale.JAPANESE);
        int day = Integer.parseInt(sdf.format(date));
        return day;
    }

    public int getHour(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH", Locale.JAPANESE);
        int hour = Integer.parseInt(sdf.format(date));
        return hour;
    }

    public int getMinute(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("mm", Locale.JAPANESE);
        int minute = Integer.parseInt(sdf.format(date));
        return minute;
    }






}
