package vn.edu.hcmut.traffic.tripmaester.action;


import vn.edu.hcmut.traffic.tripmaester.controller.ICallback;

/**
 * Created by thuanle on 12/17/15.
 */
public abstract class BaseHttpTripAction<T extends ICallback> extends BaseHttpAction<T> {
    private String mTripId;

    public String getTripId() {
        return mTripId;
    }

    public void setTripId(String tripId) {
        mTripId = tripId;
    }
}
