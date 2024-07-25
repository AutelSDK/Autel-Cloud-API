package com.autel.great.mqtt.core;

import com.autel.great.mqtt.handle.events.EventsDataRequest;
import com.autel.great.mqtt.handle.events.EventsErrorCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventsReceiver<T> extends EventsDataRequest<T> {

    private String bid;

    private String sn;

    @Override
    public EventsErrorCode getResult() {
        return super.getResult();
    }

    @Override
    public EventsReceiver<T> setResult(EventsErrorCode result) {
        super.setResult(result);
        return this;
    }

    @Override
    public T getOutput() {
        return super.getOutput();
    }

    @Override
    public EventsReceiver<T> setOutput(T output) {
        super.setOutput(output);
        return this;
    }

    public String getBid() {
        return bid;
    }

    public EventsReceiver<T> setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public String getSn() {
        return sn;
    }

    public EventsReceiver<T> setSn(String sn) {
        this.sn = sn;
        return this;
    }
}
