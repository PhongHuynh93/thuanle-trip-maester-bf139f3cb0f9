package vn.edu.hcmut.traffic.tripmaester.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import vn.edu.hcmut.traffic.tripmaester.TMApp;

/**
 * Created by thuanle on 12/27/15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTracker = TMApp.getTracker();
    }

    @Override
    public void onResume() {
        super.onResume();
        mTracker.setScreenName(this.getClass().getName());
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
