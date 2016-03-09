package vn.edu.hcmut.traffic.tripmaester.ui.drawer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Gravity;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;

import vn.edu.hcmut.traffic.tripmaester.R;

/**
 * Created by Ken on 1/12/2016.
 */
public class LeftMenuDrawer {
    private static Drawer mLeftMenu;
    private static Activity mActivity;

    public Drawer getDrawer() {
        return mLeftMenu;
    }

    public void setDrawer(Drawer drawer) {
        mLeftMenu = drawer;
    }

    public void setActivity(Activity activity) {
        mActivity = activity;
    }

    public void buildPreferenceSetting() {
        addPreferenceItemLeftMenu("Transportation", R.drawable.ic_transportation);
        addPreferenceItemLeftMenu("Navigate", R.drawable.ic_navigate);
        addPreferenceItemLeftMenu("Show Traffic Info", R.drawable.ic_traffic);
        addPreferenceItemLeftMenu("Show Warning Info", R.drawable.ic_warning);
        mLeftMenu.addItem(new DividerDrawerItem());
        addOptionItemLeftMenu("Profile", R.drawable.ic_profile, null);
        addOptionItemLeftMenu("Trip", R.drawable.ic_trip, null);
        addOptionItemLeftMenu("Notification", R.drawable.ic_noti, "23");
        addOptionItemLeftMenu("Setting", R.drawable.ic_setting, null);
        mLeftMenu.addStickyFooterItem(new PrimaryDrawerItem()
                .withName("About")
                .withIcon(R.drawable.ic_info));
        updateNotification("22");
    }

    public void addPreferenceItemLeftMenu(String name, int icon) {
        SecondaryDrawerItem item = new SecondaryDrawerItem()
                .withName(name)
                .withIcon(icon);
        mLeftMenu.addItem(item);
    }

    public void addOptionItemLeftMenu(String name, int icon, String badge) {
        PrimaryDrawerItem item = new PrimaryDrawerItem()
                .withName(name)
                .withIcon(icon);
        if (badge != null)
            item.withBadge(badge);
        mLeftMenu.addItem(item);
    }

    public void updateNotification(String noti) {
        mLeftMenu.updateBadge(7, new StringHolder(noti));
    }

    public static class Builder {
        private Activity mActivity;
        private String mUser;
        private String mEmail;
        private Bitmap mAvatar;
        private Drawer leftDrawer;
        private AccountHeader mAccountHeader;

        public LeftMenuDrawer build() {
            LeftMenuDrawer leftMenuDrawer = new LeftMenuDrawer();
            buildAccountHeader();
            leftDrawer = new DrawerBuilder()
                    .withAccountHeader(mAccountHeader)
                    .withDrawerGravity(Gravity.LEFT)
                    .withActivity(mActivity)
                    .build();
            leftMenuDrawer.setDrawer(leftDrawer);
            leftMenuDrawer.setActivity(mActivity);
            return leftMenuDrawer;
        }

        private void buildAccountHeader() {
            mAccountHeader = new AccountHeaderBuilder()
                    .withActivity(mActivity)
                    .withHeaderBackground(R.drawable.header_background)
                    .addProfiles(
                            new ProfileDrawerItem()
                                    .withName(mUser)
                                    .withEmail(mEmail)
                                    .withIcon(R.drawable.avatar)
                    )
                    .withSelectionListEnabledForSingleProfile(false)
                    .build();
        }


        public Builder setActivity(Activity activity) {
            mActivity = activity;
            return this;
        }

        public Builder setUser(String name) {
            mUser = name;
            return this;
        }

        public Builder setEmail(String mail) {
            mEmail = mail;
            return this;
        }

        public Builder setAvatar(Bitmap avatar) {
            mAvatar = avatar;
            return this;
        }
    }
}
