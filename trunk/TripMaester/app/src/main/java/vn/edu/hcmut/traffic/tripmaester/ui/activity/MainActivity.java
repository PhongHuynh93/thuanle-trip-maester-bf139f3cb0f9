package vn.edu.hcmut.traffic.tripmaester.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;

import org.osmdroid.util.GeoPoint;

import butterknife.Bind;
import butterknife.ButterKnife;
import vn.edu.hcmut.traffic.tripmaester.R;
import vn.edu.hcmut.traffic.tripmaester.action.ActionTripComment;
import vn.edu.hcmut.traffic.tripmaester.bussiness.Constant;
import vn.edu.hcmut.traffic.tripmaester.store.TMState;
import vn.edu.hcmut.traffic.tripmaester.ui.IMainScreen;
import vn.edu.hcmut.traffic.tripmaester.ui.drawer.LeftMenuDrawer;
import vn.edu.hcmut.traffic.tripmaester.ui.fragment.MapFragment;

public class MainActivity extends BaseActivity implements IMainScreen {
    @Bind(R.id.edtSearch)
    EditText mEdtSearch;

    @Bind(R.id.layoutMain)
    CoordinatorLayout mLayoutMain;

    Drawer mLeftMenu;

    private void bindListeners() {
        //search menu
        mEdtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onSearchTextChanged(s, start, before, count);
            }
        });
    }

    public void onClickFab(View view) {
        // TODO: 12/28/15 implement this
        Snackbar.make(view, "Click on Floating Button", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onClickLeftMenu(View view) {
        // TODO: 12/28/15  implement this
        mLeftMenu.openDrawer();
//        Snackbar.make(view, "Open left menu", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onClickRightMenu(View view) {
        // TODO: 12/28/15  implement this
        Snackbar.make(view, "Open right menu", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        bindListeners();

        syncFragment();

        initLeftMenu();
    }


    public void onSearchTextChanged(CharSequence s, int start, int before, int count) {
        // TODO: 12/28/15  implement this
        Snackbar.make(mLayoutMain, "Search " + s, Snackbar.LENGTH_SHORT).show();
    }

    private void syncFragment() {
        FragmentManager fm = getSupportFragmentManager();
        switch (TMState.getInstance().getCurrentScreen()) {
            case MapView:
                fm.beginTransaction().replace(R.id.fragContent, MapFragment.createInstance()).commit();
                break;
        }
    }

    public void initLeftMenu() {
        LeftMenuDrawer leftMenu = new LeftMenuDrawer.Builder()
                .setActivity(this)
                .setEmail("demo@mail.com")
                .setUser("Ken")
                .build();
        leftMenu.buildPreferenceSetting();
        mLeftMenu = leftMenu.getDrawer();

    }
}
