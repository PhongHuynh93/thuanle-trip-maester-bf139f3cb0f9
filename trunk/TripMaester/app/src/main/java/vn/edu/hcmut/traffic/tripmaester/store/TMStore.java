package vn.edu.hcmut.traffic.tripmaester.store;

import de.greenrobot.event.EventBus;

/**
 * This is Store center, which provide interface for user to get current app states and broadcast event to UI
 * Created by thuanle on 12/29/15.
 */
public class TMStore {
    private static TMStore _INSTANCE;
    private EventBus mBus;

    private TMStore() {
        mBus = new EventBus();
    }

    public static TMStore getInstance() {
        if (_INSTANCE == null) {
            synchronized (TMStore.class) {
                if (_INSTANCE == null) {
                    _INSTANCE = new TMStore();
                }
            }
        }
        return _INSTANCE;
    }


}
