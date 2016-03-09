package vn.edu.hcmut.traffic.tripmaester.store;

/**
 * This manager manage the status of the screen & current status of the app.
 * <p/>
 * Created by thuanle on 12/25/15.
 */
public class TMState {
    private static TMState _INSTANCE;
    private Screen mCurrentScreen;
    private TMState() {
        mCurrentScreen = Screen.MapView;
    }

    public static TMState getInstance() {
        if (_INSTANCE == null) {
            synchronized (TMState.class) {
                if (_INSTANCE == null) {
                    _INSTANCE = new TMState();
                }
            }
        }
        return _INSTANCE;
    }

    public Screen getCurrentScreen() {
        return mCurrentScreen;
    }

    public void setCurrentScreen(Screen currentScreen) {
        mCurrentScreen = currentScreen;
    }

    public enum Screen {
        MapView
    }
}
