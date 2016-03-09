package vn.edu.hcmut.traffic.tripmaester.action;

import android.location.Location;

import vn.edu.hcmut.traffic.tripmaester.controller.ICallback;

/**
 * Created by thuanle on 1/21/16.
 */
public class ActionLocationCurrent extends BaseAction<ICallback<Location>> {
    public static class Builder{
        private ICallback<Location> mCallback;
        private Object mTag;

        private ActionLocationCurrent build(){
            ActionLocationCurrent action = new ActionLocationCurrent();
            action.setCallback(mCallback);
            action.setTag(mTag);
            return action;
        }

        public Builder setTag(Object tag){
            mTag = tag;
            return this;
        }

        public void setCallback(ICallback<Location> callback){
            mCallback = callback;
            build().post();
        }
    }
}
