package vn.edu.hcmut.traffic.tripmaester.service.internal;

import vn.edu.hcmut.traffic.tripmaester.controller.Dispatcher;

/**
 * Created by thuanle on 1/21/16.
 */
public class InternalControllerCenter {

    public static void registerControllers() {
        Dispatcher cc = Dispatcher.getInstance();

        cc.registerController(new LocationCurrentController());
    }
}
