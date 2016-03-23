package com.example.android.sunshine.app.sync;

import android.text.format.Time;
import android.util.Log;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by markgray on 3/3/16.
 *
 * Factoring out of obsolete Time class
 *
 */
public class NewTime {

    private static final String TAG = "NewTime";

    public final long gmtoffGC;
    public Time time;
    public GregorianCalendar gc;
    public long gmtoff;

    public NewTime() {
        time = new Time();
        GregorianCalendar gc = new GregorianCalendar();
        gmtoffGC = gc.get(Calendar.DST_OFFSET) + gc.get(Calendar.ZONE_OFFSET);
        gmtoff = time.gmtoff;
        if (gmtoff != gmtoffGC) {
            Log.i(TAG, "Error: gmtoff=" + gmtoff + " gmtoffGC=" + gmtoffGC);
        } else {
            Log.i(TAG, "gmtoff=" + gmtoff + " gmtoffGC=" + gmtoffGC);
        }
    }

    public void setToNow() {
        gc.setTimeInMillis(System.currentTimeMillis());
        time.setToNow();
        if (gc.getTimeInMillis() != time.toMillis(true)) {
            Log.i(TAG, "Error: gc=" + gc.getTimeInMillis() + " time=" + time.toMillis(true));
        } else {
            Log.i(TAG, "gc=" + gc.getTimeInMillis() + " time=" + time.toMillis(true));
        }
    }


    public void set(long millis) {
        gc.setTimeInMillis(millis);
        time.set(millis);
        if (gc.getTimeInMillis() != time.toMillis(true)) {
            Log.i(TAG, "Error: gc=" + gc.getTimeInMillis() + " time=" + time.toMillis(true));
        } else {
            Log.i(TAG, "gc=" + gc.getTimeInMillis() + " time=" + time.toMillis(true));
        }
    }

    public static int getJulianDay(long millis, long gmtoff) {
        GregorianCalendar tempGC = new GregorianCalendar();
        tempGC.setTimeInMillis(millis);
        tempGC.set(Calendar.ZONE_OFFSET, (int) gmtoff);
        if (tempGC.get(Calendar.DAY_OF_YEAR) != Time.getJulianDay(millis, gmtoff)) {
            Log.i(TAG, "Error: GregorianCalendar Julian=" + tempGC.getTimeInMillis() + "Time Julian=" + Time.getJulianDay(millis, gmtoff));
        } else {
            Log.i(TAG, "GregorianCalendar Julian=" + tempGC.getTimeInMillis() + "Time Julian=" + Time.getJulianDay(millis, gmtoff));
        }

        return Time.getJulianDay(millis, gmtoff);
    }

    public long setJulianDay(int julianDay) {
        return time.setJulianDay(julianDay);
    }
}

