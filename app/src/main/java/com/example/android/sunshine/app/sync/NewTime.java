package com.example.android.sunshine.app.sync;

import android.text.format.Time;

/**
 * Created by markgray on 3/3/16.
 *
 * Factoring out of obsolete Time class
 *
 */
public class NewTime {

    public Time time;
    public long gmtoff;

    public NewTime() {
        time = new Time();
        gmtoff = time.gmtoff;
    }

    public void setToNow() {
        time.setToNow();
    }


    public void set(long millis) {
        time.set(millis);
    }

    public static int getJulianDay(long millis, long gmtoff) {
        return Time.getJulianDay(millis, gmtoff);
    }

    public long setJulianDay(int julianDay) {
        return time.setJulianDay(julianDay);
    }
}
