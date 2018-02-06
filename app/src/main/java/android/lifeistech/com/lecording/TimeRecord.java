package android.lifeistech.com.lecording;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.realm.RealmObject;

/**
 * Created by s on 2018/01/19.
 */

public class TimeRecord extends RealmObject {
    public int startYear;
    public int startMonth;
    public int startDay;
    public int startHour;
    public int startMinute;
    public int endYear;
    public int endMonth;
    public int endDay;
    public int endHour;
    public int endMinute;
    public String subject;


}
