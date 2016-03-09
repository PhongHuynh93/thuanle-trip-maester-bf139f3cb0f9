package vn.edu.hcmut.traffic.tripmaester.controller;

public interface IInjectedCallback<C extends ICallback<D>, D> {
    void onCompleted(D data, Object tag, Exception e);
}
