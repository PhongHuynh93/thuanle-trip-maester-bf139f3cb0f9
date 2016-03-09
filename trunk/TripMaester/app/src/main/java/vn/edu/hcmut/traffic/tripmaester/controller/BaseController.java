package vn.edu.hcmut.traffic.tripmaester.controller;

/**
 * Created by thuanle on 12/19/15.
 */
public abstract class BaseController<R extends IAction<? extends ICallback<D>>, D> implements IController {
    protected void deliverData(R request, D result, Exception e) {
        Dispatcher.getInstance().deliverData(request, result, e);
    }

    protected void deliverException(R request, Exception e) {
        deliverData(request, null, e);
    }

    protected void deliverResult(R request, D result) {
        deliverData(request, result, null);
    }
}
