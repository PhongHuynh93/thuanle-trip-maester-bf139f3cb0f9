package vn.edu.hcmut.traffic.tripmaester.controller;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * Created by thuanle on 12/16/15.
 */
public class Dispatcher {
    private static Dispatcher _INSTANCE;
    private Multimap<Class, IController> mController;
    private Multimap<Class, IInjectedCallback> mInjectedCallback;

    private Dispatcher() {
        mController = HashMultimap.create();
        mInjectedCallback = HashMultimap.create();
    }

    public static Dispatcher getInstance() {
        if (_INSTANCE == null) {
            synchronized (Dispatcher.class) {
                if (_INSTANCE == null) {
                    _INSTANCE = new Dispatcher();
                }
            }
        }
        return _INSTANCE;
    }

    public <R extends IAction<? extends ICallback<D>>, D> void deliverData(R request, D result, Exception e) {
        try {
            request.getCallback().onCompleted(result, request.getTag(), e);
        } catch (Exception ignored) {
        }

        for (IInjectedCallback callback : mInjectedCallback.get(request.getClass())) {
            try {
                callback.onCompleted(request, result, e);
            } catch (Exception ignored) {
            }
        }
    }


    public void doRequest(IAction request) {
        for (IController worker : mController.get(request.getClass())) {
            worker.handleRequestInBackground(request);
        }
    }

    @SuppressWarnings("unused")
    public void injectCallback(Class _class, IInjectedCallback callback) {
        mInjectedCallback.put(_class, callback);
    }

    public void registerController(IController controller) {
        for (Class key : controller.getHandledRequests()) {
            mController.put(key, controller);
        }
    }

    @SuppressWarnings("unused")
    public void unregisterController(IController controller) {
        for (Class key : controller.getHandledRequests()) {
            mController.remove(key, controller);
        }
    }

    @SuppressWarnings("unused")
    public void withdrawCallback(Class _class, IInjectedCallback callback) {
        mInjectedCallback.remove(_class, callback);
    }
}
