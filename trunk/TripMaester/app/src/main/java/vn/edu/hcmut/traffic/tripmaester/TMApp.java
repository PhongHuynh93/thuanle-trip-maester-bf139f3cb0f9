package vn.edu.hcmut.traffic.tripmaester;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.facebook.FacebookSdk;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import io.fabric.sdk.android.Fabric;
import vn.edu.hcmut.traffic.tripmaester.controller.ControllerFactory;

/**
 * Created by thuanle on 12/16/15.
 */
public class TMApp extends Application implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static TMApp _INSTANCE;
    private static Tracker mTracker;
    private static GoogleApiClient mGoogleApiClient;

    public static TMApp getInstance() {
        return _INSTANCE;
    }

    public static Tracker getTracker() {
        return mTracker;
    }

    public static GoogleApiClient getApiClient() {
        return mGoogleApiClient;
    }

    private void initializeLibraries() {
        //initial crashlytics
        Fabric.with(this, new Crashlytics());

        //initial Facebook
        FacebookSdk.sdkInitialize(this);

        //initialize Google Analytics
        GoogleAnalytics mAnalytics = GoogleAnalytics.getInstance(this);
        mTracker = mAnalytics.newTracker(R.xml.global_tracker);

        //initial Google API Client
        mGoogleApiClient = new GoogleApiClient.Builder(_INSTANCE)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        _INSTANCE = this;

        ControllerFactory.createControllers();

        initializeLibraries();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    public static void connectApiClient() {
        mGoogleApiClient.connect();
    }

    public static void disconnectApiClient() {
        mGoogleApiClient.disconnect();
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
