package vn.edu.hcmut.traffic.tripmaester.store;

/**
 * Created by thuanle on 12/25/15.
 */
public class LoginManager {
    private static LoginManager _INSTANCE;

    private LoginManager() {
    }

    public static LoginManager getInstance() {
        if (_INSTANCE == null) {
            synchronized (LoginManager.class) {
                if (_INSTANCE == null) {
                    _INSTANCE = new LoginManager();
                }
            }
        }
        return _INSTANCE;
    }
}
