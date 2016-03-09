package vn.edu.hcmut.traffic.tripmaester.store;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Manage App Preferences
 * Created by thuanle on 12/22/15.
 */
public class TMPref {
    private SharedPreferences mPref;

    public TMPref(Context context, String name) {
        mPref = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public int getInt(String key, int defValue) {
        return mPref.getInt(key, defValue);
    }

    public String getString(String key, String defValue) {
        return mPref.getString(key, defValue);
    }
}
