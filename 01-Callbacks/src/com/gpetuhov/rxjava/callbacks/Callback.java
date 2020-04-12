package com.gpetuhov.rxjava.callbacks;

public interface Callback {
    void pushData(double result);
    void pushError(Exception ex);
    void pushComplete();
}
