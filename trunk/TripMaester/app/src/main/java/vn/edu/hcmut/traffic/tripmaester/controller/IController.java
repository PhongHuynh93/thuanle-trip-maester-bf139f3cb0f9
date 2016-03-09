package vn.edu.hcmut.traffic.tripmaester.controller;

/**
 * Created by thuanle on 12/16/15.
 */
public interface IController {
    Class[] getHandledRequests();

    void handleRequestInBackground(IAction request);
}
