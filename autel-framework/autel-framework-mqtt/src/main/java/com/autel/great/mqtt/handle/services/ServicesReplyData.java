package com.autel.great.mqtt.handle.services;

public class ServicesReplyData<T> {

    private ServicesErrorCode result;

    private T output;

    public ServicesReplyData() {
    }

    @Override
    public String toString() {
        return "DrcUpData{" +
                "result=" + result +
                ", output=" + output +
                '}';
    }

    public ServicesErrorCode getResult() {
        return result;
    }

    public ServicesReplyData<T> setResult(ServicesErrorCode result) {
        this.result = result;
        return this;
    }

    public T getOutput() {
        return output;
    }

    public ServicesReplyData<T> setOutput(T output) {
        this.output = output;
        return this;
    }
}