package vn.edu.hcmut.traffic.tripmaester.service.internal;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.location.LocationServices;

import vn.edu.hcmut.traffic.tripmaester.TMApp;
import vn.edu.hcmut.traffic.tripmaester.action.ActionLocationCurrent;
import vn.edu.hcmut.traffic.tripmaester.controller.Dispatcher;
import vn.edu.hcmut.traffic.tripmaester.controller.IAction;
import vn.edu.hcmut.traffic.tripmaester.controller.IController;

/**
 * Created by thuanle on 1/21/16.
 */
public class LocationCurrentController implements IController {
    private static final Class[] HANDLE_REQUEST = new Class[]{ActionLocationCurrent.class};

    @Override
    public Class[] getHandledRequests() {
        return HANDLE_REQUEST;
    }

    private Location getLastLocation() {
        if (ActivityCompat.checkSelfPermission(TMApp.getInstance(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(TMApp.getInstance(), Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        return LocationServices.FusedLocationApi.getLastLocation(TMApp.getApiClient());
    }

    @Override
    public void handleRequestInBackground(IAction request) {
        //Check permission & dialogs
        Location lastLocation = getLastLocation();
        if (lastLocation == null){
            Dispatcher.getInstance().deliverData(request, null, new LocationNotRetreived());
        } else {
            Dispatcher.getInstance().deliverData(request, lastLocation, null);
        }
    }
}
