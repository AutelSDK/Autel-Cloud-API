package com.autel.great.mqtt.handle.events;

public class EventsDataRequest<T> {

    private EventsErrorCode result;

    private T output;

    public EventsDataRequest() {
    }

    @Override
    public String toString() {
        return "EventsDataRequest{" +
                "result=" + result +
                ", output=" + output +
                '}';
    }

    public EventsErrorCode getResult() {
        return result;
    }

    public EventsDataRequest<T> setResult(EventsErrorCode result) {
        this.result = result;
        return this;
    }

    public T getOutput() {
        return output;
    }

    public EventsDataRequest<T> setOutput(T output) {
        this.output = output;
        return this;
    }
}
