package vn.edu.hcmut.traffic.tripmaester.ui.fragment;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import butterknife.Bind;
import butterknife.ButterKnife;
import vn.edu.hcmut.traffic.tripmaester.R;
import vn.edu.hcmut.traffic.tripmaester.TMApp;
import vn.edu.hcmut.traffic.tripmaester.action.ActionLocationCurrent;
import vn.edu.hcmut.traffic.tripmaester.bussiness.Constant;
import vn.edu.hcmut.traffic.tripmaester.controller.ICallback;

/**
 * Created by thuanle on 12/29/15.
 */
public class MapFragment extends BaseFragment {
    private static MapFragment _instance;
    @Bind(R.id.map)
    MapView mMap;

    public static MapFragment createInstance() {
        if (_instance == null) {
            _instance = new MapFragment();
        }
        return _instance;
    }

    public void onStart() {
        super.onStart();
        TMApp.connectApiClient();

    }

    public void onStop() {
        super.onStop();
        TMApp.disconnectApiClient();
    }

    private void initMap() {
        mMap.setTileSource(TileSourceFactory.MAPQUESTOSM);
        mMap.setBuiltInZoomControls(false);
        mMap.setMultiTouchControls(true);

        final IMapController mapController = mMap.getController();
        mapController.setZoom(Constant.ZOOM_LVL);

        // TODO: 12/28/15 get current location and navigate to current location.
//        mapController.setCenter(Constant.mCurrentLocation);
        new ActionLocationCurrent.Builder()
                .setCallback(new ICallback<Location>() {
                    @Override
                    public void onCompleted(Location data, Object tag, Exception e) {
                        if (e == null){
                            mapController.setCenter(new GeoPoint(data));
                        }
                    }
                });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this, view);
        initMap();
        return view;
    }
}
