package vn.edu.hcmut.traffic.tripmaester.service.http;


import vn.edu.hcmut.traffic.tripmaester.controller.Dispatcher;

/**
 * Created by thuanle on 12/18/15.
 */
public class HttpControllerCenter {

    private static HttpControllerCenter _INSTANCE;

    public static HttpControllerCenter getInstance() {
        if (_INSTANCE == null) {
            synchronized (HttpControllerCenter.class) {
                if (_INSTANCE == null) {
                    _INSTANCE = new HttpControllerCenter();
                }
            }
        }
        return _INSTANCE;
    }

    public void registerControllers() {
        Dispatcher cc = Dispatcher.getInstance();

//        cc.registerController(new CommentTripController());
    }
}
