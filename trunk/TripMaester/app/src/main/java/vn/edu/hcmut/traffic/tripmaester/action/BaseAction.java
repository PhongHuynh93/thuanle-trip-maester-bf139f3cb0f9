package vn.edu.hcmut.traffic.tripmaester.action;

import vn.edu.hcmut.traffic.tripmaester.controller.Dispatcher;
import vn.edu.hcmut.traffic.tripmaester.controller.IAction;
import vn.edu.hcmut.traffic.tripmaester.controller.ICallback;

/**
 * Created by thuanle on 12/17/15.
 */
public abstract class BaseAction<T extends ICallback> implements IAction<T> {
    private Object mTag;
    private T mCallback;

    @Override
    public T getCallback() {
        return mCallback;
    }

    @Override
    public Object getTag() {
        return mTag;
    }

    @Override
    public void post() {
        Dispatcher.getInstance().doRequest(this);
    }

    @Override
    public void setCallback(T callback) {
        mCallback = callback;
    }

    @Override
    public void setTag(Object tag) {
        mTag = tag;
    }
}
