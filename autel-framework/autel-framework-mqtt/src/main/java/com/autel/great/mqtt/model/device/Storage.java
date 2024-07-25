package com.autel.great.mqtt.model.device;

public class Storage {

    private Long total;

    private Long used;

    public Storage() {
    }

    @Override
    public String toString() {
        return "Storage{" +
                "total=" + total +
                ", used=" + used +
                '}';
    }

    public Long getTotal() {
        return total;
    }

    public Storage setTotal(Long total) {
        this.total = total;
        return this;
    }

    public Long getUsed() {
        return used;
    }

    public Storage setUsed(Long used) {
        this.used = used;
        return this;
    }
}
