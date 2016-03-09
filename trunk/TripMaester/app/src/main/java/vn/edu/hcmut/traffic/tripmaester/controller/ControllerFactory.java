package vn.edu.hcmut.traffic.tripmaester.controller;


import vn.edu.hcmut.traffic.tripmaester.service.http.HttpControllerCenter;
import vn.edu.hcmut.traffic.tripmaester.service.internal.InternalControllerCenter;

/**
 * Created by thuanle on 12/17/15.
 */
public class ControllerFactory {
    /**
     * Create concrete controllers and register to Dispatcher
     */
    public static void createControllers() {
        HttpControllerCenter.getInstance().registerControllers();
        InternalControllerCenter.registerControllers();
    }
}
