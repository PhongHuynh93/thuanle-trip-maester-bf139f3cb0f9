package vn.edu.hcmut.traffic.tripmaester.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import vn.edu.hcmut.traffic.tripmaester.TMApp;

/**
 * Created by thuanle on 12/27/15.
 */
public class BaseFragment extends Fragment {
    protected Tracker mTracker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
